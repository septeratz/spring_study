package com.example.forstudy.exdb.testtable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter @Setter
@Table(name = "testtable")
@NoArgsConstructor
public class TestTable {

    @Column(name = "id")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String memo;
    private LocalDateTime date = LocalDateTime.now();
}
