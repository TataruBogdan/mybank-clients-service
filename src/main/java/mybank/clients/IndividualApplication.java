package mybank.clients;

import mybank.clients.dao.IndividualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndividualApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IndividualRepository individualRepository;



	public static void main(String[] args) {
		SpringApplication.run(IndividualApplication.class, args);
	}

	@Override
	public void run(String... args) {

//		logger.info("Insert individual -> {}", individualRepository.save(new Individual(10000,"Gigi", "Kent",
//				" Boschet", new Date(), "01234", "@email.com", " 987654", "SC Sant", "ocupatie")));
//
//		logger.info("Insert individual -> {}", individualRepository.save(new Individual(10001,"Cucu", "Kent",
//				" Boschet", new Date(), "01234", "@email.com", " 7654", "SC Sant", "ocupatie")));
//
//		logger.info("Insert individual -> {}", individualRepository.save(new Individual(10002,"Mumu", "Kent",
//				" Boschet", new Date(), "01234", "@email.com", " 54", "SC Sant", "ocupatie")));
//
//		logger.info("Individual id -> {}", individualRepository.findById(10001));
//
//		logger.info("All individual -> {}", individualRepository.findAll());

	}
}
