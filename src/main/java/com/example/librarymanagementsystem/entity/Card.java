package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @UpdateTimestamp
    private Date updatedOn;


    @CreationTimestamp
    Date issueDate;
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
    private String validTill;

    @OneToOne
    @JoinColumn
    Student student;

}
