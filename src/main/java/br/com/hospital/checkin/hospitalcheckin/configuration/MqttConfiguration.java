package br.com.hospital.checkin.hospitalcheckin.configuration;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {
    private final String broker = "tcp://iot.eclipse.org:1883";
    private final String clientId = "hospitalCheckin";

    @Bean
    public MqttClient mqttConnect(){
        MqttClient mqttConnection = null;
        try {
            mqttConnection = new MqttClient(broker,clientId);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            mqttConnection.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return mqttConnection;
    }




}
