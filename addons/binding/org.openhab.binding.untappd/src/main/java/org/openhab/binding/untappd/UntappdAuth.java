package org.openhab.binding.untappd;

public class UntappdAuth {

    private String clientId;

    private String clientSecret;

    private static final UntappdAuth instance = new UntappdAuth();

    public static UntappdAuth get() {
        return instance;
    }

    String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
