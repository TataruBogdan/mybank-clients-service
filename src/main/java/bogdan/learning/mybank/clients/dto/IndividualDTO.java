package bogdan.learning.mybank.clients.dto;

import lombok.Data;

import java.util.Date;

@Data
public class IndividualDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;
    private String cnp;
    private String employerName;
    private String occupation;
}
