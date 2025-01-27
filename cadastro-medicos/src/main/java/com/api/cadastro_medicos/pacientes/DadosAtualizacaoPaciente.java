package com.api.cadastro_medicos.pacientes;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

    @NotNull
    Long id,

    String nome,
    String telefone){}
