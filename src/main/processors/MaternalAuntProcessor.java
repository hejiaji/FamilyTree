package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class MaternalAuntProcessor extends RelationProcessor {
    public MaternalAuntProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> result = new ArrayList<Gorilla>();
        List<Gorilla> sistersOfMother = getSistersOfMother();
        List<Gorilla> sistersInLawOfMother = getSistersInLawOfMother();
        result.addAll(sistersOfMother);
        result.addAll(sistersInLawOfMother);
        return getNamesOfList(result);
    }

    private List<Gorilla> getSistersOfMother() {
        try {
            Gorilla maternalGrandfather = gorilla.getMother().getFather();
            return gorillaList.stream().filter(g -> g.getFather() == maternalGrandfather &&
                    g.getGender() == Gender.FEMALE && g != gorilla.getMother()).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<Gorilla> getSistersInLawOfMother() {
        try {
            Gorilla maternalGrandfather = gorilla.getMother().getFather();
            return gorillaList.stream()
                    .filter(g -> g.getFather() == maternalGrandfather &&
                            g.getGender() == Gender.MALE)
                    .map(Gorilla::getPartner).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
