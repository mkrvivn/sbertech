package org.example.urlreader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlReader {

    public static void urlReader(ConsoleProcessor cp)
    {
        System.out.println("commands:");
        System.out.println("# Url get request");
        System.out.println("url <url> ");
        System.out.println("# Quit the program");
        System.out.println("url q");
        while(true)
        {
            try
            {
                String url = cp.readCommand();
                String[] urlArgs = url.split(" ");
                if(urlArgs.length == 2)
                {
                    if(urlArgs[0].equals("url"))
                    {
                        if(urlArgs[1].equals("q"))
                        {
                            break;
                        }else{
                            String body = UrlReader.readUrl(new URL(urlArgs[1]));
                            FileWriter fw = new FileWriter("response.html");
                            fw.write(body);
                            cp.printCommand("response was saved in response.html");
                            fw.close();
                            break;
                        }
                    }else
                    {
                        throw new IOException("unknown command " + urlArgs[0]);
                    }
                }else
                {
                    throw new IOException("illformed command");
                }
            }catch (IOException e)
            {
                cp.printCommand(e.getMessage());
            }
        }
    }

    private static String readUrl(URL url) throws IOException {
        URLConnection urlConn = url.openConnection();
        if (urlConn instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConn;
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder body = new StringBuilder();
            while ((inputLine = br.readLine()) != null)
            {
                body.append(inputLine);
            }
            httpURLConnection.disconnect();
            return body.toString();
        } else {
            throw new IOException("Not http connection");
        }
    }

    public static void main(String[] str) {

    }
}
