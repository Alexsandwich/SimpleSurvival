package me.alexander.commands.staff;

import me.alexander.SimpleSurvival;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

    SimpleSurvival plugin;

    public Vanish(SimpleSurvival instance) {
        plugin = instance;
    }

    //TODO build a vanish system
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.setPrefix(plugin.not_player));
            return true;
        }



        return true;
    }
}
