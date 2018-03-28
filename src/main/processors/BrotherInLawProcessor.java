package main.processors;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static main.helpers.GorillaHelper.getNamesOfList;

public class BrotherInLawProcessor extends RelationProcessor {
    public BrotherInLawProcessor(List<Gorilla> gorillaList, Gorilla gorilla) {
        super(gorillaList, gorilla);
    }

    @Override
    public String getNames() {
        List<Gorilla> brothersOfSpouse = getBrothersOfSpouse();
        List<Gorilla> husbandsOfSibling = getHusbandsOfSibling();
        List<Gorilla> result = new ArrayList<Gorilla>();
        result.addAll(brothersOfSpouse);
        result.addAll(husbandsOfSibling);
        return getNamesOfList(result);
    }

    private List<Gorilla> getHusbandsOfSibling() {
        try {
            Gorilla father = gorilla.getFather();
            if (father == null) {
                throw new Exception("Do not have husbands of sibling");
            }
            return gorillaList.stream().filter(g -> g.getFather() == father &&
                    g != gorilla && g.getGender() == Gender.FEMALE)
                    .map(Gorilla::getPartner)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<Gorilla> getBrothersOfSpouse() {
        try {
            Gorilla fatherInLaw = gorilla.getPartner().getFather();
            if (fatherInLaw == null) {
                throw new Exception("Do not have brothers of Spouse");
            }
            return gorillaList.stream().filter(g -> g.getFather() == fatherInLaw &&
                    g != gorilla.getPartner() && g.getGender() == Gender.MALE)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
