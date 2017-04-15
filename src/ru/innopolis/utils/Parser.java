package ru.innopolis.utils;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by Kuznetsov on 15/04/2017.
 */

public interface Parser {

    Object getObject(File file, Class c) throws JAXBException;

    void saveObject(File file, Object o) throws JAXBException;

}
