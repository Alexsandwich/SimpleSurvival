package me.alexander;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import me.alexander.commands.staff.Fly;
import me.alexander.commands.PlayerList;
import me.alexander.commands.SetSpawn;
import me.alexander.commands.Spawn;
import me.alexander.commands.staff.ReloadConfig;
import me.alexander.events.JoinListener;
import me.alexander.events.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SimpleSurvival extends JavaPlugin implements Listener {

    public DataManager data;

    private static SimpleSurvival instance;

    public static SimpleSurvival getInstance(){
        return instance;
    }
    public FileConfiguration config = this.getConfig();
    public PluginManager pm = Bukkit.getPluginManager();
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
    public String swear = configString("Swear");
    public String prefix = configString("Prefix");
    public String prefixenabled = configString("Enable_Prefix");

    private ProtocolManager protocolManager;

    public File cfile;

    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Simple Survival Version: " + getDescription().getVersion() + " has been enabled");
            this.getCommand("fly").setExecutor(new Fly(this));
            this.getCommand("setspawn").setExecutor(new SetSpawn(this));
            this.getCommand("playerlist").setExecutor(new PlayerList(this));
            this.getCommand("spawn").setExecutor(new Spawn(this));
            this.getCommand("screload").setExecutor(new ReloadConfig(this));
            Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(this), (Plugin) this);
            Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(this), (Plugin) this);
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerList(this), (Plugin) this);
            Bukkit.getServer().getPluginManager().registerEvents(this, this);
            this.data = new DataManager(this);
            protocolManager = ProtocolLibrary.getProtocolManager();

            config = getConfig();
            config.options().copyDefaults(true);
            saveConfig();
            cfile = new File(getDataFolder(), "config.yml");
            instance = this;

            ArrayList<String> arr = new ArrayList<String>();
            try (BufferedReader br = new BufferedReader(new FileReader("plugins/SimpleSurvival/list.txt")))
            {

                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {
                    arr.add(sCurrentLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            ProtocolLibrary.getProtocolManager().addPacketListener(
                    new PacketAdapter(this, PacketType.Play.Client.CHAT) {
                        // Note that this is executed asynchronously
                        @Override
                        public void onPacketReceiving(PacketEvent event) {
                            PacketContainer packet = event.getPacket();
                            String message = packet.getStrings().read(0);

                            if (arr.contains(message)){
                                event.setCancelled(true);
                                event.getPlayer().sendMessage(swear);
                            }
                        }
                    });

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

    public String setPrefix(String string) {
        if (prefixenabled.equalsIgnoreCase("true")) {
            return prefix + string;
        } else {
            return string;
        }

    }

}


