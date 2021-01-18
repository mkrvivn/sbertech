package com.example.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomClassLoader extends ClassLoader{

    private final Map<String, Class> loadedTable = new HashMap<>();
    public final String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class result= findClass(name);
        return result;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class result= (Class)loadedTable.get(name);

        if (result!=null) {
            return result;
        }

        int nameDirSize = name.split("\\.").length;
        File f= findFile(name.split("\\.")[nameDirSize - 1], ".class");

        if (f==null) {
            return findSystemClass(name);
        }

        try {
            byte[] classBytes= loadFileAsBytes(f);
            result= defineClass(name, classBytes, 0,
                    classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(
                    "Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException(
                    "Format of class file incorrect for class "
                            + name + " : " + e);
        }
        loadedTable.put(name,result);
        return result;
    }

    private File findFile(String name, String extension)
    {
        File fl = new File((new File(classPath)).getPath()
                    + File.separatorChar
                    + name.replace('/',
                    File.separatorChar)
                    + extension);
            if (fl.exists())
                return fl;
        return null;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static byte[] loadFileAsBytes(File file)
            throws IOException
    {
        byte[] result = new byte[(int)file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result,0,result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {
            };
        }
        return result;
    }
}
