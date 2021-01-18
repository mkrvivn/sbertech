package com.example.browser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        PluginManager pm = new PluginManager("plugins");
        pm.loadEncrypted("v1Encrypted", "com.example.browser.PluginA", (byte) 15);
        pm.load("v2", "com.example.browser.PluginA");
        for(var plugin : pm.getLoadedClasses())
        {
            Plugin p = plugin.newInstance();
            p.doUsefull();
        }

    }
}
