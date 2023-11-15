package com.eme22.imageapi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Endpoint implements Serializable {
    private String name;
    private String baseUrl;
    private Boolean urlRegex = false;
    private Boolean responseJsonPathRegex = false;
    private String responseJsonPath;
    private Collection<Category> categories;


}
