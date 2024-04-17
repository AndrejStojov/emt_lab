package com.example.lab1emt.web;

import com.example.lab1emt.models.Country;
import com.example.lab1emt.models.dto.CountryDTO;
import com.example.lab1emt.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/countries")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country>findAll(){
        return countryService.listAll();
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable Long id){

        return countryService.findById(id);

    }

    @PostMapping("/add")
    public void save(
            @RequestBody CountryDTO countryDTO
            ){
        countryService.create(countryDTO.getName(),countryDTO.getContinent());

    }

    @PostMapping("/edit/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody CountryDTO countryDTO
    ){

        countryService.update(id,countryDTO.getName(),countryDTO.getContinent());
    }

    @PostMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id
    ){
        countryService.delete(id);
    }

}
