import util.Style;

import java.io.IOException;

public class ETLApplication {
    private static String source = "C:\\Users\\prashak6\\Downloads\\ETLApplication\\src\\files\\input";
    private static String destination = "C:\\Users\\prashak6\\Downloads\\ETLApplication\\src\\files\\output";
    public static void main(String[] args) throws IOException {
        Converter app = new FileConverter();
        app.convert(source,destination, Style.LASTCAP);


    }
}
