package mybank.clients.rest;

import banking.clients.dto.IndividualDTO;
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
//@RequestMapping(value = "/individual_id", produces = MediaType.APPLICATION_JSON_VALUE)
public class IndividualController {

    @Autowired
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

    //TODO  NOT WORKING ! -- ERROR
    @RequestMapping(value = "/individual/{id}", method = RequestMethod.DELETE)
    public void deleteIndividual(@PathVariable int id){

            individualService.deleteById(id);

    }


    @PostMapping("/individuals")
    public ResponseEntity<IndividualDTO> create (@RequestBody IndividualDTO individualDTO){

        individualService.save(individualDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(individualDTO);
    }

    @PutMapping("individual/{id}")
    public ResponseEntity<IndividualDTO>updateIndividual(@PathVariable int id, @RequestBody @Validated IndividualDTO individualDTO){

        Optional<IndividualDTO> retrievedIndividual = individualService.getById(id);

        if (retrievedIndividual.isPresent()){
            individualService.update(individualDTO);
            return ResponseEntity.ok(retrievedIndividual.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(individualDTO);
        }
    }



}
