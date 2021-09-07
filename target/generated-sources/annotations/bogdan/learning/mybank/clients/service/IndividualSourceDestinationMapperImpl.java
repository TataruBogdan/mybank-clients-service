package bogdan.learning.mybank.clients.service;

import bogdan.learning.mybank.clients.dto.IndividualDTO;
import bogdan.learning.mybank.clients.model.Individual;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-01T21:22:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (AdoptOpenJDK)"
)
@Component
public class IndividualSourceDestinationMapperImpl implements IndividualMapper {

    @Override
    public IndividualDTO toDTO(Individual individual) {
        if ( individual == null ) {
            return null;
        }

        IndividualDTO individualDTO = new IndividualDTO();

        individualDTO.setId( individual.getId() );
        individualDTO.setFirstName( individual.getFirstName() );
        individualDTO.setLastName( individual.getLastName() );
        individualDTO.setAddress( individual.getAddress() );
        individualDTO.setBirthDate( individual.getBirthDate() );
        individualDTO.setCnp( individual.getCnp() );
        individualDTO.setEmployerName( individual.getEmployerName() );
        individualDTO.setOccupation( individual.getOccupation() );

        return individualDTO;
    }
}
