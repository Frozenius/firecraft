package de.derhardi.firecraft.database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import de.derhardi.firecraft.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FCDatabase {
    private static final Main plugin = Main.getPlugin(Main.class);

    public static Object getData(String uuid, String key) throws ExecutionException, InterruptedException {
        DocumentReference docRef = plugin.getDb()
                .collection("players")
                .document(uuid);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        return document.get(key);
    }

    public static void setData(String uuid, String key, Object value) {
        Map<String, Object> docData = new HashMap<>();
        docData.put(key, value);
        ApiFuture<WriteResult> future = plugin.getDb()
                .collection("players")
                .document(uuid)
                .set(docData, SetOptions.merge());
    }

    public static boolean playerExists(String uuid) throws ExecutionException, InterruptedException {
        DocumentReference docRef = plugin.getDb()
                .collection("players")
                .document(uuid);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        return document.exists();
    }
}
