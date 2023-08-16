package com.metrodata.entities;

import com.metrodata.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "sponsor")
    private Certificate certificate;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
