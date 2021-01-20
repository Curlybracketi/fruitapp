package com.fruit.app.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fruit.app.dto.enums.Status;

import java.io.Serializable;

public class StandardResponseDTO implements Serializable {
    @JsonProperty
    protected Status status;

    public StandardResponseDTO() {
    }

    StandardResponseDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
