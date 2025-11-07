package com.kindsonthegenius.pathology_service.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kindsonthegenius.pathology_service.models.Disease;

@RestController
@RequestMapping("/pathology")
public class PathologyResources {

    List<Disease> diseases = Arrays.asList(
        new Disease("D1", "Asthma", "Warm Water Bath"),
        new Disease("D2", "Thyphoid", "Ampicilin Capsule")
    );

    @RequestMapping("/diseases")
    public List<Disease> getDisease(){
        return diseases;
    }

     @RequestMapping("/diseases/{Id}")
    public Disease getDiseaseById(@PathVariable("Id") String Id){
        Disease d = diseases.stream()
                .filter(disease -> Id.equals(disease.getId()))
                .findAny()
                .orElse(null);
        return d;
    }

}
