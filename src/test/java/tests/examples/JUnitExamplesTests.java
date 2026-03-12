package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll
    static void startup() {
        System.out.println("tests started");
    }

    @AfterAll
    static void finished() {
        System.out.println("tests finished");
    }

    @BeforeEach
    void startBrowser() {
        System.out.println("-Browser has started");
    }

    @AfterEach
    void stopBrowser() {
        System.out.println("-Browser has stopped");
    }

    @Test
    void firstTest() {
        System.out.println(" - firstTest");
    }

    @Test
    void secondTest() {
        System.out.println(" - secondTest");

    }
}
