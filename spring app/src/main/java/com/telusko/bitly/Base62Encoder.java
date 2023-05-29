package com.telusko.bitly;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(String input) {
        long number = 0;

        // Calculate a unique number for the input string
        for (int i = 0; i < input.length(); i++) {
            number = number * 256 + (int) input.charAt(i);
        }

        // Convert the number to Base62 encoding
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % 62);
            sb.insert(0, CHARACTERS.charAt(remainder));
            number /= 62;
        }

        if (sb.length() == 0) {
            sb.append(CHARACTERS.charAt(0));
        }

        return sb.toString();
    }
}
