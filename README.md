# The Dolphin JPA Exercise

This code is the starting point for this exercise:

- [Dolphin exercise](https://3semfall2025.kursusmaterialer.dk/backend/jpa-relations/exercises/dolphin/)

The goal is to train @OneToMany relations and much more.

## Noter:

Typiske Lombok annotationer for hver klasse:

```plaintext
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ToString.Exclude
@Builder.Default  // <---- This one is necessary with @Builder
```

Typiske JPA annotationer:

```plaintext
@Entity
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
  @OneToOne(mappedBy="person", cascade = CascadeType.ALL)
    private PersonDetail personDetail;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Builder.Default  // <---- This one is necessary with @Builder
    private Set<Fee> fees = new HashSet<>();
```

One-To-Many - Husk at bruge HashSets for at undgå dubletter
```java
 private Set<Fee> fees = new HashSet<>();
 ````

Hjælpe metode til at lave Bi - directional
```java
public void addFee(Fee fee)
    {
        this.fees.add(fee);
        if (fee != null)
        {
            fee.setPerson(this);
        }
    }
```

## Husk
* At indsætte entiteter i 'Hibernate.config' filen
* Oprette database - skriv i 'config.properties' i resources mappen
```bash
    DB_NAME=MitDBNavn
    DB_USERNAME=postgres
    DB_PASSWORD=postgres
```