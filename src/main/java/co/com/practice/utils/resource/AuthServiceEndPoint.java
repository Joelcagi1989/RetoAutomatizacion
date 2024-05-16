package co.com.practice.utils.resource;

import co.com.practice.utils.constants.Endpoints;

public enum AuthServiceEndPoint {
    URI(Endpoints.AUTH);

    private final String url;

    AuthServiceEndPoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
