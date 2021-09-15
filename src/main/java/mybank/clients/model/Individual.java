package mybank.clients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individual")
public class Individual {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private Date birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "email_address")
    private String emailAddress;

    @Column
    private String cnp;

    @Column
    private String employerName;

    @Column
    private String occupation;

}
