package com.eme22.anime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {

    private static final Logger log = LogManager.getLogger(Util.class);

    public static final String WAIFU_BASEURL = "https://api.waifu.pics";
    public static final String NEKOS_BASEURL = "https://nekos.life/api/v2/img";
    public static final String KAWAII_BASEURL = "https://kawaii.up.railway.app/api/v1";
    public static final String HM_BASEURL = "https://hmtai.hatsunia.cfd";

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static String getString(String url) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Url: "+ url);
        log.warn("Url: "+ response.statusCode());

        String responseBody = response.body();

        System.out.println("Body: "+ responseBody);
        log.warn("Body: "+ responseBody);

        JSONObject jsonObject = new JSONObject(responseBody);

        return jsonObject.optString("url", null);
    }

    protected static Image getBuffer(String url) throws Exception {
        BufferedInputStream stream = new BufferedInputStream(new URL(url).openStream());
        return new Image(stream, url);
    }

    protected static String getURL(String baseUrl, Boolean nsfw, String type) throws URISyntaxException, IOException, InterruptedException {
            String url;
            if (nsfw != null)
                url = String.format("%s/%s/%s", baseUrl, nsfw ? "nsfw" : "sfw", type);
            else
                url = String.format("%s/%s", baseUrl, type);

            return getString(url);
    }

}
