package com.zezalice.joke.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "categories")
//    @JsonIgnore
    private Set<Jokes> jokes;

    public Categories() {

    }

    public Categories(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Jokes> getJokes() {
        return jokes;
    }

    public void setJokes(Set<Jokes> jokes) {
        this.jokes = jokes;
    }
}
