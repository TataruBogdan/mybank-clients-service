package bogdan.learning.mybank.clients.rest;

import bogdan.learning.mybank.clients.dto.IndividualDTO;
import bogdan.learning.mybank.clients.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class IndividualController {

    private final IndividualService individualService;

    // Viorel - return a new ArrayList<>(individualService) ?
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



}
