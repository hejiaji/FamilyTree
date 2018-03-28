package main.entities;

import main.dtos.GorillaDTO;
import main.enums.Gender;
import main.helpers.GorillaHelper;
import main.helpers.Initialization;

import java.util.List;

public class Gorilla {
    private Gender gender;

    private String name;

    private Gorilla partner;

    private Gorilla father;

    private Gorilla mother;

    public Gorilla(GorillaDTO gorillaDTO) {
        this.gender = Gender.fromValue(gorillaDTO.getGender());
        this.name = gorillaDTO.getName();
    }

    public Gorilla(Gender gender, String name, Gorilla father, Gorilla mother) {
        this.gender = gender;
        this.name = name;
        this.father = father;
        this.mother = mother;
    }

    public Gorilla(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gorilla getPartner() {
        return partner;
    }

    public void setPartner(Gorilla partner) {
        this.partner = partner;
    }

    public Gorilla getFather() {
        return father;
    }

    public void setFather(Gorilla father) {
        this.father = father;
    }

    public Gorilla getMother() {
        return mother;
    }

    public void setMother(Gorilla mother) {
        this.mother = mother;
    }
}
