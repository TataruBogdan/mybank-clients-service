package bogdan.learning.mybank.clients.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "individual")
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private Date birthDate;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "email_address ")
    private String emailAddress;

    @Column
    private String cnp;

    @Column(name = "employer_name")
    private String employerName;

    private String occupation;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (obj.getClass() != this.getClass())) return false;
        Individual that = (Individual) obj;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + 57;
    }
}
