package main.processors;

import main.entities.Gorilla;

import java.util.List;

public abstract class RelationProcessor {
    protected List<Gorilla> gorillaList;
    protected Gorilla gorilla;

    public RelationProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        this.gorillaList = gorillaList;
        this.gorilla = gorilla;
    }

    public abstract String getNames();
}
