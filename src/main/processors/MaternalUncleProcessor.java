package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class MaternalUncleProcessor extends RelationProcessor {
    public MaternalUncleProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        Gorilla maternalGrandfather = gorilla.getMother().getFather();
        List<Gorilla> result = new ArrayList<Gorilla>();
        List<Gorilla> brotherOfMother = gorillaList.stream().filter(g -> g.getFather() == maternalGrandfather &&
                g.getGender() == Gender.MALE).collect(Collectors.toList());
        List<Gorilla> brotherInLawOfMother = gorillaList.stream()
                .filter(g -> g.getFather() == maternalGrandfather &&
                        g.getGender() == Gender.FEMALE && g != gorilla.getMother())
                .map(Gorilla::getPartner).collect(Collectors.toList());
        result.addAll(brotherOfMother);
        result.addAll(brotherInLawOfMother);
        return getNamesOfList(result);
    }
}
