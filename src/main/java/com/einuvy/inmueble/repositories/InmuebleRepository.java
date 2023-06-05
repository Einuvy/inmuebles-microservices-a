package com.einuvy.inmueble.repositories;

import com.einuvy.inmueble.models.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}