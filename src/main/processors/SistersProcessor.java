package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class SistersProcessor extends RelationProcessor {
    public SistersProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> result = gorillaList.stream()
                .filter(g -> g.getFather() == gorilla.getFather() &&
                        !g.getName().equals(gorilla.getName()) &&
                        g.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        return getNamesOfList(result);
    }
}
