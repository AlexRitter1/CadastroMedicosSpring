package com.api.cadastro_medicos.domain.pacientes;

public record DadosDetalhamentoPaciente(Long id, String nome, String telefone, String email) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail());
    }
}
