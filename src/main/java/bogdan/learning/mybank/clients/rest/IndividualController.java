package bogdan.learning.mybank.clients.rest;

import banking.commons.dto.IndividualDTO;
import bogdan.learning.mybank.clients.model.Individual;
import bogdan.learning.mybank.clients.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class IndividualController {

    private final IndividualService individualService;

    @GetMapping("/individuals")
    public List<IndividualDTO> retrieveAllIndividual(){
        return individualService.getAll();
    }

    @GetMapping("/individuals/{id}")
    public ResponseEntity<IndividualDTO> retrieveIndividual(@PathVariable int id) throws Exception {

        Optional<IndividualDTO> individualRepositoryById = individualService.getById(id);

        if(individualRepositoryById.isPresent()) {
            return ResponseEntity.ok(individualRepositoryById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/individuals/{id}")
    public void deleteIndividual(@PathVariable int id) {

        individualService.deleteById(id);

    }

    @PostMapping("/individual")
    public ResponseEntity<IndividualDTO> create(@Valid @RequestBody IndividualDTO individualDTO) {

        Optional<IndividualDTO> foundIndividual = individualService.getById(individualDTO.getId());

        if (foundIndividual.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(individualDTO);
        } else {
            individualService.save(individualDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(individualDTO);
        }
    }

    public ResponseEntity<IndividualDTO> updateIndividual(@PathVariable @Valid int id, @RequestBody @Validated IndividualDTO individualDTO) {

        Optional<IndividualDTO> updatedIndividual = individualService.getById(individualDTO.getId());

        if (updatedIndividual.isPresent()) {
            individualService.update(id, individualDTO);
            return ResponseEntity.ok(updatedIndividual.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(individualDTO);
        }

    }





}
