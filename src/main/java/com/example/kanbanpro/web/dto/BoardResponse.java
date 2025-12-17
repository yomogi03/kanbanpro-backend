package com.example.kanbanpro.web.dto;

import java.time.LocalDateTime;

public record BoardResponse(
        Long id,
        String name,
        LocalDateTime registDate,
        LocalDateTime updateDate
) {
}

