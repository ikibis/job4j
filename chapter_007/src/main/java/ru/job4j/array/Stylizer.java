package ru.job4j.array;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Stylizer {
    public void convert(File source, File dest, File style) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(style)
        );
        transformer.
                transform(
                new StreamSource(source),
                new StreamResult(dest)
        );
    }
}
