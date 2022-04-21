package com.eme22.anime;

import java.io.BufferedInputStream;
import java.net.URLConnection;

public class Image {
    public byte[] buffer;
    public String mimeType;
    public String filename;
    public String extension;

    Image(BufferedInputStream stream, String url) throws Exception {
        this.mimeType = URLConnection.guessContentTypeFromStream(stream);
        this.buffer = stream.readAllBytes();
        this.filename = url.substring(Util.WAIFU_BASEURL.length());

        this.extension = filename.substring(filename.lastIndexOf(".") + 1).trim();
    }
}
