package br.com.hospital.checkin.hospitalcheckin.controller;

import br.com.hospital.checkin.hospitalcheckin.domain.Topic;
import br.com.hospital.checkin.hospitalcheckin.domain.Paciente;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalCheckinService {
    @Autowired
    private MqttClient mqttConnection;

    private final String PAYLOAD = "0";

    List<Paciente> pacienteList;

    public int checkIn(Paciente paciente) {
        try {
            MqttMessage mqttPayload = new MqttMessage(PAYLOAD.getBytes(Charset.forName("UTF-8")));
            mqttConnection.publish(new Topic(paciente).getText(), mqttPayload);
            if (pacienteList == null) {
                pacienteList = new ArrayList<>();
            }
            System.out.println("Checkin paciente: " + paciente.toString());
            System.out.println("Topico MQTT do paciente: [" + new Topic(paciente).getText() + "]");
            if (pacienteList.contains(paciente)) {
                return pacienteList.indexOf(paciente) + 1;
            } else {
                pacienteList.add(paciente);
            }
        } catch (MqttException e) {
        }
        return pacienteList.size();
    }
}
