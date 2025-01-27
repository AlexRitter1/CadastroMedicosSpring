package com.api.cadastro_medicos.controller;

import com.api.cadastro_medicos.medico.DadosAtualizacaoMedico;
import com.api.cadastro_medicos.medico.DadosListagemMedico;
import com.api.cadastro_medicos.pacientes.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacientes dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> medicos(Pageable pageable){
        return repository.findAll(pageable).map(paciente -> new DadosListagemPaciente(paciente));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente json){

        var paciente = repository.getReferenceById(json.id());
        paciente.atualizarInformacoes(json);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar (@PathVariable Long id){

        repository.deleteById(id);

    }

}