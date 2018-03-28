package main.helpers;

import main.entities.Gorilla;
import main.enums.Gender;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class GorillaHelper {
    static public Gorilla findGorillaByName(List<Gorilla> gorillaList, String name) {
        if (null == name) {
            return null;
        }
        return gorillaList.stream()
                .filter(gorilla -> name.equals(gorilla.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("no gorilla with name %s", name)));
    }

    static public List<Gorilla> getChildren(List<Gorilla> gorillaList, Gorilla gorilla) {
        return gorillaList.stream()
                .filter(g -> g.getFather() == gorilla || g.getMother() == gorilla)
                .collect(Collectors.toList());
    }

    static public List<Gorilla> getChildren(List<Gorilla> gorillaList, Gorilla gorilla, Gender gender) {
        return gorillaList.stream()
                .filter(g -> g.getFather() == gorilla || g.getMother() == gorilla && g.getGender() == gender)
                .collect(Collectors.toList());
    }

    static public String getNamesOfList(List<Gorilla> gorillaList) {
        return gorillaList.stream().filter(Objects::nonNull).map(Gorilla::getName).collect(Collectors.joining(","));
    }
}
