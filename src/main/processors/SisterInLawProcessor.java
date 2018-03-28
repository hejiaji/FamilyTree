package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class SisterInLawProcessor extends RelationProcessor {
    public SisterInLawProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> sistersOfSpouse = getSistersOfSpouse();
        List<Gorilla> wivesOfSibling = getWivesOfSibling();
        List<Gorilla> result = new ArrayList<>();
        result.addAll(sistersOfSpouse);
        result.addAll(wivesOfSibling);
        return getNamesOfList(result);
    }

    private List<Gorilla> getSistersOfSpouse() {
        try {
            Gorilla fatherInLaw = gorilla.getPartner().getFather();
            if (fatherInLaw == null) {
                throw new Exception("Do not have sister of Spouse");
            }
            return gorillaList.stream().filter(g -> g.getFather() == fatherInLaw &&
                    g != gorilla.getPartner() && g.getGender() == Gender.FEMALE)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<Gorilla> getWivesOfSibling() {
        try {
            Gorilla father = gorilla.getFather();
            if (father == null) {
                throw new Exception("Do not have wives of sibling");
            }
            return gorillaList.stream().filter(g -> g.getFather() == gorilla.getFather() &&
                    g != gorilla && g.getGender() == Gender.MALE)
                    .map(Gorilla::getPartner)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
