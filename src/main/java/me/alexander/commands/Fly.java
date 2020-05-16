package me.alexander.commands;

import me.alexander.SimpleSurvival;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    SimpleSurvival plugin;

    public Fly(SimpleSurvival instance) {
        plugin = instance;
    }

    private ArrayList<Player> list_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.not_player);
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (player.hasPermission("simplesurvival.fly")) {
                flyMethod(player);
            } else if (args.length == 1) {
                //TODO Flying other people still needs to be fixed
                if (player.hasPermission("simplesurvival.flyother")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    flyMethod(target);
                }
            } else {
                player.sendMessage(plugin.noPermission);
                }
        }
        return true;
    }

        private void flyMethod (Player player){
                if (list_flying_players.contains(player)) {
                    player.setFlying(false);
                    player.setAllowFlight(false);
                    player.sendMessage(plugin.flydisable);
                    list_flying_players.remove(player);
                } else if (!list_flying_players.contains(player)) {
                    list_flying_players.add(player);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(plugin.flyenabled);
                }
            }
        }



