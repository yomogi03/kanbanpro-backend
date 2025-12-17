package com.example.kanbanpro.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBoardRequest(
    @NotBlank(message = "name is required")
    @Size(min = 1, max = 100, message = "name must be between 1 and 100 characters")
    String name
) {}

