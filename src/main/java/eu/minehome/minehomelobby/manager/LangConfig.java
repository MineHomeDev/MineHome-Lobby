package eu.minehome.minehomelobby.manager;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangConfig {
    private final File file = new File(MinehomeLobby.getInstance().getDataFolder().getPath(), "messages.yml");
    private final FileConfiguration messagesfile = YamlConfiguration.loadConfiguration(file);

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

    private void addDefault() {
        messagesfile.options().copyDefaults(true);
        // Add all Messages to messages.yml
        // cfg.addDefault(messages.path, "messages");
        //messagesfile.addDefault("Version", "§7MineHome befidet sich noch in der §4Beta§7!");
        messagesfile.addDefault("prefix", "§7§l[§b§lLobby§7§l] ");
        messagesfile.addDefault("noperms", "§7Dazu hast du keine §c§lRechet§7!");
        messagesfile.addDefault("noplayer", "§7Du bist kein Spieler!");
        messagesfile.addDefault("actionbar", "§c§lDas Netzwerk ist in der Beta!");
        messagesfile.addDefault("connection.join", "§7§l[§a§+§7§l]");
        messagesfile.addDefault("connection.quit", "§7§l[§c§-§7§l]");
        messagesfile.addDefault("build.on", "§7Du bist im §a§lBaumodus§7!");
        messagesfile.addDefault("build.off", "§7Du bist nicht mehr im §c§lBaumodus§7!");
        messagesfile.addDefault("build.use", "§7Bitte benutze §c§l/build");
        messagesfile.addDefault("fly.on", "§7Du bist im §a§lFlugmodus§7!");
        messagesfile.addDefault("fly.off", "§7Du bist nicht mehr im §c§lFlugmodus§7!");
        messagesfile.addDefault("fly.use", "§7Bitte benutze §c§l/fly");
        messagesfile.addDefault("warp.warpuse", "§7Bitte benutze §c§l/warp <Name>");
        messagesfile.addDefault("warp.setwarpuse", "§7Bitte benutze §c§l/setwarp <Name>");
        messagesfile.addDefault("warp.delwarp", "§7Bitte benutze §c§l/delwarp <Name>");
        messagesfile.addDefault("warp.warplistuse", "§7Bitte benutze §c§l/warplist");
        messagesfile.addDefault("spawn.nospawn", "§7Der §c§lSpawn §7nicht gefunden!");
        messagesfile.addDefault("spawn.spawnsetuse", "§7Bitte benutze §c§l/setspawn");
        messagesfile.addDefault("spawn.setspawn", "§7Der §a§lSpawn §7wurde erfolgreich erstellt!");
        messagesfile.addDefault("spawn.delspawn", "§7Der §a§lSpawn §7wurde gelöscht");
        messagesfile.addDefault("spawn.spawntp", "§7Du bist am §a§lSpawn");
        save();
    }

    public void save() {
        try {
            messagesfile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getMessagesconfig() {
        return messagesfile;
    }
}
