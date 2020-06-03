package me.alexander.listener;

import me.alexander.SimpleSurvival;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    SimpleSurvival plugin;

    public QuitListener(SimpleSurvival instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void QuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String joinText = plugin.quitmsg;

        joinText = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinText);

        e.setQuitMessage(joinText);
    }
}
