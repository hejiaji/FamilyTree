package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class DaughterProcessor extends RelationProcessor {
    public DaughterProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> result = gorillaList.stream()
                .filter(g -> (g.getFather() == gorilla || g.getMother() == gorilla) && g.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        return getNamesOfList(result);
    }
}
