package com.api.cadastro_medicos.pacientes;

import com.api.cadastro_medicos.medico.Medico;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }

}
