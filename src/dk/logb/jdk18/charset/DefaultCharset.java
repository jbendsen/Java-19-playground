package dk.logb.jdk18.charset;

public class DefaultCharset {
    public static void main(String[] args) {
        //get the default charset
        var charset = java.nio.charset.Charset.defaultCharset();
        System.out.println(charset);

        //get system property for file encoding
        var fileEncoding = System.getProperty("file.encoding");
        System.out.println(fileEncoding);
    }
}
