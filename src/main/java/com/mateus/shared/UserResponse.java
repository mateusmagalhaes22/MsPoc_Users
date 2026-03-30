package com.mateus.shared;

public record UserResponse(
    String email,
    String password,
    String correlationId
) {}