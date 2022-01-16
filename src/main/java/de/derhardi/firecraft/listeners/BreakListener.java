package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BreakListener implements Listener {

    @EventHandler
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        FCPlayer player = new FCPlayer(e.getPlayer());
        player.blockBreaked();
    }
}
