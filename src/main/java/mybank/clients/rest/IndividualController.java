package mybank.clients.rest;

import banking.commons.dto.IndividualDTO;
import lombok.RequiredArgsConstructor;
import mybank.clients.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class IndividualController {

    @Autowired
    private final IndividualService individualService;


    @GetMapping("/individuals")
    public List<IndividualDTO> retrieveAllIndividual(){
        List<IndividualDTO> allIndividuals = individualService.getAll();

        return allIndividuals;
    }

    @GetMapping("/individuals/{id}")
    public ResponseEntity<IndividualDTO> getById(@PathVariable int id) {

        Optional<IndividualDTO> individualRepositoryById = individualService.getById(id);

        if(individualRepositoryById.isPresent()) {
            return ResponseEntity.ok(individualRepositoryById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //TODO  NOT WORKING ! -- ERROR
    @DeleteMapping(value = "/individual/{id}")
    public void deleteIndividual(@PathVariable int id){
            individualService.deleteById(id);
    }

    @PostMapping("/individuals")
    public ResponseEntity<IndividualDTO> create (@RequestBody IndividualDTO individualDTO){

        individualService.saveIndividual(individualDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(individualDTO);
    }

    @PutMapping("individual/{id}")
    public ResponseEntity<IndividualDTO>updateIndividual(@PathVariable int id, @RequestBody @Validated IndividualDTO individualDTO){

        Optional<IndividualDTO> retrievedIndividual = individualService.getById(id);

        if (retrievedIndividual.isPresent()){
            Optional<IndividualDTO> updatedIndividualDTO = individualService.update(individualDTO);
            return ResponseEntity.ok(updatedIndividualDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(individualDTO);
        }
    }



}
