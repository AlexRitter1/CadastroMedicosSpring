package com.api.cadastro_medicos.controller;

import com.api.cadastro_medicos.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro-medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico json){

        medicoRepository.save(new Medico(json));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> medicos(Pageable pageable){

        var page = medicoRepository.findAll(pageable).map(medico -> new DadosListagemMedico(medico));
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico json){

        var medico = medicoRepository.getReferenceById(json.id());
        medico.atualizarInformacoes(json);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar (@PathVariable Long id){

        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


















