import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RabinMiller {

    private static final String WEJSCIE = "wejscie.txt";
    private static final String WYJSCIE = "wyjscie.txt";

    public static void main(String[] args) {

        if (args.length == 1 && args[0] == "-f") {
            // test Fermata

            return;
        }

        if (args.length == 0) {
            // właściwa część

            return;
        }


        System.out.println("Niewłaściwa komenda, dostępne wywołania:\n java RabinMiller -f\n java RabinMiller");
    }

    private static String czytajPlik(String nazwaPliku) {
        try {
            return new String(Files.readAllBytes(Paths.get(nazwaPliku))).trim();
        } catch (IOException e) {
            throw new RuntimeException("Nie znaleziono pliku wejściowego!");
        }
    }

    private static void zapiszDoPliku(String nazwaPliku, String tekst) {
        try {
            Files.write(Paths.get(nazwaPliku), tekst.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

