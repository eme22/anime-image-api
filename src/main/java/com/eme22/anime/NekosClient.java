package com.eme22.anime;

import java.net.URL;

import static com.eme22.anime.Util.getBuffer;
import static com.eme22.anime.Util.getString;

public class NekosClient {

    /**
     * Gets an SFW image from the API
     * Possible sfw endpoints at https://nekos.life/api/v2/endpoints
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getImage(Endpoints.NEKO endpoint) {
        return getURL(endpoint.toString().toLowerCase());
    }

    /**
     * Downloads an image from the API
     * Possible nsfw endpoints at https://nekos.life/api/v2/endpoints
     * @param endpoint the endpoint to query
     * @return file buffer
     */
    public Image downloadImage(Endpoints.NEKO endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getEightBall(){ return getURL("8ball"); }

    private String getURL(String type) {

        try {
            URL url = new URL(String.format("%s/%s", Util.NEKOS_BASEURL, type));
            return getString(url);
        } catch (Exception ignored) { }

        return "";
    }

}
