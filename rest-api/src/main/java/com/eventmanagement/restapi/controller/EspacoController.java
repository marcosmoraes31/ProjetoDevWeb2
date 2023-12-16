package com.eventmanagement.restapi.controller;


import com.eventmanagement.restapi.model.EspacoModel;
import com.eventmanagement.restapi.model.EventoModel;
import com.eventmanagement.restapi.model.UsuarioModel;
import com.eventmanagement.restapi.repository.EdicaoRepository;
import com.eventmanagement.restapi.repository.EspacoRepository;
import com.eventmanagement.restapi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventmanagement.restapi.model.EdicaoModel;


import java.util.List;
import java.util.Optional;

@RestController
public class EspacoController {
        @Autowired
        private EspacoRepository espacoRepository;
        @Autowired
        private EdicaoRepository edicaoRepository;
        @Autowired
        private EventoRepository eventoRepository;

        @GetMapping("/api/events/{eventId}/editions/{editionId}/espacos")
        public List<EspacoModel> getEspacosByEventoAndEdicao(@PathVariable long eventId, @PathVariable long editionId) {
            return espacoRepository.findByEventoIdAndEdicaoId(eventId, editionId);
        }

    @PostMapping("/api/events/{eventId}/editions/{editionId}/espacos")
    public String criarEspacoParaEventoEEdicao(
            @PathVariable long eventId,
            @PathVariable long editionId,
            @RequestBody EspacoModel novoEspaco) {

        // Verifica se o evento e a edição existem
        Optional<EventoModel> eventoOptional = eventoRepository.findById(eventId);
        Optional<EdicaoModel> edicaoOptional = edicaoRepository.findById(editionId);

        if (eventoOptional.isPresent() && edicaoOptional.isPresent()) {
            EventoModel evento = eventoOptional.get();
            EdicaoModel edicao = edicaoOptional.get();

            // Define o evento e a edição para o novo espaço
            novoEspaco.setEvento(evento);
            novoEspaco.setEdicao(edicao);

            // Salva o novo espaço
            espacoRepository.save(novoEspaco);

            return "Espaço criado com sucesso";
        } else {
            return "Evento ou Edição não encontrados";
        }
    }

}





