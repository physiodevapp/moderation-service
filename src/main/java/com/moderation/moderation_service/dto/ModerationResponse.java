package com.moderation.moderation_service.dto;

public class ModerationResponse {

  private boolean isValid;

  public ModerationResponse(boolean isValid) {
    this.isValid = isValid;
  }

  public boolean isValid() {
    return isValid;
  }
  
}

