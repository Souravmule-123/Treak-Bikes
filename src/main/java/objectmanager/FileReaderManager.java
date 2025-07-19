package objectmanager;

import dataReader.ConfigFileReader;


import java.io.FileNotFoundException;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager=new FileReaderManager();
    private static ConfigFileReader configFileReader=null;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        try {
            if (configFileReader == null) return new ConfigFileReader();
            else return configFileReader;
        } catch (FileNotFoundException e) {
//            log.error(String.valueOf(e));
        }

        return configFileReader;
    }
}

