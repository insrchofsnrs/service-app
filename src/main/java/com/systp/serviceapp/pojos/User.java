package com.systp.serviceapp.pojos;

import com.systp.serviceapp.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AGE")
    @DecimalMax(value = "150", message = "Digit must be a less than 150")
    @DecimalMin(value = "0", message = "Digit must be a greater than 0")
    private Integer age;

    @Column(name = "NAME")
    @Pattern(regexp = "^[A-Z]+[a-z]+$", message = "Username must be alphanumeric with no spaces and first capital")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Max(value = 30, message = "Max password length should be less then 30 characters")
    @Min(value = 5, message = "Min password length should be great then 5 characters")
    @Column(name = "LOGIN", length = 30)
    private String login;

    @Max(value = 30, message = "Max password length should be less then 30 characters")
    @Min(value = 4, message = "Min password length should be great then 6 characters")
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATE", nullable = false)
    private String state = State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PERSON_PERSON_PROFILE",
            joinColumns = {@JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSON_PROFILE_ID")})
    private Set<UserProfile> personProfiles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User person = (User) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (login != null ? !login.equals(person.login) : person.login != null) return false;
        return surname != null ? surname.equals(person.surname) : person.surname == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User : id: " + id + " Name: " + name + " Surname: " + surname + " Age: " + age;// + personAddress;
    }
}
