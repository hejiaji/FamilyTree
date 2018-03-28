package tests.processors;

import main.entities.Gorilla;
import main.processors.CousinsProcessor;
import main.processors.RelationProcessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CousinsProcessorTest extends RelationProcessorTest {
    @Test
    public void should_return_cousins_result_when_given_value_has_cousins() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "Vila".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new CousinsProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();
        List<String> resultArray = Arrays.stream(result.split(",")).collect(toList());

        assertEquals(5, resultArray.size());
        assertTrue(resultArray.contains("Drita"));
        assertTrue(resultArray.contains("Vrita"));
        assertTrue(resultArray.contains("Satvy"));
        assertTrue(resultArray.contains("Savya"));
        assertTrue(resultArray.contains("Saayan"));
    }
}
