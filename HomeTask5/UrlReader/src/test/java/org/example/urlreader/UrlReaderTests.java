package org.example.urlreader;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class UrlReaderTests {

    @Mock
    ConsoleProcessor cp;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test(timeout = 1000)
    public void emptyInput() throws IOException
    {
        Mockito.when(cp.readCommand()).thenReturn("", "url q");
        UrlReader.urlReader(cp);
        Mockito.verify(cp).printCommand("illformed command");

    }

    @Test(timeout = 1000)
    public void wrongCommand() throws IOException
    {
        Mockito.when(cp.readCommand()).thenReturn("curl http://stackoverflow.com", "url q");
        UrlReader.urlReader(cp);
        Mockito.verify(cp).printCommand("unknown command curl");
    }

    @Test(timeout = 1000)
    public void wrongUrl1() throws IOException
    {
        Mockito.when(cp.readCommand()).thenReturn("url stackoverflow.com", "url q");
        UrlReader.urlReader(cp);
        Mockito.verify(cp).printCommand("no protocol: stackoverflow.com");
    }


    @Test(timeout = 10000)
    public void unexistedUrl() throws IOException
    {
        Mockito.when(cp.readCommand()).thenReturn("url http://asdasdaswda3da3rwqer3fw3.com.ru", "url q");
        UrlReader.urlReader(cp);
        Mockito.verify(cp).printCommand("Connection refused: connect");
    }


}
