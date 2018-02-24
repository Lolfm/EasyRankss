package at.lolfm.easyrankss.main;

import at.lolfm.easyrankss.listener.JoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MainClass extends JavaPlugin {

    public static String prefix = "§a[EasyRankss] §f";
    public static File file;
    public static FileConfiguration cfg;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        file = new File("plugins/EasyRankss", "config.yml");
        cfg = YamlConfiguration.loadConfiguration(file);

        getServer().getConsoleSender().sendMessage(prefix + "Plugin Enabled!");
        registerListener();
    }

    @Override
    public void onDisable() {
        System.out.println(prefix + "Plugin Disabled!");
    }

    public void registerListener() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(), this);
    }
}
