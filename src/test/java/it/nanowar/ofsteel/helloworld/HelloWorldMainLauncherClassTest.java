package it.nanowar.ofsteel.helloworld;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldMainLauncherClassTest {

    @Test
    void constructorSetsFooCorrectly() {
        // Arrange
        int fooValue = 5;

        // Act
        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(fooValue);

        // Assert
        assertEquals(fooValue, instance.getFoo());
    }

    @Test
    void songRefrainPrintsCorrectNumberOfTimesForLoop() {
        // Arrange
        int fooValue = 3;
        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(fooValue);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        instance.songRefrain();
        // Collecting output
        String output = outContent.toString();

        // Assert
        long count = countOccurrences(output, "Hello World!");
        assertEquals(fooValue * 2, count); // Each instance both in `for` and `while`, so fooValue times 2
    }

    @Test
    void mainPrintsCorrectly() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] args = {};

        // Act
        try {
            HelloWorldMainLauncherClass.main(args);
        } catch (NullPointerException e) {
            // Expected exception should not prevent assertion checks
        }
        // Collecting and normalizing output
        String output = normalizeLineEndings(outContent.toString());

        // Expected output
        String expectedOutput = "Hello World Programmer Start\nHello World!\nHello World!\nHello World!\nHello World!\nProgram Finished!\n";
        expectedOutput = normalizeLineEndings(expectedOutput);

        // Assert
        assertEquals(expectedOutput, output);
    }

    @Test
    void falseMethodThrowsNullPointerException() {
        // Arrange
        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(1);

        // Act and Assert
        boolean exceptionThrown = false;
        try {
            instance.falseMethod();
        } catch (NullPointerException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    private long countOccurrences(String string, String substring) {
        return Pattern.compile(Pattern.quote(substring))
                .splitAsStream(string)
                .count() - 1;
    }

    private String normalizeLineEndings(String input) {
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }
}