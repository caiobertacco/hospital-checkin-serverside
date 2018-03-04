package br.com.hospital.checkin.hospitalcheckin.domain;

public class Topic {

    private String text;

    private String defaultText = "fiap/29aso/paciente/";

    public Topic(Paciente paciente) {
        StringBuilder sb = new StringBuilder(defaultText);
        sb.append(paciente.getNome()).append("/")
                .append(paciente.getSobrenome()).append("/")
                .append(paciente.getConvenio()).append("/")
                .append(paciente.getNumCartaoConvenio());
        this.text = sb.toString();
    }

    public String getText() {
        return text;
    }
}
