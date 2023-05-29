package com.telusko.bitly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import static java.lang.Math.max;
import static java.lang.Math.min;


@Service
class UrlService {

    Set<String> urls = new HashSet<>();
    Map<String, String> bitly = new HashMap<>();
    @Autowired
    Base62Encoder base62;

    public String generateNewUrl(String longUrl) {
        int count = 0;
        if (bitly.containsKey(longUrl))
            return bitly.get(longUrl);

        String encoded;
        int l;
        String shortUrl;
        do {
            count += 1;
            System.out.println("generating new short url, count = " + count);
            if (count > 1) {
                encoded = base62.encode(longUrl + count);
            } else {
                encoded = base62.encode(longUrl);
            }
            l = min(6, encoded.length());
            shortUrl = StringUtils.right(encoded,l);
        } while (urls.contains(shortUrl));
        urls.add(shortUrl);
        bitly.put(longUrl, "bitly/" + shortUrl);
        return "bitly/" + shortUrl;
    }
}