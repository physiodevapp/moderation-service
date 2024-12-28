package com.moderation.moderation_service.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@Service
public class ModerationService {

  private final RestTemplate restTemplate = new RestTemplate();

  public boolean validateMessage(String message) {
    if (containsBlacklistedWords(message)) {
      return false;
    }

    String url = "http://localhost:5000/predict";
    Map<String, String> request = new HashMap<>();
    request.put("message", message);

     Map<String, Object> response = restTemplate.exchange(
        url,
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
