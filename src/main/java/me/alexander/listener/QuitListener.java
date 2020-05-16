package me.alexander.listener;

import me.alexander.SimpleSurvival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    SimpleSurvival plugin;

    //TODO Fix Glitch Where if account is on same computer, the same name is used
    public QuitListener(SimpleSurvival instance) {
        plugin = instance;
    }

    @EventHandler
    public void QuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        plugin.quitmsg = plugin.quitmsg.replace("%player%", player.getName());
        e.setQuitMessage(plugin.quitmsg);
    }
}
