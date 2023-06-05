package com.einuvy.inmueble.DTO;

import com.einuvy.inmueble.models.Inmueble;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.einuvy.inmueble.models.Inmueble}
 */

@Getter
public class InmuebleDTO implements Serializable {
    private final Long id;
    private final String name;
    private final String address;
    private final String image;
    private final Double price;
    @JsonFormat(pattern = "dd/MM/yy - HH:mm:ss")
    private final LocalDateTime creationDate;

    public InmuebleDTO(Inmueble inmueble) {
        this.id = inmueble.getId();
        this.name = inmueble.getName();
        this.address = inmueble.getAddress();
        this.image = inmueble.getImage() == null ? "https://vbbabogados.com/wp-content/uploads/2017/09/defectos-inmueble.jpg":inmueble.getImage();
        this.price = inmueble.getPrice();
        this.creationDate = inmueble.getCreationDate();
    }
}