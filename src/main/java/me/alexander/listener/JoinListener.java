package me.alexander.listener;

import me.alexander.SimpleSurvival;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListener implements Listener {

    SimpleSurvival plugin;

    public JoinListener(SimpleSurvival instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void JoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String joinText = plugin.joinmsg;

        // We parse the placeholders using "setPlaceholders"
        joinText = PlaceholderAPI.setPlaceholders(e.getPlayer(), joinText);

        e.setJoinMessage(joinText);
    }
}
