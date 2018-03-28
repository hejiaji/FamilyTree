package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class PaternalUncleProcessor extends RelationProcessor {
    public PaternalUncleProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        if (null == gorilla.getFather() || null == gorilla.getFather().getFather()) {
            return null;
        }

        Gorilla grandfather = gorilla.getFather().getFather();

        List<Gorilla> result = new ArrayList<Gorilla>();
        List<Gorilla> brotherOfFather = gorillaList.stream().filter(g -> g.getFather() == grandfather &&
                g != gorilla.getFather() &&
                g.getGender() == Gender.MALE).collect(Collectors.toList());
        List<Gorilla> brotherInLawOfFather = gorillaList.stream()
                .filter(g -> g.getFather() == grandfather &&
                        g.getGender() == Gender.FEMALE)
                .map(Gorilla::getPartner).collect(Collectors.toList());
        result.addAll(brotherOfFather);
        result.addAll(brotherInLawOfFather);
        return getNamesOfList(result);
    }
}
