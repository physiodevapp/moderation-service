package com.moderation.moderation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moderation.moderation_service.dto.ModerationRequest;
import com.moderation.moderation_service.dto.ModerationResponse;

import com.moderation.moderation_service.service.ModerationService;

@RestController
@RequestMapping("/moderation")

public class ModerationController {

  private final ModerationService moderationService;

  public ModerationController(ModerationService moderationService) {
    this.moderationService = moderationService;
  }

  @PostMapping("/validate-message")
  public ResponseEntity<ModerationResponse> validateMessage(@RequestBody ModerationRequest request) {
    boolean isValid = moderationService.validateMessage(request.getMessage());
    return ResponseEntity.ok(new ModerationResponse(isValid));
  }
}
