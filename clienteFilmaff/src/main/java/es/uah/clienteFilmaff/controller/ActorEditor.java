package es.uah.clienteFilmaff.controller;

import es.uah.clienteFilmaff.model.Actor;
import es.uah.clienteFilmaff.service.IActoresService;

import java.beans.PropertyEditorSupport;

public class ActorEditor extends PropertyEditorSupport {

    private final IActoresService actoresService;

    public ActorEditor(IActoresService actorService) {
        this.actoresService = actorService;
    }

    @Override
    public void setAsText(String text) {
        // Lógica para convertir la cadena a un objeto Actor y establecerlo
        Actor actor = actoresService.buscarActorPorId(Integer.parseInt(text));
        setValue(actor);
    }
}
