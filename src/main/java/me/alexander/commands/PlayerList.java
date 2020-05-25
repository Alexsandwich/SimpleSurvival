package me.alexander.commands;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.alexander.SimpleSurvival;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class PlayerList implements CommandExecutor {

    SimpleSurvival plugin;

    public PlayerList(SimpleSurvival instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cnd, String s, String[]args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            openMenu(player);

        }
        return true;
    }

    //TODO Fix the player skin on skull
    public void openMenu(Player player){
        ArrayList<Player> list = new ArrayList<Player>(player.getServer().getOnlinePlayers());
        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.BLUE + "Player List");
        for (int i = 0; i < list.size(); i++){
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            playerHead.setItemMeta(meta);
            meta.setDisplayName(list.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            meta.setLore(lore);
            playerHead.setItemMeta(meta);
            gui.addItem(playerHead);
        }
        player.openInventory(gui);
    }

}
