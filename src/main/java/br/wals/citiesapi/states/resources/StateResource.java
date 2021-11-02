package br.wals.citiesapi.states.resources;

import br.wals.citiesapi.states.entities.State;
import br.wals.citiesapi.states.repositories.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    private StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public Page<State> states(Pageable page) {
        return stateRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> state(@PathVariable Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        if (optionalState.isPresent()) {
            return ResponseEntity.ok(optionalState.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
