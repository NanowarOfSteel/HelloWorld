package it.nanowar.ofsteel.helloworld;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldMainLauncherClassTest {
    @Test
    void testConstructorInitialization() {
        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(5);
        assertNotNull(instance, "Instance should be created");
    }

    @Test
    void testSongRefrainOutput() {
        // Configure
        int expectRuns = 2;
        int expectOutputs = expectRuns * 2; // each run does 2 outputs

        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(expectRuns);

        // Catch the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Do test
        instance.songRefrain();

        // Check the number of outputs
        String output = outContent.toString();
        long helloWorldCount = output.lines().filter(line -> line.equals("Hello World!")).count();
        assertEquals(expectOutputs, helloWorldCount, String.format( "The songRefrain method should print 'Hello World!' %d times", expectOutputs));
    }

    @Test
    void testFalseMethodThrowsNullPointerException() {
        HelloWorldMainLauncherClass instance = new HelloWorldMainLauncherClass(1);

        // Make sure the NPE is thrown
        assertThrows(NullPointerException.class, instance::falseMethod, "falseMethod should throw a NullPointerException");
    }
}