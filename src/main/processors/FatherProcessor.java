package main.processors;

import main.entities.Gorilla;

import java.util.List;

public class FatherProcessor extends RelationProcessor {
    public FatherProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        Gorilla father = gorilla.getFather();
        return null == father ? null : father.getName();
    }


}
