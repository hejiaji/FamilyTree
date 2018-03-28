package main.dtos;

import main.entities.Gorilla;

public class GorillaAndRelationDTO {
    private Gorilla gorilla;
    private String relation;

    public GorillaAndRelationDTO(Gorilla gorilla, String relation) {
        this.gorilla = gorilla;
        this.relation = relation;
    }

    public Gorilla getGorilla() {
        return gorilla;
    }

    public void setGorilla(Gorilla gorilla) {
        this.gorilla = gorilla;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
