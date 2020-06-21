package me.alexander.events;

import me.alexander.SimpleSurvival;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    SimpleSurvival plugin;

    public JoinListener(SimpleSurvival instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void JoinEvent(PlayerJoinEvent e) {
        String joinText = plugin.joinmsg;

        joinText = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinText);

        e.setJoinMessage(joinText);

    }
}
