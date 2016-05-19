package main.groovy.application.coconut

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.Range

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "coconuts")
class Coconut {

    @Id
    @Column(name = "id")
    int id;

    @Column(nullable = false)
    @Size(min = 1, max = 30)
    String name;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    String genre;

    @Column(nullable = false)
    @Range(min = 0l, max = 5l)
    @NotNull
    Integer rating;

    @Column(nullable = false)
    @NotBlank
    String description;


    @Override
    public String toString() {
        return "Coconut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
