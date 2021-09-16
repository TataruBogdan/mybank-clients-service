package mybank.clients.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class IndividualDTO {

    @NotNull
//    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String address;
    private Date birthDate;
    private String phoneNumber;

    @NotNull
    //TODO depus contrstraint sa fie formatul unui email cu blabla@domeniu.ceva
    @Email(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private String emailAddress;

    @NotNull
    //TODO de pus contrstraint ca CNP sa aibe 13 cifre
    @Pattern(regexp = "^[0-9]{13}$", message = "Please provide 13 cyphers")
    private String cnp;
    private String employerName;
    private String occupation;



}
