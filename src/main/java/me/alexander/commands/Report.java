package me.alexander.commands;

import me.alexander.SimpleSurvival;
import me.alexander.gui.Reportgui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Report implements CommandExecutor {


    SimpleSurvival plugin;


    public Report(SimpleSurvival instance) {
        plugin = instance;
    }

    public static HashMap<Player, String> reported = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.not_player);
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("report"))

           // if (Main.getMain().getConfig().getBoolean("Report.report-enabled")) {
                if (args.length == 0) {
                    sender.sendMessage(format("&cUsage: /report <player>"));
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        sender.sendMessage(format("&7Could not find the specified player &c{target}").replace("{target}", args[0]));
                   // } else if (Cooldown.hasCooldown((Player)sender, "reportcooldown")) {
                  //      sender.sendMessage(format("CHill "));
                    } else {
                        reported.put((Player)sender, target.getName());
                        Reportgui.openReportGUI(player);
                  //  }
                }
            } else {
                sender.sendMessage(format("no work rn!"));
            }
        return true;
    }

    private String format(String var) {
        return ChatColor.translateAlternateColorCodes('&', var);
    }
}