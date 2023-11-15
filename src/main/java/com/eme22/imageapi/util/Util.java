package com.eme22.imageapi.util;

import com.eme22.imageapi.model.Category;
import com.eme22.imageapi.model.Endpoint;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class Util {

    public static String getResponse(HttpClient client, String url) throws IOException {

        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {

            log.debug("Response Status: "+ response.getStatusLine().getReasonPhrase());

            return EntityUtils.toString(response.getEntity());
        }
    }

    public static Image getBuffer(String url) throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new URL(url).openStream());
        return new Image(stream, url);
    }

    public static String parseEndpoint(HttpClient httpClient, Endpoint endpoint1, Category category1) throws IOException {
        String imageUrl = Util.getURL(endpoint1.getBaseUrl(), category1.getPaths());

        log.debug("URL: "+ imageUrl);

        String response = Util.getResponse(httpClient, imageUrl);

        log.debug("Response: "+ response);

        return Util.getResponseData(response, category1.getOverrrideResponseJsonPath() ? category1.getResponseJsonPath() : endpoint1.getResponseJsonPath(), endpoint1.getResponseJsonPathRegex());
    }

    public static String getURL(String baseUrl, Collection<String> paths) throws IOException {

        if (!baseUrl.contains("%s")) {
            return baseUrl + String.join("/", paths);
        }

        for (String path : paths) {
            baseUrl = baseUrl.replaceFirst("%s", path);
        }

        return baseUrl;
    }

    public static String getResponseData(String response, String regex, Boolean jsonPath) {
        if (jsonPath) {
            return JsonPath.read(response, regex);
        }
        else {
            return findPattern(response, regex);
        }
    }

    private static String findPattern(String response, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    public static Endpoint findEndpointByName(Collection<Endpoint> endpoints, String name){
        for (Endpoint endpoint : endpoints) {
            if (endpoint.getName().equalsIgnoreCase(name)) return endpoint;
        }
        return null;
    }

    public static Category findCategoryByName(Collection<Category> categories, String name){
        for (Category endpoint : categories) {
            if (endpoint.getName().equalsIgnoreCase(name)) return endpoint;
        }
        return null;
    }

    public static Collection<Endpoint> getDefaultEndpoints() {
        Collection<Endpoint> endpoints = new ArrayList<>();
        endpoints.add(Examples.waifuEndpoint());
        endpoints.add(Examples.nekosEndpoint());
        endpoints.add(Examples.hmEndpoint());
        return endpoints;
    }
}
