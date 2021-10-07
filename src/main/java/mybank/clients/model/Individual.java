package mybank.clients.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "individual")
public class Individual {

    @Id
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
    @Email(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private String emailAddress;

    @Column
    @Pattern(regexp = "^[0-9]{13}$", message = "Please provide 13 cyphers")
    private String cnp;

    @Column
    private String employerName;

    @Column
    private String occupation;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        String oCnp = ((Individual) o).getCnp();
        return this.cnp.equals(oCnp);
    }

    @Override
    public int hashCode() {
        return this.cnp.hashCode() + 57;
    }
}
