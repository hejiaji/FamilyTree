package main.processors;

import main.entities.Gorilla;

import java.util.List;

import static main.helpers.GorillaHelper.getChildren;
import static main.helpers.GorillaHelper.getNamesOfList;

public class ChildrenProcessor extends RelationProcessor {
    public ChildrenProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        return getNamesOfList(getChildren(gorillaList, gorilla));
    }
}
