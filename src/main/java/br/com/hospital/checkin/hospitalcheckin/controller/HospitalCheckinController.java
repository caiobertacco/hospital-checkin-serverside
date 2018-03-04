package br.com.hospital.checkin.hospitalcheckin.controller;

import br.com.hospital.checkin.hospitalcheckin.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/checkin")
public class HospitalCheckinController {

    @Autowired
    private HospitalCheckinService service;

    @PostMapping
    public int checkin(@RequestBody Paciente paciente){
        return service.checkIn(paciente);
    }
}
