package com.lotus.jewel.sample.regix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UrlRegexTest {

    // 정규식 패턴 정의
    private static final String URL_REGEX =
            "^(https?:\\/\\/)?" +                       // HTTP 또는 HTTPS (선택 사항)
                    "([\\w-]+\\.)+[\\w-]+" +            // 도메인 이름
                    "(:\\d+)?" +                        // 포트 번호 (선택 사항)
                    "(\\/[\\w\\-\\.\\~]*)*" +           // 경로 (선택 사항)
                    "(\\?[\\w\\-\\=\\&]*)?" +           // 쿼리 문자열 (선택 사항)
                    "(\\#[\\w\\-]*)?$";                 // 프래그먼트 식별자 (선택 사항)

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    private static final String URL_PATTERN_2 = "^(https?:\\/\\/)?([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d+)?(\\/.*)?$";

    private static final Pattern URL_PATTERN2 = Pattern.compile(URL_PATTERN_2);


    private static final Set<String> GOOD_URLS = new HashSet<>(
            Arrays.asList(
                    "http://example.com",
                    "https://example.com",
                    "https://www.example.com",
                    "https://example.com/path/to/resource",
                    "https://example.com:8080",
                    "https://example.com?query=param",
                    "https://example.com#fragment"));

    private static final Set<String> BAD_URLS = new HashSet<>(
            Arrays.asList(
                    null,
                    "",
                    "example",
                    "http//example.com",
                    "https://",
                    "https:/example.com",
                    "ftp://example.com"));


    // URL 유효성 검사 메서드
    private boolean isValidUrl(String url) {
        if (url == null) {
            return false;
        }
        return URL_PATTERN.matcher(url).matches();
    }

    private boolean isValidUrl(Pattern pattern, String url) {
        if (url == null) {
            return false;
        }
        return pattern.matcher(url).matches();
    }

    public void testValidUrls() {
        GOOD_URLS.forEach(url ->  {
            System.out.println(url + " " + isValidUrl(url));
        });
    }

    public void testInvalidUrls() {
        BAD_URLS.forEach(url ->   {
            System.out.println(url + " " + isValidUrl(url));
        });
    }

    public void testValidUrls2() {
        GOOD_URLS.forEach(url ->  {
            System.out.println(url + " " + isValidUrl(URL_PATTERN2, url));
        });
    }

    public void testInvalidUrls2() {
        BAD_URLS.forEach(url ->   {
            System.out.println(url + " " + isValidUrl(URL_PATTERN2, url));
        });
    }

    public static void main(String[] args) {
        UrlRegexTest test = new UrlRegexTest();

        //test.testValidUrls();
        //test.testInvalidUrls();

        test.testValidUrls2();
        test.testInvalidUrls2();
    }
}

