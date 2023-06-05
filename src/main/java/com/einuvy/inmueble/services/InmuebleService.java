package com.einuvy.inmueble.services;

import com.einuvy.inmueble.DTO.InmuebleCreationDTO;
import com.einuvy.inmueble.DTO.InmuebleDTO;
import com.einuvy.inmueble.models.Inmueble;
import com.einuvy.inmueble.repositories.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface InmuebleService {

    InmuebleDTO saveInmueble(InmuebleCreationDTO inmuebleDTO);

    void deleteInmueble(Long id);

    List<InmuebleDTO> findAllInmueble();
}
