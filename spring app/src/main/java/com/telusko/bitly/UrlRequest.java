package com.telusko.bitly;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UrlRequest {
    public UrlRequest() {}

    private String longUrl;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {
        return "UrlRequest{" +
                "longUrl='" + longUrl + '\'' +
                '}';
    }
}
