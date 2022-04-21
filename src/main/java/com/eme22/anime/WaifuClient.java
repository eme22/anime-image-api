package com.eme22.anime;

import java.net.URL;

import static com.eme22.anime.Util.getBuffer;
import static com.eme22.anime.Util.getString;

public class WaifuClient {
    /**
     * Gets an SFW image from the API
     * Possible sfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getSFWImage(Endpoints.WAIFU_SFW endpoint) {
        return getURL(false, endpoint.toString().toLowerCase());
    }

    /**
     * Gets an NSFW image from the API
     * Possible nsfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getNSFWImage(Endpoints.WAIFU_NSFW endpoint) {
        return getURL(true, endpoint.toString().toLowerCase());
    }

    /**
     * Downloads an SFW image from the API
     * Possible sfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return file buffer
     */
    public Image downloadSFWImage(Endpoints.WAIFU_SFW endpoint) throws Exception {
        return getBuffer(getSFWImage(endpoint));
    }

    /**
     * Downloads an NSFW image from the API
     * Possible nsfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return file buffer
     */
    public Image downloadNSFWImage(Endpoints.WAIFU_NSFW endpoint) throws Exception {
        return getBuffer(getNSFWImage(endpoint));
    }

    private String getURL(boolean nsfw, String type) {
        String rating = nsfw ? "nsfw" : "sfw";

        try {
            URL url = new URL(String.format("%s/%s/%s", Util.WAIFU_BASEURL, rating, type));
            return getString(url);
        } catch (Exception ignored) { }

        return "";
    }
}
