package com.epam.tetrahedron.creation.reading;
import com.epam.tetrahedron.exception.FileNotExistException;
import com.epam.tetrahedron.exception.ReadDataErrorException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<String> readDataFromFile(String name) throws FileNotExistException, ReadDataErrorException {
        List<String> list = new ArrayList<>();
        String s;
        Logger log = Logger.getLogger(DataReader.class);
        try(BufferedReader br = new BufferedReader(new FileReader(name))){
            while((s=br.readLine())!=null){
                list.add(s);
            }
        }catch (FileNotFoundException err){
            log.error("Файл "+name+" не найден");
            throw new FileNotExistException(err.getMessage());
        }catch (IOException err){
            log.error(err.getMessage());
            throw new ReadDataErrorException(err.getMessage());
        }
        return list;
    }
}
