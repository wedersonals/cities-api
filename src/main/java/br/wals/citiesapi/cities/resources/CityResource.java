package br.wals.citiesapi.cities.resources;

import br.wals.citiesapi.cities.entities.City;
import br.wals.citiesapi.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private CityRepository cityRepository;

    public CityResource(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> cities(Pageable page) {
        return cityRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> city(@PathVariable Long id) {
        Optional<City> optionalCountry = cityRepository.findById(id);
        if (optionalCountry.isPresent()) {
            return ResponseEntity.ok(optionalCountry.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
