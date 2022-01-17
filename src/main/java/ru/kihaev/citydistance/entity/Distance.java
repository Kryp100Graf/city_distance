package ru.kihaev.citydistance.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "distance")
public class Distance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    @Column(name = "distance")
    private int distance;

}
