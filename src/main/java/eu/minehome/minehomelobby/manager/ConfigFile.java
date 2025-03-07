package eu.minehome.minehomelobby.manager;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {
    public final File file = new File(MinehomeLobby.getInstance().getDataFolder().getPath(), "config.yml");
    public final FileConfiguration configfile = YamlConfiguration.loadConfiguration(file);

    public void createFile() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        addDefault();
    }

    public void addDefault() {
        configfile.options().copyDefaults(true);
        // Add all toggen function
        configfile.addDefault("Lobby-World", "world");
        configfile.addDefault("Messages.Join", true);
        configfile.addDefault("Messages.Quit", true);
        configfile.addDefault("Messages.Actionbar", true);
        save();
    }

    public void save() {
        try {
            configfile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfigfile() {
        return configfile;
    }
}