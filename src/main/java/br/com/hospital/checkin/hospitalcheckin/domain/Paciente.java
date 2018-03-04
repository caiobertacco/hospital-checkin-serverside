package br.com.hospital.checkin.hospitalcheckin.domain;

import java.util.Objects;

public class Paciente {
    Long id;
    String nome;
    String sobrenome;
    String convenio;
    String plano;
    String numCartaoConvenio;

    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getNumCartaoConvenio() {
        return numCartaoConvenio;
    }

    public void setNumCartaoConvenio(String numCartaoConvenio) {
        this.numCartaoConvenio = numCartaoConvenio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(nome, paciente.nome) &&
                Objects.equals(sobrenome, paciente.sobrenome) &&
                Objects.equals(convenio, paciente.convenio) &&
                Objects.equals(numCartaoConvenio, paciente.numCartaoConvenio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, convenio, numCartaoConvenio);
    }

    @Override
    public String toString() {
        return "Paciente{nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", convenio='" + convenio + '\'' +
                ", numCartaoConvenio='" + numCartaoConvenio + '\'' +
                '}';
    }
}
