package com.api.cadastro_medicos.controller;

import com.api.cadastro_medicos.medico.DadosListagemMedico;
import com.api.cadastro_medicos.pacientes.DadosCadastroPacientes;
import com.api.cadastro_medicos.pacientes.DadosListagemPaciente;
import com.api.cadastro_medicos.pacientes.Paciente;
import com.api.cadastro_medicos.pacientes.PacienteRepository;
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

}