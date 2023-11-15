package com.eme22.imageapi;

import com.eme22.imageapi.model.Category;
import com.eme22.imageapi.model.Endpoint;
import com.eme22.imageapi.util.Image;
import com.eme22.imageapi.util.Util;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.eme22.imageapi.util.Endpoints.*;
import static com.eme22.imageapi.util.Util.getBuffer;
import static com.eme22.imageapi.util.Util.parseEndpoint;

@Log4j2
public class AnimeImageClient {

    @Setter
    private HttpClient httpClient = HttpClients.createDefault();
    @Getter @Setter
    private Collection<Endpoint> endpoints = new ArrayList<>();

    public AnimeImageClient() {
        registerEndPoints(Util.getDefaultEndpoints());
    }

    public AnimeImageClient(boolean addDefault) {
        if (addDefault) {
            registerEndPoints(Util.getDefaultEndpoints());
        }
    }

    public AnimeImageClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        registerEndPoints(Util.getDefaultEndpoints());
    }

    public AnimeImageClient(HttpClient httpClient, boolean addDefault) {
        this.httpClient = httpClient;
        if (addDefault) {
            registerEndPoints(Util.getDefaultEndpoints());
        }
    }

    public AnimeImageClient(Collection<Endpoint> endpoints) {
        this.endpoints = endpoints;
        registerEndPoints(Util.getDefaultEndpoints());
    }

    public AnimeImageClient(Collection<Endpoint> endpoints, boolean addDefault) {
        this.endpoints = endpoints;
        if (addDefault) {
            registerEndPoints(Util.getDefaultEndpoints());
        }
    }

    public AnimeImageClient(HttpClient httpClient, Collection<Endpoint> endpoints) {
        this.httpClient = httpClient;
        this.endpoints = endpoints;
    }

    public AnimeImageClient(HttpClient httpClient, Collection<Endpoint> endpoints, boolean addDefault) {
        this.httpClient = httpClient;
        this.endpoints = endpoints;
        if (addDefault) {
            registerEndPoints(Util.getDefaultEndpoints());
        }
    }

    public void registerEndPoint(Endpoint endpoint){
        log.info("Registering endpoint: "+ endpoint.getName());
        endpoints.add(endpoint);
    }

    public void registerEndPoints(Collection<Endpoint> endpoints){
        endpoints.forEach(this::registerEndPoint);
    }

    public void unregisterEndPoint(Endpoint endpoint){
        log.info("Removing endpoint: "+ endpoint.getName());
        endpoints.remove(endpoint);
    }

    public void unregisterEndPoints(Collection<Endpoint> endpoints){
        endpoints.forEach(this::unregisterEndPoint);
    }

    public String getHMEndPoint(String category) {
        return getImage(HM, category);
    }

    public String getHMEndPoint(HM_NSFW category) {
        return getImage(HM, category.toString());
    }

    public String getHMEndPoint(HM_SFW category) {
        return getImage(HM, category.toString());
    }

    public String getNekosEndPoint(String category) {
        return getImage(NEKOS, category);
    }

    public String getNekosEndPoint(NEKO category) {
        return getImage(NEKOS, category.toString());
    }

    public String getWaifuEndPoint(String category) {
        return getImage(WAIFU, category);
    }

    public String getWaifuEndPoint(WAIFU_NSFW category) {
        return getImage(WAIFU, category.toString());
    }

    public String getWaifuEndPoint(WAIFU_SFW category) {
        return getImage(WAIFU, category.toString());
    }

    public String getImage(String endpoint, String category) {

        Endpoint endpoint1 = Util.findEndpointByName(endpoints, endpoint);

        if (endpoint1 == null) throw new IllegalArgumentException("Endpoint "+endpoint+" not found");

        Category category1 = Util.findCategoryByName(endpoint1.getCategories(), category);

        if (category1 == null) throw new IllegalArgumentException("Category "+category+" not found");

        String image = null;
        try {
            image = parseEndpoint(httpClient, endpoint1, category1);
        } catch (IOException e) {
            throw new IllegalArgumentException("Endpoint "+endpoint+" not found", e);
        }

        log.debug("Imagen Recibida desde la url"+ image);

        return image;
    }

    public Image downloadHMImage(String category) {
        return downloadImage(HM, category);
    }

    public Image downloadNekosImage(String category) {
        return downloadImage(NEKOS, category);
    }

    public Image downloadWaifuImage(String category) {
        return downloadImage(WAIFU, category);
    }

    public Image downloadWaifuImage(WAIFU_SFW category) {
        return downloadImage(WAIFU, category.toString());
    }

    public Image downloadWaifuImage(WAIFU_NSFW category) {
        return downloadImage(WAIFU, category.toString());
    }

    public Image downloadHMImage(HM_SFW category) {
        return downloadImage(HM, category.toString());
    }

    public Image downloadHMImage(HM_NSFW category) {
        return downloadImage(HM, category.toString());
    }


    public Image downloadNekosImage(NEKO category) {
        return downloadImage(NEKOS, category.toString());
    }

    public Image downloadImage(String endpoint, String category) {
        try {
            return getBuffer(getImage(endpoint, category));
        } catch (IOException e) {
            throw new IllegalArgumentException("Endpoint "+endpoint+" not found", e);
        }
    }




}
