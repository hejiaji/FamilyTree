package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.List;

import static main.helpers.GorillaHelper.getChildren;
import static main.helpers.GorillaHelper.getNamesOfList;

public class GrandDaughterProcessor extends RelationProcessor {
    public GrandDaughterProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> children = getChildren(gorillaList, gorilla);
        List<Gorilla> result = new ArrayList<Gorilla>();
        children.forEach(g -> {
            result.addAll(getChildren(gorillaList, g, Gender.FEMALE));
        });

        return getNamesOfList(result);
    }
}
