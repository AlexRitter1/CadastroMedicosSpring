package com.api.cadastro_medicos.domain.medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank
        String nome,

        @Email @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp="\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade) {}