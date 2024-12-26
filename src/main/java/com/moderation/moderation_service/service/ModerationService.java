package com.moderation.moderation_service.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModerationService {

  private final List<String> blackList = List.of("spam", "offenssive", "malicious");

  public boolean validateMessage(String message) {
    return blackList.stream().noneMatch(message.toLowerCase()::contains);
  }
  
}
