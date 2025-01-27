package com.api.cadastro_medicos.medico;

import com.api.cadastro_medicos.endereco.DadosEndereco;
import com.api.cadastro_medicos.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {

    public Medico() {
    }

    @GeneratedValue @Id
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //classe embutida
    private Endereco endereco;

    public Medico(DadosCadastroMedico dadosCadastroMedico){
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.telefone = dadosCadastroMedico.telefone();
        this.crm = dadosCadastroMedico.crm();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.endereco = new Endereco(dadosCadastroMedico.dadosEndereco());
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

    public String getTelefone() {
        return telefone;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
}
