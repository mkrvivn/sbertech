package com.example.browser;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {
    private final String rootDirectory;
    private List<Class<? extends Plugin>> loadedClasses = new ArrayList<Class<? extends Plugin>>();
    public PluginManager(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public List<Class<? extends Plugin>> getLoadedClasses()
    {
        return loadedClasses;
    }

    public Plugin load(String folder, String pluginName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = new CustomClassLoader(rootDirectory + "/" + folder);
        Class<? extends Plugin> pluginClass = (Class<? extends Plugin>) cl.loadClass(pluginName);
        loadedClasses.add(pluginClass);
        return (Plugin) pluginClass.newInstance();
    }

    public Plugin loadEncrypted(String folder, String pluginName, byte key) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = new EncryptedClassLoader(rootDirectory + "/" + folder, key);
        Class<? extends Plugin> pluginClass = (Class<? extends Plugin>) cl.loadClass(pluginName);
        loadedClasses.add(pluginClass);
        return (Plugin) pluginClass.newInstance();
    }
}
