package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.paginator.PageRender;
import es.uah.clienteFilmaff.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cactores")
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/listado")
    public String listadoActores(Model model, @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> listado = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/listado",listado);
        model.addAttribute("titulo", "Listado de los Actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page",pageRender);
        return "actores/listActores";
    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {
        model.addAttribute("titulo", "Nuevo Actor/Actriz");
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        //model.addAttribute("listadoActores", actorList);
        return "actores/formActores";
    }
}
