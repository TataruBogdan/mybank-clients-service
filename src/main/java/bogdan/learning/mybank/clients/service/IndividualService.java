package bogdan.learning.mybank.clients.service;

import bogdan.learning.mybank.clients.dto.IndividualDTO;

import java.util.List;
import java.util.Optional;

public interface IndividualService {
    List<IndividualDTO> getAll();
    Optional<IndividualDTO> getById(int id);
}
