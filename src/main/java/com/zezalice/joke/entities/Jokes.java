package com.zezalice.joke.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Jokes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="joke_id")
    private int id;
    @Column(name = "joke_text")
    private String joke;
    @Column(name = "input_date")
    private Date input;
    @Column(name = "display_date")
    private Date display;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private int categoryId;

    public Jokes(){}
    
    public Jokes(int id, String joke, Date input, Date display, int categoryId){
        this.id = id;
        this.joke = joke;
        this.input = input;
        this.display = display;
        this.categoryId = categoryId;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }
    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Date getInput() {
        return input;
    }
    public void setInput(Date input) {
        this.input = input;
    }

    public Date getDisplay() {
        return display;
    }
    public void setDisplay(Date display) {
        this.display = display;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}