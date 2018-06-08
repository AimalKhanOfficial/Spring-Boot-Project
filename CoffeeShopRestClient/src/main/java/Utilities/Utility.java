package Utilities;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Base64;


public class Utility {
    public static HttpHeaders createHttpHeaders()
    {
        String notEncoded = "super" + ":" + "pw";
        String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", encodedAuth);
        return headers;
    }
}
