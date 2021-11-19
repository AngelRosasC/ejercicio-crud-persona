package com.gruposalinas.ejercicio.WebService.repositories;

import com.gruposalinas.ejercicio.WebService.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
