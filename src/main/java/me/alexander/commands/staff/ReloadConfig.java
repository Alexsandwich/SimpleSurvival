package me.alexander.commands.staff;

import me.alexander.SimpleSurvival;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredListener;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class ReloadConfig implements CommandExecutor {

    SimpleSurvival plugin;

    public ReloadConfig(SimpleSurvival instance) {
        plugin = instance;
    }


    //TODO Fix Reload Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.not_player);
            return true;
        }
         Player player = (Player) sender;
        if(player.hasPermission("admin")) {
            player.sendMessage("RELOADED");
            plugin.config = YamlConfiguration.loadConfiguration(plugin.cfile);
        } else {
            player.sendMessage(plugin.noPermission);
        }
        return true;
    }


}
