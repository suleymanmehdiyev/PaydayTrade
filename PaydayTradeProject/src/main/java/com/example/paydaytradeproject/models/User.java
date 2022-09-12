package com.example.paydaytradeproject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(schema = "users")
@NoArgsConstructor
@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
    @Id
    Long id;
    @Column
    String name;
    @Column
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    String email;
    @Column
    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$\n")
    String password;
}
