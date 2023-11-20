package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PaisesServiceImpl implements IPaisesService {


    @Override
    public List<String> obtenerListPaises(){
        String[] locales = Locale.getISOCountries();
        List<String> paises = new ArrayList<>();
        for(String countryCode: locales){
            Locale obj = new Locale("", countryCode);
            paises.add(obj.getDisplayName());
        }
        return paises;
    }
}
