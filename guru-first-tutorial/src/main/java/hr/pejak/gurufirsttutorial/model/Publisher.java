package hr.pejak.gurufirsttutorial.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Data
@ToString
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String street;

    @NonNull
    private String houseNumber;

    @NonNull
    private String city;

    @NonNull
    private String zipCode;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

}
