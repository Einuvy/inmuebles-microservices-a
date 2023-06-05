package com.einuvy.inmueble.controllers;

import com.einuvy.inmueble.DTO.InmuebleCreationDTO;
import com.einuvy.inmueble.models.Inmueble;
import com.einuvy.inmueble.services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @PostMapping("")
    public ResponseEntity<?> saveInmueble(@RequestBody InmuebleCreationDTO inmuebleDTO){
        return new ResponseEntity<>(inmuebleService.saveInmueble(inmuebleDTO), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id){
        inmuebleService.deleteInmueble(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllInmuebles(){
        return new ResponseEntity<>( inmuebleService.findAllInmueble() ,OK);
    }
}
