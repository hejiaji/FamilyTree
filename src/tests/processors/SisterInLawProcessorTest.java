package tests.processors;

import main.entities.Gorilla;
import main.processors.CousinsProcessor;
import main.processors.RelationProcessor;
import main.processors.SisterInLawProcessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SisterInLawProcessorTest extends RelationProcessorTest {
    @Test
    public void should_return_wives_of_sibling_when_given_input_has_some() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "Satya".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new SisterInLawProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();
        List<String> resultArray = Arrays.stream(result.split(",")).collect(toList());

        assertEquals(2, resultArray.size());
        assertTrue(resultArray.contains("Ambi"));
        assertTrue(resultArray.contains("Lika"));
    }

    @Test
    public void should_return_sister_of_spouse_when_given_input_has_some() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "Lika".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new SisterInLawProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();

        assertEquals("Satya", result);
    }
}
