package com.api.cadastro_medicos.medico;

public record DadosListagemMedico(Long id, String nome, String telefone, String email, String crm,
                                  Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(),
                medico.getEspecialidade());
    }

}
