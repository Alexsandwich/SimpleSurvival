package me.alexander;

import me.alexander.commands.staff.Fly;
import me.alexander.commands.PlayerList;
import me.alexander.commands.SetSpawn;
import me.alexander.commands.Spawn;
import me.alexander.listener.JoinListener;
import me.alexander.listener.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SimpleSurvival extends JavaPlugin {

    public DataManager data;

    private static SimpleSurvival instance;
    FileConfiguration config = this.getConfig();
    PluginManager pm = Bukkit.getPluginManager();
    private static final Logger log = Logger.getLogger("Minecraft");

    // Defining strings for use in other classes
    public final String not_player = configString("Not_Player");
    public final String flydisable = configString("Fly_Disabled");
    public final String flyenabled= configString("Fly_Enabled");
    public final String noPermission = configString("No_Permission");
    public String joinmsg = configString("Join_Message");
    public String quitmsg = configString("Quit_Message");
    public String ScoreboardTitle = configString("Scoreboard_Title");
    public String setspawn = configString("SetSpawn");
    public String spawn = configString("Spawn");

    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Simple Survival Version: " + getDescription().getVersion() + " has been enabled");
            this.getCommand("fly").setExecutor(new Fly(this));
            this.getCommand("setspawn").setExecutor(new SetSpawn(this));
            this.getCommand("playerlist").setExecutor(new PlayerList(this));
            this.getCommand("spawn").setExecutor(new Spawn(this));
            Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(this), (Plugin) this);
            Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(this), (Plugin) this);
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerList(this), (Plugin) this);
            this.data = new DataManager(this);

            config.options().copyDefaults(true);
            saveConfig();
        } else {
            throw new RuntimeException("Could not find PlaceholderAPI!! Plugin can not work without it!");
        }

    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Simple Survival Version: " + getDescription().getVersion() + " has been disabled");
    }
    private String configString(String path) {
        return ChatColor.translateAlternateColorCodes('&', getConfig().getString(path));
    }

}


