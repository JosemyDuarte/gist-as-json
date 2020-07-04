package io.josemyduarte.gistasjson;

import java.net.URI;
import java.util.Objects;

public final class UrlChecker {

    public static boolean isValid(final String expectedHost, final URI receivedURL) {
        if (Objects.isNull(receivedURL)) {
            return false;
        }
        final String host = receivedURL.getHost();
        return Objects.equals(expectedHost, host);
    }
}
