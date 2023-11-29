package com.eme22.imageapi.util;

import com.eme22.imageapi.model.Category;
import com.eme22.imageapi.model.Endpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.eme22.imageapi.util.Endpoints.*;

public class Examples {

    public static Endpoint waifuEndpoint() {

        Endpoint endpoint = new Endpoint();

        endpoint.setName(WAIFU);
        endpoint.setBaseUrl(Endpoints.WAIFU_BASEURL);
        endpoint.setResponseJsonPathRegex(true);
        endpoint.setResponseJsonPath(defaultPath);

        Collection<Category> sfw = Arrays.stream(Endpoints.WAIFU_SFW.values()).map( data -> {

            Category category = new Category();

            category.setName(data.toString().toLowerCase());
            Collection<String> paths = new ArrayList<>();
            paths.add(SFW);
            paths.add(data.toString().toLowerCase());
            category.setPaths(paths);
            category.setNsfw(false);

            return category;
        }).collect(Collectors.toList());

        Collection<Category> nsfw = Arrays.stream(Endpoints.WAIFU_NSFW.values()).map( data -> {

            Category category = new Category();

            category.setName(data.toString().toLowerCase());
            Collection<String> paths = new ArrayList<>();
            paths.add(NSFW);
            paths.add(data.toString().toLowerCase());
            category.setPaths(paths);
            category.setNsfw(true);

            return category;
        }).collect(Collectors.toList());

        sfw.addAll(nsfw);

        endpoint.setCategories(sfw);

        return endpoint;
    }

    public static Endpoint nekosEndpoint() {

        Endpoint endpoint = new Endpoint();

        endpoint.setName(NEKOS);
        endpoint.setBaseUrl(Endpoints.NEKOS_BASEURL);
        endpoint.setResponseJsonPathRegex(true);
        endpoint.setResponseJsonPath(defaultPath);

        Collection<Category> sfw = Arrays.stream(Endpoints.NEKO.values()).map( data -> {

            Category category = new Category();

            category.setName(data.toString().toLowerCase());
            category.setPaths(Collections.singletonList(data.toString().toLowerCase()));
            category.setNsfw(false);

            return category;
        }).collect(Collectors.toList());

        endpoint.setCategories(sfw);

        return endpoint;
    }

    public static Endpoint hmEndpoint() {

        Endpoint endpoint = new Endpoint();

        endpoint.setName(HM);
        endpoint.setBaseUrl(Endpoints.HM_BASEURL);
        endpoint.setResponseJsonPathRegex(true);
        endpoint.setResponseJsonPath(defaultPath);

        Collection<Category> sfw = Arrays.stream(Endpoints.HM_SFW.values()).map( data -> {

            Category category = new Category();

            category.setName(data.toString().toLowerCase());
            Collection<String> paths = new ArrayList<>();
            paths.add(SFW);
            paths.add(data.toString().toLowerCase());
            category.setPaths(paths);
            category.setNsfw(false);

            return category;
        }).collect(Collectors.toList());

        Collection<Category> nsfw = Arrays.stream(Endpoints.HM_NSFW.values()).map( data -> {

            Category category = new Category();

            category.setName(data.toString().toLowerCase());
            Collection<String> paths = new ArrayList<>();
            paths.add(NSFW);
            paths.add(data.toString().toLowerCase());
            category.setPaths(paths);
            category.setNsfw(true);

            return category;
        }).collect(Collectors.toList());

        sfw.addAll(nsfw);

        endpoint.setCategories(sfw);

        return endpoint;
    }

    public static Endpoint kawaiiEndpoint() {

            Endpoint endpoint = new Endpoint();

            endpoint.setName(KAWAII);
            endpoint.setBaseUrl(KAWAII_BASEURL);
            endpoint.setResponseJsonPathRegex(true);
            endpoint.setResponseJsonPath(defaultPath);

            Collection<Category> sfw = Arrays.stream(Endpoints.KAWAII_SFW.values()).map( data -> {

                Category category = new Category();

                category.setName(data.toString().toLowerCase());
                Collection<String> paths = new ArrayList<>();
                paths.add(SFW);
                paths.add(data.toString().toLowerCase());
                category.setPaths(paths);
                category.setNsfw(false);

                return category;
            }).collect(Collectors.toList());

            Collection<Category> nsfw = Arrays.stream(Endpoints.KAWAII_NSFW.values()).map( data -> {

                Category category = new Category();

                category.setName(data.toString().toLowerCase());
                Collection<String> paths = new ArrayList<>();
                paths.add(NSFW);
                paths.add(data.toString().toLowerCase());
                category.setPaths(paths);
                category.setNsfw(true);

                return category;
            }).collect(Collectors.toList());

            sfw.addAll(nsfw);

            endpoint.setCategories(sfw);

            return endpoint;
    }

    public static Endpoint anotherKawaiiEndpoint() {

            Endpoint endpoint = new Endpoint();

            endpoint.setName(ANOTHER_KAWAII);
            endpoint.setBaseUrl(KAWAII_ANOTHER_BASEURL);
            endpoint.setResponseJsonPathRegex(true);
            endpoint.setResponseJsonPath(defaultPath);

            Collection<Category> sfw = Arrays.stream(Endpoints.KAWAII_SFW.values()).map( data -> {

                Category category = new Category();

                category.setName(data.toString().toLowerCase());
                Collection<String> paths = new ArrayList<>();
                paths.add(SFW);
                paths.add(data.toString().toLowerCase());
                category.setPaths(paths);
                category.setNsfw(false);

                return category;
            }).collect(Collectors.toList());

            Collection<Category> nsfw = Arrays.stream(Endpoints.KAWAII_NSFW.values()).map( data -> {

                Category category = new Category();

                category.setName(data.toString().toLowerCase());
                Collection<String> paths = new ArrayList<>();
                paths.add(NSFW);
                paths.add(data.toString().toLowerCase());
                category.setPaths(paths);
                category.setNsfw(true);

                return category;
            }).collect(Collectors.toList());

            sfw.addAll(nsfw);

            endpoint.setCategories(sfw);

            return endpoint;
    }


}
