package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import es.uah.clienteFilmaff.model.Actor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ActoresServiceImpl implements IActoresService{

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8090/api/peliculas/actores";

    @Override
    public Page<Actor> buscarTodos(Pageable pageable) {
        Actor[] actores = template.getForObject(url, Actor[].class);
        List<Actor> actoresList = Arrays.asList(actores);
        return getPaginatedPage(actoresList,pageable);
    }

    @Override
    public List<Actor> listaActores() {
        Actor[] actores = template.getForObject(url, Actor[].class);
        List<Actor> actoresList = Arrays.asList(actores);
        return  actoresList;
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        Actor actor = template.getForObject(url+"/"+idActor, Actor.class);
        return actor;
    }

    @Override
    public Page<Actor> buscarActorPorNombre(String nombre, Pageable pageable) {
        Actor[] actores = template.getForObject(url+"/nombre/"+nombre, Actor[].class);
        List<Actor> actoresList = Arrays.asList(actores);
        return getPaginatedPage(actoresList,pageable);
    }

    @Override
    public void guardarActor(Actor actor) {
        if (actor.getIdActor() != null && actor.getIdActor() > 0) {
            template.put(url, actor);
        } else {
            actor.setIdActor(0);
            template.postForObject(url, actor, String.class);
        }
    }

    @Override
    public void eliminarActor(Integer idActor) {
        template.delete(url + "/" + idActor);
    }

    @Override
    public void inscribirPelicula(Integer idActor, Integer idPelicula) {
        template.getForObject(url+"/anrep/"+idActor+"/"+idPelicula, String.class);
    }

    private Page<Actor> getPaginatedPage(List<Actor> actores, Pageable pageable)
    {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actor> list;

        if(actores.size() < startItem)
        {
            list = Collections.emptyList();
        }
        else
        {
            int toIndex = Math.min(startItem + pageSize, actores.size());
            list = actores.subList(startItem,toIndex);
        }

        Page<Actor> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actores.size());
        return page;
    }
}
