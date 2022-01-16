package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import de.derhardi.firecraft.util.Prefix;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        FCPlayer player = new FCPlayer(event.getPlayer());
        // Join Message
        event.joinMessage(Component.text(Prefix.ARROW_RIGHT.getPrefix() + Prefix.JOINED.getPrefix() + "§6" + player.getPlayer().getName() + " §7hat den Server betreten."));
        player.setOnline();
    }
}
