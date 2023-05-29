package com.telusko.bitly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitlyController {
    @Autowired
    UrlService urlservice;

    @PostMapping("/url")
    public UrlResponse getShortUrl(@RequestBody UrlRequest req) {
        String longUrl = req.getLongUrl();
        String sUrl = urlservice.generateNewUrl(longUrl);
        System.out.println("LongUrl: "+ req.getLongUrl() + " short url: " + sUrl);
        return new UrlResponse(sUrl);
    }
}
