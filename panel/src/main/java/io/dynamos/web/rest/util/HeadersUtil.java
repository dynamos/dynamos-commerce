package io.dynamos.web.rest.util;

import org.springframework.http.HttpHeaders;

/**
 * Created by adelmo.pereira on 24/04/2017.
 */
public final class HeadersUtil {

    private HeadersUtil() {
    }

    public static HttpHeaders createAlert(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-dynamosPanel-alert", message);
        return headers;
    }

    public static HttpHeaders successAlert() {
        return createAlert("Success: The operation has been completed");
    }

    public static HttpHeaders errorAlert() {
        return createAlert("Error: An error occurred and the operation was not completed");
    }

    public static HttpHeaders infoAlert() {
        return createAlert("Info: ");
    }

}
