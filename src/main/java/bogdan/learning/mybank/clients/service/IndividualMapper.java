package bogdan.learning.mybank.clients.service;

import bogdan.learning.mybank.clients.dto.IndividualDTO;
import bogdan.learning.mybank.clients.model.Individual;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IndividualMapper {

        IndividualDTO toDTO(Individual individual);

}
