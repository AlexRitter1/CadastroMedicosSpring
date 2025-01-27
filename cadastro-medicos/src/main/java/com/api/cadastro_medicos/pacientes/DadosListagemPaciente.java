package com.api.cadastro_medicos.pacientes;

import com.api.cadastro_medicos.medico.Medico;

public record DadosListagemPaciente(String nome, String email, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }

}
