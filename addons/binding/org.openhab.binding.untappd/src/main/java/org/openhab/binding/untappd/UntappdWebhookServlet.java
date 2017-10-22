package org.openhab.binding.untappd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.eclipse.smarthome.config.discovery.DiscoveryService;
import org.openhab.binding.untappd.discovery.UntappdDiscoveryService;
import org.openhab.binding.untappd.gson.User;
import org.openhab.binding.untappd.gson.oauth.Authorize;
import org.openhab.binding.untappd.handler.RetroFitService;
import org.openhab.io.net.http.SecureHttpContext;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UntappdWebhookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(UntappdWebhookServlet.class);

    private static final String UNTAPPD_AUTH_URL = "https://untappd.com/oauth/authenticate/?client_id=%s&response_type=code&redirect_url=%s";

    private static final String UNTAPPD_CODE_URL = "https://untappd.com/oauth/authorize/?client_id=%s&client_secret=%s&response_type=code&redirect_url=%s&code=%s";

    private static final String SERVLET_NAME = "/untappd";

    private HttpService httpService;

    private UntappdAuth auth = UntappdAuth.get();

    private UntappdDiscoveryService ds;

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    public void unsetHttpService(HttpService httpService) {
        this.httpService = null;
    }

    public void setDiscoveryService(DiscoveryService service) {
        if (service instanceof UntappdDiscoveryService) {
            this.ds = (UntappdDiscoveryService) service;
        }
    }

    public void unsetDiscoveryService(DiscoveryService service) {
        this.ds = null;
    }

    protected void activate() {
        try {
            logger.debug("Starting Untappd servlet at " + SERVLET_NAME);

            Hashtable<String, String> props = new Hashtable<String, String>();
            httpService.registerServlet(SERVLET_NAME, this, props, createHttpContext());
        } catch (Exception ex) {
            logger.error("Error during Untappd servlet startup", ex);
        }
    }

    protected void deactivate() {
        httpService.unregister(SERVLET_NAME);
    }

    private HttpContext createHttpContext() {
        HttpContext defaultHttpContext = httpService.createDefaultHttpContext();
        return new SecureHttpContext(defaultHttpContext, "openHAB.org");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>openHAB Untappd binding</h1>");

        String code = request.getParameter("code");
        if (!StringUtils.isBlank(code)) {
            String url = String.format(UNTAPPD_CODE_URL, auth.getClientId(), auth.getClientSecret(),
                    request.getRequestURL().toString(), code);

            UntappdService service = RetroFitService.getUntappdService();
            Authorize authorize = service.auth(url).execute().body();

            if (authorize.getResponse() != null && !StringUtils.isBlank(authorize.getResponse().getAccessToken())) {
                out.println("Authentication succesful! An Untappd item should appear in your inbox.");

                String token = authorize.getResponse().getAccessToken();
                User user = service.info(token).execute().body().getResponse().getUser();
                String userName = user.getUserName();
                ds.newThing(token, userName);
            } else {
                out.println("Something went wrong. Please try again");
            }
        } else if (StringUtils.isBlank(auth.getClientId()) || StringUtils.isBlank(auth.getClientSecret())) {
            out.println(
                    "Configure Client ID and Secret first. In the Paper UI, go to Configuration, Bindings, Untappd Binding, Configure.");
        } else {
            out.println(
                    "Looks like you're all set, hit the Authenticate button to authenticate with Untappd.<br/><br/>");
            out.println("<form method='post'><input type='submit' value='Authenticate'></form>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = String.format(UNTAPPD_AUTH_URL, auth.getClientId(), request.getRequestURL().toString());
        response.sendRedirect(url);
    }

}
