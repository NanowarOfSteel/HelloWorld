package it.nanowar.ofsteel.helloworld;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             PrintStream captureStream = new PrintStream(baos)) {
            System.setOut(captureStream);
            System.setErr(captureStream);
            out.println("<html><body>");
            try {
                HelloWorldMainLauncherClass.main(new String[0]);
            } catch (Exception e) {
                // Stack traces in production? Not ideal for security... but with Giorgio Mastrota's power, we're safe!
                e.printStackTrace();
            } finally {
                System.setOut(new PrintStream(System.out));
                System.setErr(new PrintStream(System.err));
            }
            String capturedOutput = baos.toString();
            out.println("<pre>" + capturedOutput + "</pre>");
            out.println("</body></html>");
        }
    }
}
