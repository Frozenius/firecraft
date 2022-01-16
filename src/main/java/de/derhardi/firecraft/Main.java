package de.derhardi.firecraft;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import de.derhardi.firecraft.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;

public final class Main extends JavaPlugin {
    FirebaseApp app;
    private Firestore db;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Firecraft is starting up...");
        setupFirebase();
        listenerRegistration();
        commandRegistration();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Firecraft is shutting down...");
    }

    private void listenerRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new KillListener(), this);
        pm.registerEvents(new BreakListener(), this);
        pm.registerEvents(new PlaceListener(), this);
    }

    private void commandRegistration() {
        // Register commands
    }

    /**
     * Setup Firebase
     */
    private void setupFirebase(){
        try {
            synchronized (this) {
                InputStream seriveAccount = getClass().getClassLoader().getResourceAsStream("credos.json");
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(seriveAccount))
                        .build();
                app = FirebaseApp.initializeApp(options);
                db = FirestoreClient.getFirestore(app);
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Firebase is ready!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Firestore getDb() {
        return db;
    }
}
