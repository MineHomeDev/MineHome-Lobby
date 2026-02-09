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
        messagesfile.addDefault("prefix", "§8§l[§b§lLobby§8§l] ");

        messagesfile.addDefault("noperms", "§7§lDazu hast du keine §c§lRechte§7§l!");
        messagesfile.addDefault("noplayer", "§7Bist du sicher dass du ein §c§lSpieler §7§lbist!");
        messagesfile.addDefault("actionbar", "§c§lDas Netzwerk ist in der Beta!");

        messagesfile.addDefault("connection.join", "§7§l[§a§l+§7§l]");
        messagesfile.addDefault("connection.quit", "§7§l[§c§l-§7§l]");

        messagesfile.addDefault("build.on", "§7§lDer §a§lBaumodus §7§lWurde §a§laktiviert§7§l!");
        messagesfile.addDefault("build.off", "§7§lDer §c§lBaumodus §7§lWurde §c§ldeaktiviert§7§l!");
        messagesfile.addDefault("build.use", "§7§lBenutze §a§l/build §7§lum zu §7§lwechseln§7§l!");

        messagesfile.addDefault("fly.on", "§7§lDer §a§lFlugmodus §7§lWurde §a§laktiviert§7§l!");
        messagesfile.addDefault("fly.off", "§7§lDer §c§lFlugmodus §7§lWurde §c§ldeaktiviert§7§l!");
        messagesfile.addDefault("fly.use", "§7§lBenutze §a§l/fly §7§lum zu §7§lwechseln§7§l!");

        messagesfile.addDefault("warp.warpuse", "§7Bitte benutze §c§l/warp <Name>");
        messagesfile.addDefault("warp.setwarpuse", "§7Bitte benutze §c§l/setwarp <Name>");
        messagesfile.addDefault("warp.delwarp", "§7Bitte benutze §c§l/delwarp <Name>");
        messagesfile.addDefault("warp.warplistuse", "§7Bitte benutze §c§l/warplist");


        messagesfile.addDefault("spawn.nospawn", "§7§lDer §c§lSpawn §7§lnicht §c§lgefunden!");
        messagesfile.addDefault("spawn.spawnsetuse", "§7§lBitte benutze §a§l/setspawn §7§lum denn spawn zu erstellen");
        messagesfile.addDefault("spawn.setspawn", "§7§lDer §a§lSpawn §7§lwurde erfolgreich §a§lerstellt!");
        messagesfile.addDefault("spawn.delspawn", "§7§lDer §c§lSpawn §7§lwurde §c§lgelöscht");
        messagesfile.addDefault("spawn.spawntp", "§7§lDu bist am §a§lSpawn");
        messagesfile.addDefault("spawn.usespawn", "§7§lBenutze §a§l/spawn §7§lum zum Spawn zu gelangen");
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
