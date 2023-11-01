package com.bankSultra.finalproject.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@Table(schema = "FP")
public class UserList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;


    @ManyToMany()
    @JoinTable(
            schema = "FP",
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> role = new HashSet<>();

    @OneToMany
    private List<Agency> agencyList;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

//    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

//    @JsonIgnore
    public Set<Role> getRole() {
        return role;
    }

    public List<Agency> getAgencyList() {
        return agencyList;
    }

//    @Id
//    @Column( name = "kd_user",length = 5)
//    private String kdUser;
//    @Column(length = 3)
//    private String kd_cab;
//
//    private String name;
//
//    @Column(length = 5)
//    private String kd_wwn;
//
//
//    private String password;
//    private Date passwordExp;
//
////    private boolean enabled;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            schema = "MASTER",
//            name = "user_wwn",
//            joinColumns = {@JoinColumn(name = "kd_user")},
//            inverseJoinColumns = {@JoinColumn(name = "kd_wwn")}
//    )
//    private List<Wewenang> wewenang;

}
