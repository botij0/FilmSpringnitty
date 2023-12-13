package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Critica;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.paginator.PageRender;
import es.uah.clienteFilmaff.service.ICriticasService;
import es.uah.clienteFilmaff.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ccriticas")
public class CriticasController {

    @Autowired
    ICriticasService criticasService;

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/listado")
    public String listadoCriticas(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Critica> listado = criticasService.buscarTodas(pageable);
        PageRender<Critica> pageRender = new PageRender<Critica>("/ccriticas/listado", listado);
        model.addAttribute("titulo", "Listado de todas las criticas");
        model.addAttribute("listadoCriticas", listado);
        model.addAttribute("page", pageRender);
        return "usuarios/listCriticas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Critica critica = new Critica();
        List<Pelicula> peliculaList = peliculasService.listadoPeliculas();

        //TODO: enviar el id del usuario logeado (Ver ChatGPT 13/12/2023)!!!!


        model.addAttribute("titulo", "Nueva critica");
        model.addAttribute("peliculas", peliculaList);
        model.addAttribute("usuarioID", 2);
        model.addAttribute("critica", critica);
        return "usuarios/formCritica";
    }

    @PostMapping("/guardar/")
    public String guardarCritica(Model model, Critica critica, RedirectAttributes attributes) {
        String resultado = criticasService.guardarCritica(critica);
        model.addAttribute("titulo", "Nueva critica");
        attributes.addFlashAttribute("msg", resultado);
        return "redirect:/ccriticas/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarCritica(Model model, @PathVariable("id") Integer id) {
        Critica critica = criticasService.buscarCriticaPorId(id);
        List<Pelicula> peliculaList = peliculasService.listadoPeliculas();

        //TODO: enviar el id del usuario logeado (Ver ChatGPT 13/12/2023)!!!!

        model.addAttribute("titulo", "Editar Critica");
        model.addAttribute("critica", critica);
        model.addAttribute("peliculas", peliculaList);
        model.addAttribute("usuarioID", 2);
        return "usuarios/formCritica";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarCritica(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Critica critica = criticasService.buscarCriticaPorId(id);
        if (critica != null) {
            criticasService.eliminarCritica(id);
            attributes.addFlashAttribute("msg", "Los datos de la critica fueron borrados!");
        } else {
            attributes.addFlashAttribute("msg", "Critica no encontrada!");
        }

        return "redirect:/ccriticas/listado";
    }

}
