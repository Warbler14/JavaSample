package com.lotus.jewel.sample.http.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
public class HttpClientExample3_2 {
    public static void main(String[] args) {
        try {
            String result = blockIP("1.1.1.1");
            System.out.println(result);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Send a POST request to Cloudflare API to block an IP address. Authentication in headers.
    public static String blockIP(String ip) throws IOException {
        String result = "";

        HttpPost post = new HttpPost("https://api.cloudflare.com/client/v4/user/firewall/access_rules/rules");
        post.addHeader("content-type", "application/json");
        post.addHeader("X-Auth-Email", "email");
        post.addHeader("X-Auth-Key", "token123");

        String block = "{\"target\":\"ip\",\"value\":\"" + ip + "\"}";

        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"mode\":\"block\",");
        entity.append("\"configuration\":" + block + ",");
        entity.append("\"notes\":\"hello\"");
        entity.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(entity.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
}
