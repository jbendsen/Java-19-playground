package dk.logb.jdk18.simple.web.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Path;

public class Demo {

    public static void main(String[] args) throws IOException {
        var handler = HttpHandlers.handleOrElse(
                (req) -> req.getRequestMethod().equals("GET"),
                (exchange) -> {
                    var uri = exchange.getRequestURI();
                    exchange.getRequestBody().transferTo(System.out);
                    OutputStream outputStream = exchange.getResponseBody();

                    StringBuilder htmlBuilder = new StringBuilder();
                    htmlBuilder.append("<html>").
                            append("<body>")
                            .append("<h1>")
                            .append("Hello, time is now: ")
                            .append(System.currentTimeMillis())
                            .append("</h1>")
                            .append("</body>")
                            .append("</html>");

                    String htmlResponse = htmlBuilder.toString();
                    exchange.sendResponseHeaders(200, htmlResponse.length());
                    outputStream.write(htmlResponse.getBytes());
                    outputStream.flush();
                    outputStream.close();
                },
                HttpHandlers.of(404, Headers.of("ContentType","text/plain"), "Resource not found"));

        var server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/test/", handler);
        server.start();
    }

    private static void startSimpleFileServer() {
        var server = SimpleFileServer.createFileServer(new InetSocketAddress(8080), Path.of("/home/jbendsen/git/Java-19-test/src"), SimpleFileServer.OutputLevel.VERBOSE);
        server.start();
    }
}
