package me.alexander.commands.staff;

import me.alexander.SimpleSurvival;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class StaffChat implements CommandExecutor {

    SimpleSurvival plugin;

    public StaffChat(SimpleSurvival instance) {
        plugin = instance;
    }

    //TODO Build a staffchat system
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        return true;
    }

}
