package de.derhardi.firecraft.listeners;

import de.derhardi.firecraft.database.FCPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillListener implements Listener {

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (!(e.getEntity().getKiller() instanceof Player)) return;
        FCPlayer player = new FCPlayer(e.getEntity().getKiller());
        if(e.getEntity() instanceof Player){
            player.killCount();
        } else {
            player.mobCount();
        }
    }
}
