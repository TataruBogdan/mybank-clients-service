package bogdan.learning.mybank.clients.service.impl;

import banking.commons.dto.IndividualDTO;
import bogdan.learning.mybank.clients.dao.IndividualRepository;
import bogdan.learning.mybank.clients.model.Individual;
import bogdan.learning.mybank.clients.service.IndividualMapper;
import bogdan.learning.mybank.clients.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IndividualServiceImpl implements IndividualService {


    private final IndividualRepository individualRepository;

    private final IndividualMapper individualMapper;


    @Override
    public List<IndividualDTO> getAll() {
        return individualRepository.findAll()
                .stream().map(individual -> individualMapper.toDTO(individual))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<IndividualDTO> getById(int id) {
        return individualRepository.findById(id).map(individual -> individualMapper.toDTO(individual));
    }

    @Override
    public void deleteById(int id) {

        individualRepository.deleteById(id);
    }

    @Override
    public void save(IndividualDTO individualDTO) {

        // transform individualDTO into individual
        Individual individual = individualMapper.toIndividual(individualDTO);
        //save into repository individual
        Individual savedIndividual = individualRepository.save(individual);
        //return to individualDTO
        individualMapper.toDTO(savedIndividual);

    }

    @Override
    public Optional<IndividualDTO> update(int id, IndividualDTO individualDTO) {
        Optional<Individual> updatedIndividual = individualRepository
                .findById(id)
                .map(individual -> individualMapper.toIndividual(individualDTO));
        individualRepository.save(updatedIndividual.get());

        IndividualDTO updatedIndividualDTO = individualMapper.toDTO(updatedIndividual.get());

        return Optional.of(updatedIndividualDTO);
    }


/*    @Deprecated
    private IndividualDTO convert(Individual individual){

        IndividualDTO individualDTO = new IndividualDTO();

        //Mappers.getMapper(IndividualDTO.class);



//        individualDTO.setId(individual.getId());
//        individualDTO.setFirstName(individual.getFirstName());
//        individualDTO.setLastName(individual.getLastName());
//        individualDTO.setAddress(individual.getAddress());
//        individualDTO.setBirthDate(individual.getBirthDate());
//        individualDTO.setCnp(individual.getCnp());
//        individualDTO.setEmployerName(individual.getEmployerName());
//        individualDTO.setOccupation(individual.getOccupation());

//        Field[] fields = (individual.getClass().getDeclaredFields());
//            for (Field field : fields) {
//                Field fieldIndividual = individual.getClass().getDeclaredField(field.getName());
//                Object value = fieldIndividual.get(individual);
//                //Field[] declaredDTOFields = individualDTO.getClass().getDeclaredFields();
//                individualDTO.getClass().getDeclaredField(field.getName()).set(individualDTO, value);
//            }

//        Class<? extends IndividualDTO> individualDTOClassFields = individualDTO.getClass();
//        List<Field> fields = Arrays.asList(individualDTOClassFields.getDeclaredFields());
//        fields.stream()

        //Field[] declaredIndividualDTOFields = individualDTOClassFields.getDeclaredFields();
//        for (Field field : declaredIndividualDTOFields.clone()) {
//            field.stream()
            //field.set(individual, individual.getClass().getDeclaredFields());


        return individualDTO;
    }*/
}
