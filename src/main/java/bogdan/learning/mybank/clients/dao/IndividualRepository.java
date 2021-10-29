package bogdan.learning.mybank.clients.dao;

import bogdan.learning.mybank.clients.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {


}
