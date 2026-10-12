package com.example.newsapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewsController {

    @GetMapping("/")
    public String home() {
        return "News application is running. Open /news to retrieve headlines.";
    }

    @GetMapping("/news")
    public String getNews() {
        String apiKey = System.getenv("NEWS_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            return "Error: NEWS_API_KEY is not configured. Set the environment variable and restart the app.";
        }

        String url = UriComponentsBuilder
                .fromUriString("https://newsapi.org/v2/top-headlines")
                .queryParam("country", "in")
                .queryParam("apiKey", apiKey)
                .build()
                .encode()
                .toUriString();

        return new RestTemplate().getForObject(url, String.class);
    }
}
