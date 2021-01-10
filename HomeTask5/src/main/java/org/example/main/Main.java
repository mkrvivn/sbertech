package org.example.main;

import org.example.terminal.ConsoleTerminal;
import org.example.terminal.exceptions.ActiveSessionExist;
import org.example.terminal.exceptions.IllegalPin;
import org.example.urlreader.ConsolePorcessorImpl;
import org.example.urlreader.UrlReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {



    public static void main(String[] args) throws IOException, IllegalPin, ActiveSessionExist {
        UrlReader.urlReader(new ConsolePorcessorImpl());
        ConsoleTerminal ct = new ConsoleTerminal();
        ct.setUp();
        ct.run();
    }
}
