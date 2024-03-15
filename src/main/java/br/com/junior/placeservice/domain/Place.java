package br.com.junior.placeservice.domain;

import java.time.LocalDateTime;


public record Place(Long id, String name, String state, LocalDateTime createdAt, LocalDateTime updatedAt) { 
}
