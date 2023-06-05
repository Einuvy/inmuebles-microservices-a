package com.einuvy.inmueble.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.einuvy.inmueble.models.Inmueble}
 */

@Getter
public class InmuebleCreationDTO implements Serializable {
    private String name;
    private String address;
    private String image;
    private Double price;
}