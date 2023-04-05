package ru.javabegin.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_data", schema = "todolist", catalog = "hibernate_prac")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "userpassword", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;

    @ManyToMany
    @JoinTable(name = "user_role",schema = "todolist", catalog = "hibernate_prac",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<Category> categories;
//
//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
//    List<Priority> priorities;
//
//    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, optional = false)
//    private  Activity activity;
//
//    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, optional  = false)
//    private  Stat stat;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Task> tasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}