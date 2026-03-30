package com.mateus.shared;

public record UserRequest(
    String email,
    String correlationId
) {}