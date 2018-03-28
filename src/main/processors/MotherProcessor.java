package main.processors;

import main.entities.Gorilla;

import java.util.List;

public class MotherProcessor extends RelationProcessor {
    public MotherProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        Gorilla mother = gorilla.getMother();
        return null == mother ? null : mother.getName();
    }
}
