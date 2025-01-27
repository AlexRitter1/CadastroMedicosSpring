package com.api.cadastro_medicos.controller;

import com.api.cadastro_medicos.medico.DadosCadastroMedico;
import com.api.cadastro_medicos.medico.DadosListagemMedico;
import com.api.cadastro_medicos.medico.Medico;
import com.api.cadastro_medicos.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro-medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico json){
      medicoRepository.save(new Medico(json));
    }

    @GetMapping
    public Page<DadosListagemMedico> medicos(Pageable pageable){

        return medicoRepository.findAll(pageable).map(medico -> new DadosListagemMedico(medico));
    }

}


















