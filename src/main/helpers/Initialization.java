package main.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.dtos.GorillaAndRelationDTO;
import main.dtos.GorillaDTO;
import main.entities.Gorilla;
import main.exceptions.InvalidInputException;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static main.helpers.GorillaHelper.findGorillaByName;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Initialization {
    static public List<Gorilla> init() throws IOException {
        List<GorillaDTO> gorillaDTOList = loadDataFromJson();
        Map<String, GorillaDTO> gorillaDTOMap = gorillaDTOList.stream().collect(toMap(GorillaDTO::getName, g -> g));
        List<Gorilla> gorillaList = gorillaDTOList.stream().map(Gorilla::new).collect(toList());
        setRelationShip(gorillaList, gorillaDTOMap);
        return gorillaList;
    }

    static private List<GorillaDTO> loadDataFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File("src/main/helpers/rawData.json"), new TypeReference<List<GorillaDTO>>(){});
        } catch (Exception e) {
            System.out.print(e.toString());
            return Collections.emptyList();
        }
    }

    static private void setRelationShip(List<Gorilla> gorillaList, Map<String, GorillaDTO> gorillaDTOMap) {
        gorillaList.forEach(gorilla -> {
            GorillaDTO gorillaDTO = gorillaDTOMap.get(gorilla.getName());
            gorilla.setPartner(findGorillaByName(gorillaList, gorillaDTO.getPartner()));
            gorilla.setFather(findGorillaByName(gorillaList, gorillaDTO.getFather()));
            gorilla.setMother(findGorillaByName(gorillaList, gorillaDTO.getMother()));
        });
    }

    public static GorillaAndRelationDTO transferInput(List<Gorilla> gorillaList, String input) throws InvalidInputException {
        String[] splitInput = input.split(";");
        if (splitInput.length != 2) {
            throw new InvalidInputException();
        }
        String[] personInfo = splitInput[0].split("=");
        if (personInfo.length != 2 || !"Person".equals(personInfo[0].trim())){
            throw new InvalidInputException();
        }
        String[] relationInfo = splitInput[1].split("=");
        if (relationInfo.length != 2 || !"Relation".equals(relationInfo[0].trim())){
            throw new InvalidInputException();
        }
        Gorilla gorilla = GorillaHelper.findGorillaByName(gorillaList, personInfo[1].trim());
        return new GorillaAndRelationDTO(gorilla, relationInfo[1].trim());
    }
}
