package com.lotus.jewel.sample.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientExample5_4 {

    public static void main(String[] args) {
        try {
            doRequest();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Configure a proxy server. Read HttpClient proxy configuration
    public static void doRequest() throws IOException {

        HttpGet request = new HttpGet("https://httpbin.org/get");

        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(new HttpHost("company.proxy.url", 8080))
                .build();

        request.setConfig(requestConfig);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }
    }
}
