package pl.coderslab.seleniumcourse.examples;

import org.junit.jupiter.api.*;

public class JunitExample {
    @Test
    public void shouldRunFirstTest() {
        System.out.println("running first test");
    }

    @Test
    public void shouldRunSecondTest() {
        System.out.println("running second test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("this will be executed before EACH test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("this will be executed after EACH test");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("this will be executed once before ALL tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("this will be executed once after ALL tests");
    }
}
