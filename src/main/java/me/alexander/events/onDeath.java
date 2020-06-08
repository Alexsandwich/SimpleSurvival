package me.alexander.events;

import me.alexander.SimpleSurvival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class onDeath implements Listener {

    SimpleSurvival plugin;

    public onDeath(SimpleSurvival instance) {
        plugin = instance;
    }

    public static ArrayList<UUID> emptyarmor = new ArrayList<>();
    public static ArrayList<UUID> emptyinv = new ArrayList<>();
    public static HashMap<UUID, ItemStack[]> armorContents = (HashMap)new HashMap<>();
    public static HashMap<UUID, ItemStack[]> inventoryContents = (HashMap)new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = event.getEntity();
            for (ItemStack armorContent : player.getInventory().getArmorContents()) {
                if(armorContent != null &&
                        !wasArmorSlotsEmpty(player.getUniqueId()))
                    armorContents.put(player.getUniqueId(), player.getInventory().getContents());

                }
                for (ItemStack inventoryContent : player.getInventory().getContents()) {
                    if (inventoryContent != null &&
                    !wasInventoryEmpty(player.getUniqueId()))
                        inventoryContents.put(player.getUniqueId(), player.getInventory().getContents());
                }

            }
        }

    public static boolean wasArmorSlotsEmpty(UUID uuid) {
        return emptyarmor.contains(uuid);
    }

    public static boolean wasInventoryEmpty(UUID uuid) {
        return emptyinv.contains(uuid);
    }
}
