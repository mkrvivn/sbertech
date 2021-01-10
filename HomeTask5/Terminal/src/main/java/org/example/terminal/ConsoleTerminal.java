package org.example.terminal;

import org.example.terminal.exceptions.ActiveSessionExist;
import org.example.terminal.exceptions.IllegalPin;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleTerminal {

    Terminal terminal;

    public ConsoleTerminal()
    {

    }

    public void setUp() throws IllegalPin
    {
        AccountServer accountServer = new AccountServer();
        accountServer.generateAccount("1234");
        accountServer.generateAccount("1111");
        accountServer.generateAccount("2222");
        terminal = new Terminal();
        terminal.setAccountServer(accountServer);
    }

    public void run() throws IOException, ActiveSessionExist, IllegalPin
    {
        System.out.println("Добро пожаловать! для выхода введите quit.");
        begin();
    }

    public void begin() throws IOException, ActiveSessionExist, IllegalPin
    {
        processAccountId();
        processAccountPin();
        auth();
        menu();
    }

    private void processAccountId() throws IOException, ActiveSessionExist
    {
        System.out.println("Введите id счета");
        while(true)
        {
            String command = readLine();
            try {
                terminal.setAccountId(Integer.valueOf(command));
                break;
            } catch (NumberFormatException e)
            {
                System.out.println("id счета должен быть цифрой. Повторите попытку.");
            }
        }
    }

    private void processAccountPin() throws IOException, ActiveSessionExist
    {
        System.out.println("Введите pin");
        while(true)
        {
            String command = readLine();
            try {
                terminal.processInput(command);
                break;
            } catch (IllegalPin e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private void auth() throws IllegalPin, IOException, ActiveSessionExist
    {
        terminal.auth();
        if(terminal.getAccountSession().getStatus() == AccountSessionStatus.AUTHORIZED)
        {
            System.out.println("Авторизация прошла успешно.");
        }
        else
        {
            System.out.println("Авторизация прощла неудачно. Проверте правильность введенных данных.");
            processAccountId();
        }

    }

    private void menu() throws IOException, ActiveSessionExist, IllegalPin
    {
        System.out.println("Список комманд:");
        System.out.println("put <amount>");
        System.out.println("get <amount>");
        System.out.println("logout");
        System.out.println("quit");
        String command = readLine();
        String[] commands = command.split(" ");
        if(commands.length == 2)
        {
            if(commands[0].equals("put"))
            {
                try
                {
                    System.out.println(terminal.putMoney(Integer.valueOf(commands[1])).getAccountBalance());
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }finally {
                    menu();
                }
            }

            if(commands[0].equals("get"))
            {
                try
                {
                    System.out.println(terminal.getMoney(Integer.valueOf(commands[1])).getAccountBalance());
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }finally {
                    menu();
                }
            }
        }
        if(commands.length == 1)
        {
            if (commands[0].equals("logout"))
            {
                terminal.clearState();
                begin();
            }
        }
    }

    private String readLine() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        if(command.equals("quit"))
            System.exit(0);
        return command;
    }
}
