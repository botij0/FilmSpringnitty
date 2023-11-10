package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.paginator.PageRender;
import es.uah.clienteFilmaff.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cpeliculas")
public class PeliculasController {
    @Autowired
    IPeliculasService peliculasService;

    @GetMapping(value = {"/", "/home", ""})
    public String home (Model model){
        return "home";
    }

    @GetMapping(value = "/home2")
    public String home2 (Model model){
        return "home2";
    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {
        model.addAttribute("titulo", "Nueva Pelicula");
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/buscar")
    public String buscar (Model model){
        return "peliculas/searchPelicula";
    }

    @GetMapping("/listado")
    public String listadoPeliculas(Model model, @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/cpeliculas/listado",listado);
        model.addAttribute("titulo", "Listado de todas las Peliculas");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page",pageRender);
        return "peliculas/listPeliculas";
    }

    @GetMapping("/listado2")
    public String listadoPeliculas2(Model model, @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/cpeliculas/listado",listado);
        model.addAttribute("titulo", "Listado de todas las Peliculas");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page",pageRender);
        return "peliculas/listadoPeliculas2";
    }

    @GetMapping("/idpelicula/{id}")
    public String buscarPeliculaPorId(Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/detallePelicula/{id}")
    public String detallePelicula(Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/detallePelicula";
    }

    @GetMapping("/titulo")
    public String buscarPeliculaPorTitulo(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                                          @RequestParam("titulo") String titulo)
    {
        Pageable pageable = PageRequest.of(page,5);
        Page<Pelicula> listado;
        if(titulo.equals("")){
            listado = peliculasService.buscarTodos(pageable);
        }
        else{
            listado = peliculasService.buscarPeliculaPorTitulo(titulo, pageable);
        }

        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de Peliculas por Titulo");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPeliculas";
    }

    @GetMapping("/genero")
    public String buscarPeliculaPorGenero(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                                          @RequestParam("genero") String genero)
    {
        Pageable pageable = PageRequest.of(page,5);
        Page<Pelicula> listado;
        if(genero.equals("")){
            listado = peliculasService.buscarTodos(pageable);
        }
        else{
            listado = peliculasService.buscarPeliculaPorGenero(genero, pageable);
        }

        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de Peliculas por Genero");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPeliculas";
    }


    @GetMapping("/actor")
    public String buscarPeliculaPorActor(Model model, @RequestParam(name="page", defaultValue = "0") int page,
                                          @RequestParam("actor") String actor)
    {
        Pageable pageable = PageRequest.of(page,5);
        Page<Pelicula> listado;
        if(actor.equals("")){
            listado = peliculasService.buscarTodos(pageable);
        }
        else{
            listado = peliculasService.buscarPeliculaPorActor(actor, pageable);
        }

        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de Peliculas por Actor");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPeliculas";
    }



    @PostMapping("/guardar/")
    public String guardarPelicula(Model model, Pelicula pelicula, RedirectAttributes attributes) {
        peliculasService.guardarPelicula(pelicula);
        model.addAttribute("titulo", "Nuevo curso");
        attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        return "redirect:/cpeliculas/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula (Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("titulo", "Editar Pelicula");
        model.addAttribute("pelicula",pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarPelicula(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        peliculasService.eliminarPelicula(id);
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron borrados!");
        return "redirect:/cpeliculas/listado";
    }
}
