package ru.job4j.deletewords;

import java.io.*;

public class SymbolStreamCleaning {

    public ByteArrayOutputStream dropAbuses(InputStream in, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))
        ) {
            String s = br.readLine();
            for (int i = 0; i < abuse.length; i++) {
                s = s.replaceAll(abuse[i], "");
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(s.getBytes());
            return bos;
        }
    }
}


