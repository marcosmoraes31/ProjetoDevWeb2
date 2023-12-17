package com.eventmanagement.restapi.controller;
import com.eventmanagement.restapi.model.AtividadeModel;
import com.eventmanagement.restapi.model.EspacoModel;
import com.eventmanagement.restapi.model.EventoModel;
import com.eventmanagement.restapi.repository.AtividadeRepository;
import com.eventmanagement.restapi.repository.EdicaoRepository;
import com.eventmanagement.restapi.repository.EspacoRepository;
import com.eventmanagement.restapi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventmanagement.restapi.model.EdicaoModel;
import java.util.List;
import java.util.Optional;


@RestController
public class AtividadeController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EdicaoRepository edicaoRepository;

    @Autowired
    private EspacoRepository espacoRepository;

    @GetMapping("/api/events/{eventId}/editions/{editionId}/espacos/{espacoId}/atividades")
    public List<AtividadeModel> getAtividadesByEventoEdicaoEspaco(
            @PathVariable long eventId,
            @PathVariable long editionId,
            @PathVariable long espacoId) {
        return atividadeRepository.findByEventoIdAndEdicaoIdAndEspacoId(eventId, editionId, espacoId);
    }

    @PostMapping("/api/events/{eventId}/editions/{editionId}/espacos/{espacoId}/atividades")
    public String criarAtividadeParaEventoEdicaoEspaco(
            @PathVariable long eventId,
            @PathVariable long editionId,
            @PathVariable long espacoId,
            @RequestBody AtividadeModel novaAtividade) {

        // Verifica se o evento, a edição e o espaço existem
        Optional<EventoModel> eventoOptional = eventoRepository.findById(eventId);
        Optional<EdicaoModel> edicaoOptional = edicaoRepository.findById(editionId);
        Optional<EspacoModel> espacoOptional = espacoRepository.findById(espacoId);

        if (eventoOptional.isPresent() && edicaoOptional.isPresent() && espacoOptional.isPresent()) {
            EventoModel evento = eventoOptional.get();
            EdicaoModel edicao = edicaoOptional.get();
            EspacoModel espaco = espacoOptional.get();

            // Define o evento, a edição e o espaço para a nova atividade
            novaAtividade.setEvento(evento);
            novaAtividade.setEdicao(edicao);
            novaAtividade.setEspaco(espaco);

            // Salva a nova atividade
            atividadeRepository.save(novaAtividade);

            return "Atividade criada com sucesso";
        } else {
            return "Evento, Edição ou Espaço não encontrados";
        }
    }


}

