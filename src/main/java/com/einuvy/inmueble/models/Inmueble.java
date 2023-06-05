package com.einuvy.inmueble.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@ToString
public class Inmueble {

    @Getter
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false, length = 150)
    private String name;

    @Getter @Setter
    @Column(nullable = false, length = 500)
    private String address;

    @Getter @Setter
    @Column(length = 1200, nullable = true)
    private String image;

    @Getter @Setter
    @Column(nullable = false)
    private Double price;

    @Getter @Setter
    @Column(nullable = false)
    private LocalDateTime creationDate;

    public Inmueble(String name, String address, String image, Double price) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.price = price;
        this.creationDate = LocalDateTime.now();
    }
}
