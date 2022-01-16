package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        FCPlayer player = new FCPlayer(event.getPlayer());
        player.blockPlaced();
    }
}
