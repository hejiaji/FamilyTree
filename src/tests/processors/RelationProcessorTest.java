package tests.processors;

import main.entities.Gorilla;
import main.helpers.Initialization;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.List;

public class RelationProcessorTest {
    public List<Gorilla> gorillaList;

    @BeforeEach
    public void setup() throws IOException {
        gorillaList = Initialization.init();
    }
}
