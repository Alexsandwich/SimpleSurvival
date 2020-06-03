package me.alexander.commands;

import me.alexander.SimpleSurvival;
import me.alexander.api.EntityBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Random;

public class PlayerList implements Listener, CommandExecutor {

    SimpleSurvival plugin;

    public PlayerList(SimpleSurvival instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cnd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            openMenu(player);
            }
        return true;
    }

    public Inventory gui = Bukkit.createInventory(null, 45, ChatColor.BLUE + "Player List");

    public void openMenu(Player player) {
        ArrayList<Player> list = new ArrayList<Player>(player.getServer().getOnlinePlayers());
        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.BLUE + "Player List");
        for (int i = 0; i < list.size(); i++) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            playerHead.setItemMeta(meta);
            meta.setDisplayName(list.get(i).getDisplayName());
            meta.setOwner(list.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            meta.setLore(lore);
            playerHead.setItemMeta(meta);
            gui.addItem(playerHead);
        }
        player.openInventory(gui);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void InventoryClickEvent(final InventoryClickEvent e){
        if (e.getView().getTitle().equals(ChatColor.BLUE + "Player List")) {
            Player player = (Player) e.getWhoClicked();
            ItemStack itemClicked = e.getCurrentItem();
            if(e.isRightClick() || e.isLeftClick()){
                e.setCancelled(true);
            }
        }
    }
}
