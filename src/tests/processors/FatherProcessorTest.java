package tests.processors;

import main.entities.Gorilla;
import main.processors.FatherProcessor;
import main.processors.RelationProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FatherProcessorTest extends RelationProcessorTest {
    @Test
    public void should_return_father_name_if_given_input_has_father() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "Vich".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new FatherProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();

        assertEquals("King Shan", result);
    }

    @Test
    public void should_return_null_if_given_input_has_no_father() {
        Gorilla gorilla = gorillaList.stream().filter(g -> "King Shan".equals(g.getName())).findFirst().orElseGet(null);
        RelationProcessor relationProcessor = new FatherProcessor(gorillaList, gorilla);
        String result = relationProcessor.getNames();

        assertEquals(null, result);
    }
}
