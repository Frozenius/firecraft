package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.concurrent.ExecutionException;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) throws ExecutionException, InterruptedException {
        FCPlayer player = new FCPlayer(event.getPlayer());
        player.deathCount();
    }
}
