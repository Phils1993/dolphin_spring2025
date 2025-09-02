package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String note;

    private LocalDate createdDate;

    private String createdBy;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Person person;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
    }
}
