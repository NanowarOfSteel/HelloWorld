package it.nanowar.ofsteel.helloworld;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldMainLauncherClassTest {

    @Test
    void songRefrain_printsCorrectNumberOfTimes_whenFooIsPositive() {
        // Arrange
        int foo = 3;  // Number of times expected "Hello World!" should be printed
        HelloWorldMainLauncherClass hw = new HelloWorldMainLauncherClass(foo);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String lineSeparator = System.lineSeparator();

        // Act
        hw.songRefrain();

        // Assert
        StringBuilder expectedOutput = new StringBuilder();
        for (int i = 0; i < foo * 2; i++) {
            expectedOutput.append("Hello World!").append(lineSeparator);
        }
        assertEquals(expectedOutput.toString(), outContent.toString());
    }

    @Test
    void falseMethod_throwsNullPointerException() {
        // Arrange
        HelloWorldMainLauncherClass hw = new HelloWorldMainLauncherClass(1);

        // Act and Assert
        assertThrows(NullPointerException.class, hw::falseMethod);
    }

    @Test
    void main_printsExpectedMessages() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String[] args = {};

        // Act
        try {
            HelloWorldMainLauncherClass.main(args);
        } catch (NullPointerException e) {
            // expected exception due to falseMethod()
        } finally {
            System.setOut(originalOut);
        }

        // Process results
        String output = outContent.toString();
        List<String> outputLines = Arrays.asList(output.split(System.lineSeparator()));
        List<String> expectedLines = Arrays.asList(
                "Hello World Programmer Start",
                "Hello World!",
                "Hello World!",
                "Hello World!",
                "Hello World!",
                "Program Finished!"
        );

        // Assert: Compare line by line
        assertTrue(outputLines.containsAll(expectedLines));
    }
}
