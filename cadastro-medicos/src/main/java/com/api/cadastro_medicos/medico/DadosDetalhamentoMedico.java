package com.api.cadastro_medicos.medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm,
                                      Especialidade especialidade) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade());
    }

}
