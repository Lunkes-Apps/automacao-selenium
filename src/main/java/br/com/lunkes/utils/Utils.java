package br.com.lunkes.utils;

import org.slf4j.helpers.Util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    private static String PATH_PROPRIEDADES = "src/main/resources/config.properties";

    public static String retornaPropriedade(String propriedade){
        try(InputStream inputStream = Files.newInputStream(Paths.get(PATH_PROPRIEDADES))){
            Properties prop = new Properties();
            prop.load(inputStream);
            return prop.getProperty(propriedade);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
