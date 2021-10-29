package bogdan.learning.mybank.clients.service;

import banking.commons.dto.IndividualDTO;
import bogdan.learning.mybank.clients.model.Individual;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")

public interface IndividualMapper {

        IndividualDTO toDTO(Individual individual);
        Individual toIndividual(IndividualDTO individualDTO);
        List<IndividualDTO> listIndividualDTO (List<IndividualDTO> individualDTOList);

}
