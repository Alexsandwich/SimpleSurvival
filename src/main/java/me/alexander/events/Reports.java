package me.alexander.events;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import jdk.tools.jlink.plugin.Plugin;
import me.alexander.SimpleSurvival;
import me.alexander.api.AnvilGUI;
import me.alexander.commands.Report;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Reports implements Listener {

    SimpleSurvival plugin;


    public Reports(SimpleSurvival instance) {
        plugin = instance;
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle() != null && event.getView().getTitle().equals(format("&8Report &3{target}").replace("{target}", (CharSequence) Report.reported.get(player))) &&
                event.getCurrentItem() != null &&
                event.getCurrentItem().getItemMeta() != null &&
                event.getCurrentItem().getItemMeta().getDisplayName() != null)
            if (!event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bKillAura")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bFlight")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bAnti-KB")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bSpeed")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bAimbot")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bOffensive Chat")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bOffensive Chat")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bFastEat")) &&
                    !event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&cCancel"))) {
                event.setCancelled(true);
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bKillAura"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bKillAura\n&8&m------------------------------"));
                }
                player.closeInventory();
                //  Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bFlight"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bFlight\n&8&m------------------------------"));
                }
                player.closeInventory();
                //   Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bAnti-KB"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bAnti-KB\n&8&m------------------------------"));
                }
                player.closeInventory();
                //   Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bSpeed"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bSpeed\n&8&m------------------------------"));
                }
                player.closeInventory();
                //  Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bAimbot"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bAimbot\n&8&m------------------------------"));
                }
                player.closeInventory();
                // Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bJesus"))) {
                event.setCancelled(true);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bOffensive Chat\n&8&m------------------------------"));
                }
                player.closeInventory();
                // Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bFast Eat"))) {
                event.setCancelled(true);

                player.closeInventory();
                // Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&bOffensive Chat"))) {
                event.setCancelled(true);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (all.hasPermission("admin"))
                        all.sendMessage(format("&8&m------------------------------\n&3&lReport:\n&7 &7- &3Reported: &b" + (String) Report.reported

                                .get(player) + "\n&7 &7- &3Reported by: &b" + event
                                .getWhoClicked().getName() + "\n&7 &7- &3Reason: &bFastEat\n&8&m------------------------------"));
                }
                player.closeInventory();
                // Cooldown.setCooldown(player, "reportcooldown", System.currentTimeMillis() + (Main.getMain().getConfig().getInt("Report.report-cooldown") * 60 * 1000));
                player.sendMessage(format("&aWe have received your report. Thanks in advance!"));
            } else if (event.getView().getTitle() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals(format("&cCancel"))) {
                event.setCancelled(true);
                player.closeInventory();
            }
    }

    private String format(String var) {
        return ChatColor.translateAlternateColorCodes('&', var);
    }



}