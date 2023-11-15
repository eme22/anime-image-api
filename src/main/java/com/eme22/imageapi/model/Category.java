package com.eme22.imageapi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Category implements Serializable {
    private String name;
    private Collection<String> paths;
    private Boolean nsfw = false;
    private Boolean overrrideResponseJsonPath = false;
    private String responseJsonPath;

}
