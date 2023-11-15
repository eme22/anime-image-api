package com.eme22.imageapi.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class Image {
    public byte[] buffer;
    public String mimeType;
    public String filename;
    public String extension;

    Image(BufferedInputStream stream, String url) throws IOException {
        this.mimeType = URLConnection.guessContentTypeFromStream(stream);
        this.buffer = readAllBytes(stream);
        this.filename = url.substring(url.lastIndexOf("/") + 1);
        this.extension = filename.substring(filename.lastIndexOf(".") + 1).trim();
    }

    private static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 1024;
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
                outputStream.write(buf, 0, readLen);

            return outputStream.toByteArray();
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) inputStream.close();
            else try {
                inputStream.close();
            } catch (IOException e) {
                exception.addSuppressed(e);
            }
        }
    }
}
