package com.lotus.jewel.sample.api;

/* Java 1.8 샘플 코드 */


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {

        //https://www.data.go.kr/data/15094277/openapi.do

        String serviceKey = "XTIpiAacHMGhmQB7wHRB7Ys8%2BmX%2Bf1rDpchgskbkx6dEG3EnZuftYnJPz0bnM644C4VZcWlO0PYvniAKwvkPWQ%3D%3D";

        String targetIp = "202.30.50.51";


        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551505/whois/ipas_country_code"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("query","UTF-8") + "=" + URLEncoder.encode(targetIp, "UTF-8")); /*IP 주소 또는 AS 번호*/
        urlBuilder.append("&" + URLEncoder.encode("answer","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
                //+ URLEncoder.encode("xml", "UTF-8")); /*응답형식(XML/JSON) 을 지정(없으면 XML으로 응답)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }

}