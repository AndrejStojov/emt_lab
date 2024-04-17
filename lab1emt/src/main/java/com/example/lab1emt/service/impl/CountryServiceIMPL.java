package com.example.lab1emt.service.impl;

import com.example.lab1emt.models.Country;
import com.example.lab1emt.models.exceptions.InvalidCouthryIdException;
import com.example.lab1emt.repository.CountryRepository;
import com.example.lab1emt.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceIMPL implements CountryService {
    private final CountryRepository countryRepository;
    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCouthryIdException::new);
    }

    @Override
    public Country create(String name, String continent) {
        Country country=new Country(name,continent);
        return countryRepository.save(country);
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country=countryRepository.findById(id).orElseThrow(InvalidCouthryIdException::new);
        country.setName(name);
        country.setContinent(continent);

        return countryRepository.save(country);
    }

    @Override
    public Country delete(Long id) {
        Country country=countryRepository.findById(id).orElseThrow(InvalidCouthryIdException::new);
        countryRepository.delete(country);
        return country;
    }
}
