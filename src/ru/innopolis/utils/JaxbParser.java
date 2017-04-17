package ru.innopolis.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.innopolis.Main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Kuznetsov on 15/04/2017.
 */

public class JaxbParser implements Parser {

    private static final Logger LOGGER = Logger.getLogger(JaxbParser.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    @Override
    public Object getObject(File file, Class c) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;

    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o, file);

    }

}