package com.eventmanagement.restapi.controller;

import com.eventmanagement.restapi.model.EdicaoModel;
import com.eventmanagement.restapi.repository.EdicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.eventmanagement.restapi.model.EventoModel;
import com.eventmanagement.restapi.repository.EventoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

@RestController
public class EditionController {
    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private EventoRepository eventoRepository;


    @GetMapping(path = "/api/events/{eventId}/editions")
    public List<EdicaoModel> getEventEditions(@PathVariable long eventId) {
        return edicaoRepository.findByEventos_Id(eventId);
    }

    @PostMapping(path = "/api/events/{eventId}/editions")
    public String criarEdicaoParaEvento(
            @PathVariable long eventId,
            @RequestBody EdicaoModel novaEdicao) {

        // Verifica se o evento existe
        Optional<EventoModel> eventoOptional = eventoRepository.findById(eventId);
        if (eventoOptional.isPresent()) {
            EventoModel evento = eventoOptional.get();

            // Define o evento para a nova edição
            novaEdicao.setEvento(Collections.singleton(evento)); // Assuming evento is a single event

            // Salva a nova edição
            edicaoRepository.save(novaEdicao);

            return "Edição criada com sucesso";
        } else {
            return "Evento não encontrado";
        }
    }

}
