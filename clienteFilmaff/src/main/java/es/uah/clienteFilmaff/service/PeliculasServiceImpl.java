package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PeliculasServiceImpl implements IPeliculasService {
    @Autowired
    RestTemplate template;

    String url = "http://localhost:8001/peliculas";

    @Override
    public Page<Pelicula>  buscarTodos(Pageable pageable)
    {
        Pelicula[] peliculas = template.getForObject(url, Pelicula[].class);
        List<Pelicula> peliculaList = Arrays.asList(peliculas);
        return getPaginatedPage(peliculaList,pageable);

    }
    public List<Integer> idActoresPelicula(Pelicula pelicula){
        List<Integer> listaIds = new ArrayList<>();
        for (Actor actor  : pelicula.getActores()) {
            listaIds.add(actor.getIdActor());
        }
        return listaIds;
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula){
        Pelicula pelicula = template.getForObject(url + "/" + idPelicula, Pelicula.class);
        return pelicula;
    }

    @Override
    public Page<Pelicula> buscarPeliculaPorTitulo(String titulo, Pageable pageable) {

        Pelicula[] peliculas = template.getForObject(url + "/titulo/" + titulo, Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        return getPaginatedPage(lista,pageable);

    }

    @Override
    public Page<Pelicula> buscarPeliculaPorGenero(String genero, Pageable pageable) {
        Pelicula[] peliculas = template.getForObject(url + "/genero/" + genero, Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        return getPaginatedPage(lista,pageable);
    }


    @Override
    public Page<Pelicula> buscarPeliculaPorActor(String actor, Pageable pageable) {
        Pelicula[] peliculas = template.getForObject(url + "/actor/" + actor, Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        return getPaginatedPage(lista,pageable);
    }

    @Override
    public Page<Pelicula> buscarPeliculaPorAnio(Integer min, Integer max, Pageable pageable){
        Pelicula[] peliculas = template.getForObject(url + "/anio/" + min + "/" + max, Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        return getPaginatedPage(lista,pageable);
    }



    @Override
    public void guardarPelicula(Pelicula pelicula){
        if(pelicula.getIdPelicula() != null && pelicula.getIdPelicula() > 0)
        {
            template.put(url, pelicula);
        }else{
            pelicula.setIdPelicula(0);
            template.postForObject(url,pelicula,String.class);
        }
    }

    @Override
    public void eliminarPelicula(Integer idPelicula){
        template.delete(url + "/" + idPelicula);
    }

    private Page<Pelicula> getPaginatedPage(List<Pelicula> peliculas, Pageable pageable)
    {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Pelicula> list;

        if(peliculas.size() < startItem)
        {
            list = Collections.emptyList();
        }
        else
        {
            int toIndex = Math.min(startItem + pageSize, peliculas.size());
            list = peliculas.subList(startItem,toIndex);
        }

        Page<Pelicula> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), peliculas.size());
        return page;
    }
}
