package de.derhardi.firecraft.util;

public enum Prefix {

    // System prefixes
    PREFIX("§8[§aUltimate§2Survival§8] §7"), // General prefix
    INFO("§8[§a§lI§8] §7"), // Prefix for most of messages
    WARNING("§8[§6§l!§8] §7"), // Prefix e. g. No Permissions
    ERROR("§8[§c§l!§8] §7"), // If an error occures, this message will be sent
    ARROW_LEFT("§8<§7< §7"), // Arrows...
    ARROW_RIGHT("§7>§8> §7"), // Arrows..
    JOINED("§8[§a§l+§8] §7"),
    LEFT("§8[§c§l-§8] §7"),
    // Specific prefixes
    WATCHTOWER("§8[§4Watchtower§8] §7"), // e.g. Spy, Hacks, etc.
    MSG("§8[§aMSG§8] §7"), // Prefix for private messages
    SHOPS("§8[§9Shops§8] §7"), // Prefix for shops
    SKILLS("§8[§6Skills§8] §7"), // Prefix for Skills
    SPAWNER("§8[§5Spawner§8] §7"), // Prefix for spawner
    CLANS("§8[§2Clans§8] §7");

    private String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }
}
