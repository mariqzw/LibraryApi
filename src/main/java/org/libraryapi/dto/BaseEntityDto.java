package org.libraryapi.dto;

import java.util.UUID;

public abstract class BaseEntityDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
