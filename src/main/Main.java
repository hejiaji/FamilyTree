package main;

import main.dtos.GorillaAndRelationDTO;
import main.entities.Gorilla;
import main.factories.RelationFactory;
import main.helpers.Initialization;
import main.processors.RelationProcessor;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static main.helpers.Initialization.transferInput;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Gorilla> gorillaList = Initialization.init();

        Scanner reader = new Scanner(System.in);
        System.out.println("This is Problem 1: please input name and relation: ");
        System.out.println("Example: Person = Ish; Relation = Brothers");
        String input = "";
        while (!(input = reader.nextLine()).equals("exit")) {
            try {
                GorillaAndRelationDTO gorillaAndRelationDTO = transferInput(gorillaList, input);
                RelationProcessor relationProcessor = RelationFactory.getRelationProcessor(gorillaList, gorillaAndRelationDTO);
                System.out.println(relationProcessor.getNames());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
