package com.fruit.app.controller;

import com.fruit.app.dto.output.StandardResponseDTO;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

 class Controller {
    <T extends StandardResponseDTO> void updateHttpStatus(T responseDTO, HttpServletResponse response) {
        switch (responseDTO.getStatus()) {
            case SUCCESS:
                response.setStatus(HttpStatus.OK.value());
                break;
            case CONFLICT:
                response.setStatus(HttpStatus.CONFLICT.value());
                break;
            case CREATED:
                response.setStatus(HttpStatus.CREATED.value());
                break;
            default:
                response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
    }

}
