package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.paginator.PageRender;
import es.uah.clienteFilmaff.service.IActoresService;
import es.uah.clienteFilmaff.service.IPaisesService;
import es.uah.clienteFilmaff.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/cactores")
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @Autowired
    private IUploadFileService uploadFileService;

    @Autowired
    IPaisesService paisesService;

    @GetMapping("/tabla")
    public String listadoActores(Model model, @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Actor> listado = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/tabla",listado);
        model.addAttribute("titulo", "Tabla de los Actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page",pageRender);
        return "actores/tablaActores";
    }

    @GetMapping("/listado")
    public String listadoActores2(Model model, @RequestParam(name = "page", defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 8);
        Page<Actor> listado = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/listado",listado);
        model.addAttribute("titulo", "Listado de los Actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page",pageRender);
        return "actores/listadoActores";
    }

    @GetMapping("/nombre/")
    public String buscarActorPorNombre(Model model,
                                          @RequestParam(name="page", defaultValue = "0") int page,
                                          @RequestParam("titulo") String titulo)
    {
        Pageable pageable = PageRequest.of(page,8);
        Page<Actor> listado;
        if(titulo.equals("")){
            listado = actoresService.buscarTodos(pageable);
        }
        else{
            listado = actoresService.buscarActorPorNombre(titulo, pageable);
        }

        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/listado", listado);

        model.addAttribute("titulo", "Listado de Actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page", pageRender);
        return "actores/listadoActores";
    }

    @GetMapping("/detalleActor/{id}")
    public String detalleActor(Model model, @PathVariable("id") Integer id) {
        Actor actor = actoresService.buscarActorPorId(id);
        model.addAttribute("actor", actor);
        return "actores/detalleActor";
    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {
        model.addAttribute("titulo", "Nuevo Actor/Actriz");
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        model.addAttribute("paises", paisesService.obtenerListPaises());
        return "actores/formActores";
    }

    @PostMapping("/guardar/")
    public String guardarActor(Model model, Actor actor,
                                  @RequestParam("file") MultipartFile foto, RedirectAttributes attributes) {

        if (!foto.isEmpty()) {

            if (actor.getIdActor() != null && actor.getIdActor() > 0 && actor.getImagen() != null
                    && actor.getImagen().length() > 0) {

                uploadFileService.delete(actor.getImagen());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy(foto);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attributes.addFlashAttribute("msg", "Has subido correctamente '" + uniqueFilename + "'");

            actor.setImagen(uniqueFilename);
        }

        actoresService.guardarActor(actor);
        model.addAttribute("titulo", "Nuevo curso");
        attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        return "redirect:/cactores/tabla";
    }

    @GetMapping("/editar/{id}")
    public String editarActor (Model model, @PathVariable("id") Integer id) {
        Actor actor = actoresService.buscarActorPorId(id);
        model.addAttribute("titulo", "Editar Actor");
        model.addAttribute("paises", paisesService.obtenerListPaises());
        model.addAttribute("actor",actor);
        return "actores/formActores";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarActor(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Actor actor = actoresService.buscarActorPorId(id);
        if (uploadFileService.delete(actor.getImagen())) {
            attributes.addFlashAttribute("msg", "Imagen " + actor.getImagen() + " eliminada con exito!");
        }

        actoresService.eliminarActor(id);
        attributes.addFlashAttribute("msg", "Los datos del curso fueron borrados!");

        return "redirect:/cactores/tabla";
    }
}
