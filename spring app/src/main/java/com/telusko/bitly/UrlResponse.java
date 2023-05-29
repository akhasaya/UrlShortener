package com.telusko.bitly;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class UrlResponse {

    public UrlResponse(String sUrl) {
        this.shortUrl = sUrl;
    }
    private String shortUrl;
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
