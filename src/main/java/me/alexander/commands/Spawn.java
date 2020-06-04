package me.alexander.commands;

import me.alexander.SimpleSurvival;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    SimpleSurvival plugin;

    public Spawn(SimpleSurvival instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.not_player);
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("simplesurvival.spawn")) {
            player.teleport(player.getWorld().getSpawnLocation());
            player.sendMessage(plugin.spawn);

        }
        return true;
    }
}