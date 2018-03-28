package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class PaternalAuntProcessor extends RelationProcessor {
    public PaternalAuntProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        Gorilla grandfather = gorilla.getFather().getFather();
        List<Gorilla> result = new ArrayList<Gorilla>();
        List<Gorilla> sisterOfFather = gorillaList.stream().filter(g -> g.getFather() == grandfather &&
                g.getGender() == Gender.FEMALE).collect(Collectors.toList());
        List<Gorilla> sisterInLawOfFather = gorillaList.stream()
                .filter(g -> g.getFather() == grandfather &&
                        g.getGender() == Gender.MALE &&
                        g != gorilla.getFather())
                .map(Gorilla::getPartner).collect(Collectors.toList());
        result.addAll(sisterOfFather);
        result.addAll(sisterInLawOfFather);
        return getNamesOfList(result);
    }
}
