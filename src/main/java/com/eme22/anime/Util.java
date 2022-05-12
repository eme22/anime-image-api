package com.eme22.anime;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Util {

    public static final String WAIFU_BASEURL = "https://api.waifu.pics";
    public static final String NEKOS_BASEURL = "https://nekos.life/api/v2/img";
    public static final String KAWAII_BASEURL = "https://kawaii.up.railway.app/api/v1";
    public static final String HM_BASEURL = "https://hmtai.herokuapp.com/";

    public static String getString(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getURL());
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        JsonObject json = new Gson().fromJson(reader, JsonObject.class);

        return json.get("url").getAsString();
    }

    protected static Image getBuffer(String url) throws Exception {
        BufferedInputStream stream = new BufferedInputStream(new URL(url).openStream());
        return new Image(stream, url);
    }

    protected static String getURL(String baseUrl, Boolean nsfw, String type) {
        try {
            URL url;
            if (nsfw != null)
                url = new URL(String.format("%s/%s/%s", baseUrl, nsfw ? "nsfw" : "sfw", type));
            else
                url = new URL(String.format("%s/%s", baseUrl, type));

            return getString(url);
        } catch (Exception ignored) { }

        return "";
    }
}
