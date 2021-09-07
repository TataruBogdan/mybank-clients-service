package bogdan.learning.mybank.clients.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Individual {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;
    private String cnp;
    private String employerName;
    private String occupation;

}
