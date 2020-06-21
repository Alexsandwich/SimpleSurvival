package me.alexander.commands.staff;

import me.alexander.SimpleSurvival;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.alexander.events.onDeath;
import org.bukkit.inventory.ItemStack;

public class RestoreInv implements CommandExecutor {

    SimpleSurvival plugin;

    public RestoreInv(SimpleSurvival instance) {
        plugin = instance;
    }


        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You goofball, only players may use this command ingame!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("restoreinv"))
            if (sender.hasPermission("Restore-Inventory-Permission")) {
                if (args.length == 0) {
                    sender.sendMessage(format("&cUsage: /restoreinv <player>"));
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        sender.sendMessage(format("&7Could not find the specified player &7c{target}").replace("{target}", args[0]));
                    } else if (onDeath.armorContents.containsKey(target.getUniqueId()) || onDeath.inventoryContents.containsKey(target.getUniqueId())) {
                        if (onDeath.armorContents.containsKey(target.getUniqueId())) {
                            onDeath.armorContents.remove(target.getUniqueId());
                            onDeath.emptyarmor.remove(target.getUniqueId());
                        }
                        if (onDeath.inventoryContents.containsKey(target.getUniqueId())) {
                            target.getInventory().setContents((ItemStack[])onDeath.inventoryContents.get(target.getUniqueId()));
                            onDeath.inventoryContents.remove(target.getUniqueId());
                            onDeath.emptyinv.remove(target.getUniqueId());
                        }
                        target.sendMessage(format("&eYour inventory has been restored!"));
                        sender.sendMessage(format("&eYou have successfully restored &b[0]&e's inventory!").replace("[0]", target.getName()));
                    } else {
                        sender.sendMessage(format("&eThere was no data found by &b[0]&e's UUID. Could not restore inventory!").replace("[0]", target.getName()));
                    }
                }
            } else {
                sender.sendMessage(plugin.noPermission);
            }
        return true;
    }

    private String format(String var) {
        return ChatColor.translateAlternateColorCodes('&', var);
    }
}