package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import de.derhardi.firecraft.util.Prefix;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        FCPlayer player = new FCPlayer(event.getPlayer());
        // Quit Message
        event.quitMessage(Component.text(Prefix.ARROW_RIGHT.getPrefix() + Prefix.LEFT.getPrefix() + "§6" + player.getPlayer().getName() + " §7hat den Server verlassen."));
        player.setOffline();
    }

}
