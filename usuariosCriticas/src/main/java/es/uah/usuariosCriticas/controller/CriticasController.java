package es.uah.usuariosCriticas.controller;

import es.uah.usuariosCriticas.model.Critica;
import es.uah.usuariosCriticas.service.ICriticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriticasController {

    @Autowired
    ICriticasService criticasService;

    @GetMapping("/criticas")
    public List<Critica> buscarTodas() {
        return criticasService.buscarTodas();
    }

    @GetMapping("/criticas/pelicula/{idPelicula}")
    public List<Critica> buscarCriticasPorIdPelicula(@PathVariable("idPelicula") Integer idPelicula) {
        return criticasService.buscarCriticasPorIdPelicula(idPelicula);
    }

    @GetMapping("/criticas/{id}")
    public Critica buscarCriticaPorId(@PathVariable("id") Integer id) {
        return criticasService.buscarCriticaPorId(id);
    }

    @PostMapping("/criticas")
    public void guardarCritica(@RequestBody Critica critica) {
        criticasService.guardarCritica(critica);
    }

    @PutMapping("/criticas")
    public void actualizarCritica(@RequestBody Critica critica) {
        criticasService.guardarCritica(critica);
    }

    @DeleteMapping("/criticas/{id}")
    public void eliminarCritica(@PathVariable("id") Integer id) {
        criticasService.eliminarCritica(id);
    }

}
