package com.boot.app.controller;

import com.boot.app.bean.City;
import com.boot.app.service.ICityService;
import com.boot.app.utility.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
public class PdfController {

    private ICityService cityService;

    @Autowired
    private void setCityService(ICityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<City> cities = cityService.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<City> addCity(@RequestBody City c) {

        return ResponseEntity.ok().body(cityService.add(c));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<City>> getCity() {

        return ResponseEntity.ok().body(cityService.findAll());
    }
}
