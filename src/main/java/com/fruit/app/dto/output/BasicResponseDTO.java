package com.fruit.app.dto.output;

import com.fruit.app.dto.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BasicResponseDTO implements Serializable {
    @JsonProperty
    private Status status;
    @JsonProperty
    private  Object data;

        public BasicResponseDTO() {
        }

        public BasicResponseDTO(Status status) {
            this.status = status;
        }

        public BasicResponseDTO(Status status, Object data) {
            this.status = status;
            this.data = data;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

