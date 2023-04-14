package com.eme22.anime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.eme22.anime.Util.*;

public class AnimeImageClient {

    private static final Logger log = LogManager.getLogger(AnimeImageClient.class);

    public String getImage(Endpoints.NEKO endpoint) throws IOException, URISyntaxException, InterruptedException {

        String image = Util.getURL(NEKOS_BASEURL, null, endpoint.toString().toLowerCase());

        log.debug("Imagen Recibida desde la url"+ image);

        return image;
    }

    public Image downloadImage(Endpoints.NEKO endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.KAWAII_SFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(KAWAII_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.KAWAII_NSFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(KAWAII_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.KAWAII_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.KAWAII_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.HM_SFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(HM_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.HM_NSFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(HM_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.HM_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.HM_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.WAIFU_SFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(WAIFU_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.WAIFU_NSFW endpoint) throws IOException, URISyntaxException, InterruptedException {
        return Util.getURL(WAIFU_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.WAIFU_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.WAIFU_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getEightBall() throws IOException, URISyntaxException, InterruptedException { return getURL(NEKOS_BASEURL, null, "8ball"); }

}
