package com.eme22.anime;

import static com.eme22.anime.Util.*;

public class AnimeImageClient {



    public String getImage(Endpoints.NEKO endpoint){
        return Util.getURL(NEKOS_BASEURL, null, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.NEKO endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.KAWAII_SFW endpoint){
        return Util.getURL(KAWAII_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.KAWAII_NSFW endpoint){
        return Util.getURL(KAWAII_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.KAWAII_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.KAWAII_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.HM_SFW endpoint){
        return Util.getURL(HM_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.HM_NSFW endpoint){
        return Util.getURL(HM_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.HM_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.HM_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getImage(Endpoints.WAIFU_SFW endpoint){
        return Util.getURL(WAIFU_BASEURL, false, endpoint.toString().toLowerCase());
    }

    public String getImage(Endpoints.WAIFU_NSFW endpoint){
        return Util.getURL(WAIFU_BASEURL, true, endpoint.toString().toLowerCase());
    }

    public Image downloadImage(Endpoints.WAIFU_SFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public Image downloadImage(Endpoints.WAIFU_NSFW endpoint) throws Exception {
        return getBuffer(getImage(endpoint));
    }

    public String getEightBall(){ return getURL(NEKOS_BASEURL, null, "8ball"); }

}
