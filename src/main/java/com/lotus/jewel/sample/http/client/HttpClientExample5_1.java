package com.lotus.jewel.sample.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientExample5_1 {

    public static void main(String[] args) {
        try {
            doRequest();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Send Normal POST Request
    public static void doRequest() throws IOException {

        HttpGet request = new HttpGet("https://t.co/calv72DH8f");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 301
            System.out.println(response.getStatusLine().getReasonPhrase()); // Moved Permanently
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 301 Moved Permanently

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }
    }
}
