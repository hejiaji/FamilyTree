package tests.processors;

import main.entities.Gorilla;
import main.processors.PaternalUncleProcessor;
import main.processors.RelationProcessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaternalUncleProcessorTest extends RelationProcessorTest {
    @Test
    public void should_return_paternal_uncle_when_given_value_has_father() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "Vila".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new PaternalUncleProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();
        List<String> resultArray = Arrays.stream(result.split(",")).collect(toList());

        assertEquals(3, resultArray.size());
        assertTrue(resultArray.contains("Ish"));
        assertTrue(resultArray.contains("Chit"));
        assertTrue(resultArray.contains("Vyan"));
    }

    @Test
    public void should_return_null_when_given_value_has_no_father() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "King Shan".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new PaternalUncleProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();

        assertEquals(null, result);
    }
}
