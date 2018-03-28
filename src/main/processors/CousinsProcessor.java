package main.processors;

import main.entities.Gorilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.helpers.GorillaHelper.getChildren;
import static main.helpers.GorillaHelper.getNamesOfList;
import static java.util.stream.Collectors.toList;

public class CousinsProcessor extends RelationProcessor {
    public CousinsProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> cousins = new ArrayList<Gorilla>();
        List<Gorilla> siblingsOfMother = getSiblings(gorillaList, gorilla.getMother());
        List<Gorilla> siblingsOfFather = getSiblings(gorillaList, gorilla.getFather());
        List<Gorilla> siblings = new ArrayList<Gorilla>(siblingsOfFather);
        siblings.addAll(siblingsOfMother);
        siblings.forEach(g -> {
            cousins.addAll(getChildren(gorillaList, g));
        });

        return getNamesOfList(cousins);
    }

    private List<Gorilla> getSiblings(List<Gorilla> gorillaList, Gorilla gorilla) {
        try {
            if (gorilla == null || gorilla.getFather() == null) {
                throw new Exception("no sibling");
            }
            return gorillaList.stream().filter(g -> g.getFather() == gorilla.getFather() &&
                    g != gorilla).collect(toList());
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
