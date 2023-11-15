package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.paginator.PageRender;
import es.uah.clienteFilmaff.service.IActoresService;
import es.uah.clienteFilmaff.service.IPeliculasService;
import es.uah.clienteFilmaff.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import es.uah.clienteFilmaff.service.UploadFileServiceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Controller
@RequestMapping("/cpeliculas")
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @Autowired
    IActoresService actoresService;

    @Autowired
    private IUploadFileService uploadFileService;


    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

        Resource recurso = null;

        try {
            recurso = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Actor.class, new ActorEditor(actoresService));
    }


    @GetMapping(value = {"/", "/home", ""})
    public String home (Model model){
        return "home";
    }

    @GetMapping(value = "/home2")
    public String home2 (Model model){
        return "home2";
    }

    @GetMapping(value = "/gestionPeliculas")
    public String gestionPeliculas (Model model){
        return "gestionPeliculas";
    }

    @GetMapping("/nuevo")
    public String nuevo (Model model) {
        List<Actor> actorList = actoresService.listaActores();

        model.addAttribute("titulo", "Nueva Pelicula");
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listadoActores", actorList);
        return "peliculas/formPelicula";
    }

    @GetMapping("/buscar")
    public String buscar (Model model){
        return "peliculas/searchPelicula";
    }

    @GetMapping("/buscarPublic")
    public String buscarPublic (Model model){
        return "peliculas/searchPeliculaPublic";
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
        Pageable pageable = PageRequest.of(page, 8);
        Page<Pelicula> listado = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/cpeliculas/listado2",listado);
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

    @GetMapping("/titulo/{rol}")
    public String buscarPeliculaPorTituloPublic(Model model, @PathVariable("rol") Integer rol, @RequestParam(name="page", defaultValue = "0") int page,
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

        return (rol == 0) ? "peliculas/listPeliculas" :  "peliculas/listadoPeliculas2";
    }

    @GetMapping("/genero/{rol}")
    public String buscarPeliculaPorGenero(Model model, @PathVariable("rol") Integer rol, @RequestParam(name="page", defaultValue = "0") int page,
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
        return (rol == 0) ? "peliculas/listPeliculas" :  "peliculas/listadoPeliculas2";
    }


    @GetMapping("/actor/{rol}")
    public String buscarPeliculaPorActor(Model model, @PathVariable("rol") Integer rol, @RequestParam(name="page", defaultValue = "0") int page,
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
        return (rol == 0) ? "peliculas/listPeliculas" :  "peliculas/listadoPeliculas2";
    }



    @PostMapping("/guardar/")
    public String guardarPelicula(Model model, Pelicula pelicula,
                                  @RequestParam("file") MultipartFile foto, RedirectAttributes attributes) {

        if (!foto.isEmpty()) {

            if (pelicula.getIdPelicula() != null && pelicula.getIdPelicula() > 0 && pelicula.getImagen() != null
                    && pelicula.getImagen().length() > 0) {

                uploadFileService.delete(pelicula.getImagen());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy(foto);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attributes.addFlashAttribute("msg", "Has subido correctamente '" + uniqueFilename + "'");

            pelicula.setImagen(uniqueFilename);
        }

        peliculasService.guardarPelicula(pelicula);
        model.addAttribute("titulo", "Nuevo curso");
        attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        return "redirect:/cpeliculas/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula (Model model, @PathVariable("id") Integer id) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        model.addAttribute("titulo", "Editar Pelicula");
        model.addAttribute("listadoActores", actoresService.listaActores());
        model.addAttribute("actoresSeleccionados",peliculasService.idActoresPelicula(pelicula));
        model.addAttribute("pelicula",pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/borrar/{id}")
    public String eliminarPelicula(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Pelicula pelicula = peliculasService.buscarPeliculaPorId(id);
        if (uploadFileService.delete(pelicula.getImagen())) {
            attributes.addFlashAttribute("msg", "Imagen " + pelicula.getImagen() + " eliminada con exito!");
        }

        peliculasService.eliminarPelicula(id);
        attributes.addFlashAttribute("msg", "Los datos del curso fueron borrados!");

        return "redirect:/cpeliculas/listado";
    }
}
