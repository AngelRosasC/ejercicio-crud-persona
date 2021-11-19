package com.gruposalinas.ejercicio.WebService.controllers;

import com.gruposalinas.ejercicio.WebService.models.Persona;
import com.gruposalinas.ejercicio.WebService.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping(path = "/persona/todos")
    public @ResponseBody
    Iterable<Persona> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping(path = "/persona/crear")
    public @ResponseBody
    String agregarPersona(@RequestParam String nombre, @RequestParam String apellido_paterno, @RequestParam String apellido_materno, @RequestParam int edad, @RequestParam double peso, @RequestParam double estatura, @RequestParam String estado_civil) {
        Persona persona = new Persona(nombre, apellido_paterno, apellido_materno, edad, peso, estatura, estado_civil);
        personaRepository.save(persona);
        return "Persona guardada.";
    }

    @PutMapping(path = "/persona/actualizar/{id}")
    public @ResponseBody
    String actualizarPersona(@PathVariable("id") int persona_id, @RequestParam String nombre, @RequestParam String apellido_paterno, @RequestParam String apellido_materno, @RequestParam int edad, @RequestParam double peso, @RequestParam double estatura, @RequestParam String estado_civil) {
        if (!personaRepository.existsById(persona_id)) return "Esta persona no existe.";

        Persona persona = new Persona(nombre, apellido_paterno, apellido_materno, edad, peso, estatura, estado_civil);
        personaRepository.save(persona);
        return "Esta persona ha sido actualizada.";
    }

    @DeleteMapping(path = "persona/eliminar/{id}")
    public String eliminarPersona(@PathVariable("id") int persona_id) {
        if (!personaRepository.existsById(persona_id)) return "Esta persona no existe.";
        Optional<Persona> persona = personaRepository.findById(persona_id);
        personaRepository.deleteById(persona_id);
        return "Persona eliminada";
    }
}
