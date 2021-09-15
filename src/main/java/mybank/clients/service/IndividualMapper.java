package mybank.clients.service;

import mybank.clients.dto.IndividualDTO;
import mybank.clients.model.Individual;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IndividualMapper {

        //create mapper

        //destination       // source
        IndividualDTO toDTO(Individual individual);

        List<IndividualDTO> toIndividualDTO(List<Individual> individual);

        Individual toIndividual(IndividualDTO individualDTO);



}
