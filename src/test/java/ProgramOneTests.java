import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramOneTests {

    @BeforeAll
    public static void setup() {
        // This method will run before any tests are run
    }

    @AfterAll
    public static void teardown() {
        // This method will run after all tests are run
    }

    @Test
    public void testOne() {
        assertTrue(true);
    }
}
