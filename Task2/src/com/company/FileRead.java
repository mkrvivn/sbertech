package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class FileRead {
    public static List<String> BufferedRead(Path file)
    {
        List<String> fileLines = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new java.io.FileReader(file.toFile()));
            String line;
            while((line = br.readLine()) != null)
            {
                fileLines.add(line);
            }
        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("unknown exception in BufferRead");
        }
        return fileLines;
    }

    public static List<String> StreamRead(Path file)
    {
        List<String> fileLines = new ArrayList<>();
        try
        {
            Files.lines(file).forEach(fileLines::add);
        }catch (Exception e)
        {
            System.out.println("unknown exception in StreamRead");
        }
        return fileLines;
    }

}
