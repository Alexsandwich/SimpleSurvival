package me.alexander.commands;

import me.alexander.DataManager;
import me.alexander.SimpleSurvival;
import me.alexander.api.EntityBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetSpawn implements CommandExecutor {

    SimpleSurvival plugin;

    public SetSpawn(SimpleSurvival instance) {
        plugin = instance;
    }

    public DataManager data;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.setPrefix(plugin.not_player));
            return true;
        }
            Player player = (Player) sender;
            if(player.hasPermission("simplesurvival.setspawn")) {
                Location main = player.getLocation();
                player.getWorld().setSpawnLocation(main.getBlockX(), main.getBlockY(), main.getBlockZ());
                    //setSpawnLocation(main.getWorld().getName(), main.getX(), main.getY(), main.getZ(), main.getYaw(), main.getPitch());
                    //data.saveConfig();
                    player.sendMessage(plugin.setPrefix(plugin.setspawn));

        }
        return true;
    }

    /** TODO Fix Data Save
    public void setSpawnLocation(String world, double x, double y, double z, float yaw, float pitch) {

        data.getConfig().set("world", world);
        data.getConfig().set("x", Double.valueOf(x));
        data.getConfig().set("y", Double.valueOf(y));
        data.getConfig().set("z", Double.valueOf(z));
        data.getConfig().set("yaw", Float.valueOf(yaw));
        data.getConfig().set("pitch", Float.valueOf(pitch));

    }
     **/

}
