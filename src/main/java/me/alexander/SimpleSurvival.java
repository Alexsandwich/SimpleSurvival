package me.alexander;

import me.alexander.commands.Fly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.Permission;

public class SimpleSurvival extends JavaPlugin {

    private static SimpleSurvival instance;
    FileConfiguration config = this.getConfig();
    PluginManager pm = Bukkit.getPluginManager();

    public final String not_player = configString("Not_Player");
    public final String flydisable = configString("Fly_Disabled");
    public final String flyenabled= configString("Fly_Enabled");
    public final String noPermission = configString("No_Permission");

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Simple Survival Version: " + getDescription().getVersion() + " has been enabled");
        this.getCommand("fly").setExecutor(new Fly(this));

        config.options().copyDefaults(true);
        saveConfig();

    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Simple Survival Version: " + getDescription().getVersion() + " has been disabled");
    }
    private String configString(String path) {
        return ChatColor.translateAlternateColorCodes('&', getConfig().getString(path));
    }
}
