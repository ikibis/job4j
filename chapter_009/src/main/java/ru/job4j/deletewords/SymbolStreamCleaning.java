package ru.job4j.deletewords;

import java.io.*;

public class SymbolStreamCleaning {

    public void dropAbuses(InputStream in, String abuse) throws IOException {
        int counts = abuse.length();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedReader brCheck = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(abuse.getBytes())))
        ) {
            while (br.ready()) {
                int count = 0;
                //element = (char) br.read();
                br.mark(1);
                brCheck.mark(1);
                char brChar = (char) br.read();
                char brCheckChar = (char) brCheck.read();
                br.reset();
                brCheck.reset();
                if (brChar == brCheckChar) {
                    br.reset();
                    brCheck.reset();
                    br.mark(counts);
                    brCheck.mark(counts);
                    while (count != counts) {
                        if (br.read() != brCheck.read()) {
                            br.reset();
                            brCheck.reset();
                            for (int i = 0; i <= count; i++) {
                                System.out.println((char) br.read()); // записываем в аутпут
                            }
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == counts) {
                        br.reset();
                        brCheck.reset();
                        br.skip(counts);
                    }
                } else {
                    System.out.println((char) br.read()); // записываем в аутпут

                }
            }
        }
    }
}


