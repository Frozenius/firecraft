package de.derhardi.firecraft.database;

import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

public class FCPlayer {
    private final Player player;

    public FCPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setOnline() {
        FCDatabase.setData(player.getUniqueId().toString(), "online", true);
        firstJoin();
    }

    public void setOffline() {
        FCDatabase.setData(player.getUniqueId().toString(), "online", false);
        setPlaytime();
    }

    public void firstJoin() {
        try {
            if(!FCDatabase.playerExists(player.getUniqueId().toString())) {
                FCDatabase.setData(player.getUniqueId().toString(), "firstjoin", System.currentTimeMillis());
                FCDatabase.setData(player.getUniqueId().toString(), "playtime", System.currentTimeMillis());
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Object getPlaytime() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "playtime");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    public void setPlaytime() {
        long currentPlaytime = (Long) getPlaytime();
        long newPlaytime = currentPlaytime + (System.currentTimeMillis() - currentPlaytime);
        FCDatabase.setData(player.getUniqueId().toString(), "playtime", newPlaytime);

    }

    /**
     *
     * @return the amount of deaths the player has
     */
    private Object getDeaths() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "deaths");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    /**
     * set the amount of death the player has
     */
    public void deathCount() {
        Object deaths = getDeaths();
        if(deaths == null) {
            FCDatabase.setData(player.getUniqueId().toString(), "deaths", 1);
            return;
        }
        long newDeaths = (Long) deaths + 1;
        System.out.println(newDeaths);
        FCDatabase.setData(player.getUniqueId().toString(), "deaths", newDeaths);
    }

    /**
     *
     * @return the amount of players the player has killed
     */
    private Object getKills() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "kills");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    /**
     * set the amount of player kills
     */
    public void killCount() {
        Object kills = getKills();
        if (kills == null) {
            FCDatabase.setData(player.getUniqueId().toString(), "kills", 1);
            return;
        }
        long newKills = (Long) kills + 1;
        FCDatabase.setData(player.getUniqueId().toString(), "kills", newKills);
    }

    /**
     *
     * @return the amount of mobs the player has killed
     */
    private Object getMobs() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "mobs");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    /**
     * set the amount ob mobs the player has killed
     */
    public void mobCount() {
        Object mobs = getMobs();
        if(mobs == null) {
            FCDatabase.setData(player.getUniqueId().toString(), "mobs", 1);
            return;
        }
        long newMobs = (Long) mobs + 1;
        FCDatabase.setData(player.getUniqueId().toString(), "mobs", newMobs);
    }

    /**
     *
     * @return the amount of blocks the player has placed
     */
    private Object getBlocks() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "placedblocks");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    /**
     * set the amount of blocks the player has placed
     */
    public void blockPlaced() {
        Object blocks = getBlocks();
        if(blocks == null) {
            FCDatabase.setData(player.getUniqueId().toString(), "placedblocks", 1);
            return;
        }
        long newBlocks = (Long) blocks + 1;
        FCDatabase.setData(player.getUniqueId().toString(), "placedblocks", newBlocks);
    }

    /**
     *
     * @return The amount of blocks the player has broken
     */
    private Object getBreaked() {
        try {
            return FCDatabase.getData(player.getUniqueId().toString(), "breakedblocks");
        } catch (ExecutionException | InterruptedException e) {
            return 0;
        }
    }

    /**
     * set the amount of blocks that the player has broken
     */
    public void blockBreaked() {
        Object blocks = getBreaked();
        if(blocks == null) {
            FCDatabase.setData(player.getUniqueId().toString(), "breakedblocks", 1);
            return;
        }
        long newBlocks = (Long) blocks + 1;
        FCDatabase.setData(player.getUniqueId().toString(), "breakedblocks", newBlocks);
    }
}
