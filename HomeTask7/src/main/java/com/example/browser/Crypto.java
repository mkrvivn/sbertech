package com.example.browser;

import java.io.*;
import java.util.Arrays;

public class Crypto {
    public static void encrypt(String filepath, byte key) throws IOException {
        File f = new File(filepath);
        if(!f.exists())
        {
            throw new IOException("No such file");
        }
        byte[] bytes = new byte[(int)f.length()];
        FileInputStream fis = new FileInputStream(f);
        try {
            fis.read(bytes,0,bytes.length);
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            };
        }
        for(int i = 0; i < bytes.length; i++)
        {
            bytes[i] ^= key;
        }
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(bytes);
        }
    }

    public static byte[] decrypt(byte[] content, byte key) throws IOException {

        for(int i = 0; i < content.length; i++)
        {
            content[i] ^= key;
        }
        return content;
    }
}
