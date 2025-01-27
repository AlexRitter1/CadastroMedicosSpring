package com.api.cadastro_medicos.pacientes;

import com.api.cadastro_medicos.medico.DadosAtualizacaoMedico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

    @Getter
    @EqualsAndHashCode(of = "id")
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity(name = "Paciente")
    @Table(name = "pacientes")
    public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String email;
        private String cpf;
        private String telefone;

        public Paciente(DadosCadastroPacientes dados) {
            this.nome = dados.nome();
            this.email = dados.email();
            this.telefone = dados.telefone();
            this.cpf = dados.cpf();
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getCpf() {
            return cpf;
        }

        public String getTelefone() {
            return telefone;
        }

        public Paciente() {
        }

        public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente json) {
            if (json.telefone()!=null) {
                this.telefone = json.telefone();
            }
        }
    }