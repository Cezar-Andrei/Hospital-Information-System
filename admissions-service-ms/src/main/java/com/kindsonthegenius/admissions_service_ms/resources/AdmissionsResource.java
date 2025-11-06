package com.kindsonthegenius.admissions_service_ms.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kindsonthegenius.admissions_service_ms.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

    List<Patient> patients = Arrays.asList(
        new Patient("P1", "Gabor", "Hungarian"),
        new Patient("P2", "Emeka", "Nigerian"),
        new Patient("P3", "Emily", "American")
    );

    @RequestMapping("/patients")
    public List<Patient> getPatients(){
        return patients;
    }

    @RequestMapping("/patients/{Id}")
    public Patient getPatientById(@PathVariable("Id") String Id){

        Patient p = patients.stream()
        .filter(patient -> Id.equals(patient.getId()))
        .findAny()
        .orElse(null);

    return p;
    }
}
