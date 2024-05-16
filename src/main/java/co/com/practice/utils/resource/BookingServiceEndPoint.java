package co.com.practice.utils.resource;

import co.com.practice.utils.constants.Endpoints;

public enum BookingServiceEndPoint {
    URI(Endpoints.BOOKING);

    private final String url;

    BookingServiceEndPoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
