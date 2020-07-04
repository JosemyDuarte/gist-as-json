package io.josemyduarte.gistasjson;

import org.junit.jupiter.api.Test;

import java.net.URI;

import static io.josemyduarte.gistasjson.GistConverterResource.GIST_URL;
import static org.junit.jupiter.api.Assertions.*;

class UrlCheckerTest {

    @Test
    void givenAGistHttpsUrl_whenCheckingValidity_thenIsValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, URI.create("https://gist.githubusercontent.com/JosemyDuarte/7892331a75bf3412af78f0df1b82bf07/raw/169c97bfca829013d8076ba574bcaef18ada37b5/search.py"));
        assertTrue(result);
    }

    @Test
    void givenAGistHttpUrl_whenCheckingValidity_thenIsValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, URI.create("http://gist.githubusercontent.com/JosemyDuarte/7892331a75bf3412af78f0df1b82bf07/raw/169c97bfca829013d8076ba574bcaef18ada37b5/search.py"));
        assertTrue(result);
    }

    @Test
    void givenANotGistUrl_whenCheckingValidity_thenIsNotValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, URI.create("https://quarkus.io/guides/rest-client"));
        assertFalse(result);
    }

    @Test
    void givenAEmptyURL_whenCheckingValidity_thenIsNotValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, URI.create(""));
        assertFalse(result);
    }

    @Test
    void givenANullURL_whenCheckingValidity_thenIsNotValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, null);
        assertFalse(result);
    }

    @Test
    void givenNotValidURL_whenCheckingValidity_thenIsNotValid() {
        final boolean result = UrlChecker.isValid(GIST_URL, URI.create("SomethingWeird"));
        assertFalse(result);
    }
}