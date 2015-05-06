import javafx.util.converter.BigIntegerStringConverter;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RabinMiller {

    private static final String WEJSCIE = "wejscie.txt";
    private static final String WYJSCIE = "wyjscie.txt";

    public static void main(String[] args) {

        // TEST FERMATA
        if (args.length == 1 && args[0] == "-f") {
            String wejscie = czytajPlik(WEJSCIE);
            List<BigInteger> lista = konwertujStringNaLiczby(wejscie);
            String wynik = testFermata(lista.get(0));
            zapiszDoPliku(WYJSCIE, wynik);

            return;
        }

        // RABIN-MILLER
        if (args.length == 0) {
            String wejscie = czytajPlik(WEJSCIE);
            List<BigInteger> lista = konwertujStringNaLiczby(wejscie);

            return;
        }

        // ERROR
        System.out.println("Niewłaściwa komenda, dostępne wywołania:\n java RabinMiller -f\n java RabinMiller");
    }

    private static String testFermata(BigInteger bigInteger) {
        // TODO

        return "";
    }

    private static String rabinMiller(List<BigInteger> lista) {
        // TODO

        return "";
    }

    private static BigInteger najwiekszyWspolnyDzielnik(BigInteger a, BigInteger b) {
        if (b == BigInteger.ZERO) {
            return a;
        } else {
            return najwiekszyWspolnyDzielnik(b, a.mod(b));
        }
    }

    private static String czytajPlik(String nazwaPliku) {
        try {
            return new String(Files.readAllBytes(Paths.get(nazwaPliku))).trim();
        } catch (IOException e) {
            throw new RuntimeException("Nie znaleziono pliku wejściowego!");
        }
    }

    private static List<BigInteger> konwertujStringNaLiczby(String string) {
        List<BigInteger> listaBigInt = new ArrayList<>();
        BigIntegerStringConverter bigIntegerStringConverter = new BigIntegerStringConverter();

        for (String liczbaString : string.split("\n")) {
            listaBigInt.add(bigIntegerStringConverter.fromString(liczbaString));
        }

        return listaBigInt;
    }

    private static void zapiszDoPliku(String nazwaPliku, String tekst) {
        try {
            Files.write(Paths.get(nazwaPliku), tekst.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

