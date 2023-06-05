package com.einuvy.inmueble.services.Implementations;

import com.einuvy.inmueble.DTO.InmuebleCreationDTO;
import com.einuvy.inmueble.DTO.InmuebleDTO;
import com.einuvy.inmueble.models.Inmueble;
import com.einuvy.inmueble.repositories.InmuebleRepository;
import com.einuvy.inmueble.services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class InmuebleServiceImplements implements InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Override
    public InmuebleDTO saveInmueble(InmuebleCreationDTO inmuebleDTO){
        Inmueble inmueble = new Inmueble(inmuebleDTO.getName(),inmuebleDTO.getAddress(),inmuebleDTO.getImage(),inmuebleDTO.getPrice());
        return new InmuebleDTO(inmuebleRepository.save(inmueble));
    }

    @Override
    public void deleteInmueble(Long id){
        inmuebleRepository.deleteById(id);
    }

    @Override
    public List<InmuebleDTO> findAllInmueble(){
        return inmuebleRepository.findAll().stream().map(inmueble -> new InmuebleDTO(inmueble)).collect(toList());
    }

}
