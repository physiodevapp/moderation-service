package com.moderation.moderation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moderation.moderation_service.dto.ModerationRequest;
import com.moderation.moderation_service.dto.ModerationResponse;

@RestController
@RequestMapping("/moderation")

public class ModerationController {

  @PostMapping("/validate-message")
  public ResponseEntity<ModerationResponse> validateMessage(@RequestBody ModerationRequest request) {
    boolean isValid = !request.getMessage().toLowerCase().contains("spam");
    return ResponseEntity.ok(new ModerationResponse(isValid));
  }
}
