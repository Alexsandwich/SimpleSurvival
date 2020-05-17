package me.alexander.listener;

import me.alexander.SimpleSurvival;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListener implements Listener {

    SimpleSurvival plugin;

    //TODO Fix Glitch Where if account is on same computer, the same name is used
    public JoinListener(SimpleSurvival instance) {
        plugin = instance;
    }

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        plugin.joinmsg = plugin.joinmsg.replace("%player%", player.getName());
        e.setJoinMessage(plugin.joinmsg);
    }
}
