package es.uah.clienteFilmaff.service;


import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Critica;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CriticaServiceImpl implements ICriticasService {

    @Autowired
    RestTemplate template;

    @Autowired
    IActoresService actoresService;

    @Autowired
    IUsuariosService usuariosService;

    @Autowired
    IPeliculasService peliculasService;

    String url = "http://localhost:8090/api/usuarios/criticas";

    @Override
    public Page<Critica> buscarTodas(Pageable pageable) {
        Critica[] criticas = template.getForObject(url, Critica[].class);
        List<Critica> criticasList = Arrays.asList(criticas);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Critica> list;

        if(criticasList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticasList.size());
            list = criticasList.subList(startItem, toIndex);
        }
        Page<Critica> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticasList.size());
        return page;
    }

    @Override
    public Page<Critica> buscarCriticasPorIdPeliculaTabla(Integer idPelicula, Pageable pageable) {
        Critica[] criticas = template.getForObject(url+"/pelicula/"+idPelicula, Critica[].class);
        List<Critica> criticaList = Arrays.asList(criticas);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Critica>list;

        if(criticaList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticaList.size());
            list = criticaList.subList(startItem, toIndex);
        }
        Page<Critica> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticaList.size());
        return page;
    }

    @Override
    public List<Critica> buscarCriticaPorIdDetallePelicula(Integer idPelicula)
    {
        Critica[] criticas = template.getForObject(url+"/pelicula/"+idPelicula, Critica[].class);
        List<Critica> criticaList = Arrays.asList(criticas);
        return criticaList;
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        Critica critica = template.getForObject(url+"/"+idCritica, Critica.class);
        return critica;
    }

    @Override
    public String guardarCritica(Critica critica) {
        Usuario usuario = usuariosService.buscarUsuarioPorId(2);
        critica.setUsuario(usuario);
        critica.setFecha(new Date());
        if (critica.getIdCritica() != null && critica.getIdCritica() > 0) {
            template.put(url, critica, String.class); //peligroso, habría que comprobar la inscripción anterior
            return "Se han actualizado los datos";
        } else {
            //Guardamos la Crítica:
            critica.setIdCritica(0);
            template.postForObject(url,critica,String.class);
            return "Los datos de la crítica fueron guardados!";
        }
    }

    @Override
    public double obtenerNotaMediaCriticasPeliculaId(Integer idPelicula)
    {
        Critica[] criticas = template.getForObject(url+"/pelicula/"+idPelicula, Critica[].class);
        Integer sumaNotas = 0;
        for(Critica crit : criticas){
            sumaNotas += crit.getNota();
        }
        return (double) sumaNotas /criticas.length;
    }

    @Override
    public void eliminarCritica(Integer idCritica) {
        template.delete(url+ "/" +  idCritica);
    }

}
