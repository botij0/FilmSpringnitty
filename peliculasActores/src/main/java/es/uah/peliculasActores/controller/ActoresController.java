package es.uah.peliculasActores.controller;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/actores")
    public List<Actor> buscarTodos(){
        return actoresService.buscarTodos();
    }

    @GetMapping("/actores/{id}")
    public Actor buscarActorPorId(@PathVariable("id") Integer id){
        return actoresService.buscarActorPorId(id);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actor> buscarActorPorNombre(@PathVariable("nombre") String nombre) {
        return actoresService.buscarActorPorNombre(nombre);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor) {
        actoresService.guardarActor(actor);
    }

    @PutMapping("/actores")
    public void actualizarAlumno(@RequestBody Actor actor) {
        actoresService.actualizarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public void eliminarAlumno(@PathVariable("id") Integer id) {
        actoresService.eliminarActor(id);
    }

    @GetMapping("/actores/anrep/{ida}/{idp}")
    public void aniadirRepartoActor(@PathVariable("ida") Integer ida, @PathVariable("idp") Integer idp) {
        actoresService.aniadirRepartoActor(ida,idp);
    }

}
