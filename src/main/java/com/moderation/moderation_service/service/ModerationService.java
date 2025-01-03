package com.moderation.moderation_service.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@Service
public class ModerationService {

  private final RestTemplate restTemplate = new RestTemplate();
  private final String flaskUrl;

  public ModerationService(@Value("${flask.url}") String flaskUrl) {
    this.flaskUrl = flaskUrl;
  }

  public boolean validateMessage(String message) {
    if (containsBlacklistedWords(message)) {
      return false;
    }

    Map<String, String> request = new HashMap<>();
    request.put("message", message);

     Map<String, Object> response = restTemplate.exchange(
        flaskUrl,
        HttpMethod.POST,
        new HttpEntity<>(request),
        new ParameterizedTypeReference<Map<String, Object>>() {}
    ).getBody();

    return !(Boolean) response.get("isOffensive");
  }

  private boolean containsBlacklistedWords(String message) {
    List<String> blackList = List.of("spam", "malicious");
    
    return blackList.stream().anyMatch(message.toLowerCase()::contains);
  }
  
}
