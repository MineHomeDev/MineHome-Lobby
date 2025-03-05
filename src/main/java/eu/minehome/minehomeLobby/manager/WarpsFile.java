package eu.minehome.minehomeLobby.manager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import eu.minehome.minehomeLobby.MinehomeLobby;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpsFile {
    private final File file = new File(MinehomeLobby.getInstance().getDataFolder().getPath(), "warps.yml");
    private final FileConfiguration warpsconfig = YamlConfiguration.loadConfiguration(file);

    public void createFile() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
                Bukkit.getLogger().info("Minehome-Lobby Config wurde erstellt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Bukkit.getLogger().info("Minehome-Lobby Config wurde geladen");
        addDefault();
    }

    private void addDefault() {
        warpsconfig.options().copyDefaults(true);
        // Add all toggen function

        save();
    }

    public void save() {
        try {
            warpsconfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().info("Minehome-Lobby Config konnte nicht gespeichert werden");
        }
    }

    public FileConfiguration getLocationcfg() {
        return warpsconfig;
    }
}
