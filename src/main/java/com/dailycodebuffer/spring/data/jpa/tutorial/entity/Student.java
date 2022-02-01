package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false
    )
    private String emailId;

    /* Labaati away ka aw fieldanay ka taybatn ba (Guardian) = (name, email, mobile) lera bnusin, daykayna classakitri sarbaxo u ba hoi (Embed) awa
    rabtyan dakayn lagal yaktr.

    As a result, we have our entity Student, embedding Guardian details, and mapping to a single database table.
    */
    @Embedded
    private Guardian guardian;



}
