package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;





public class SpawnCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String spawntp = messagesfile.getString("spawn.spawntp");
    String setspawnuse = messagesfile.getString("spawm.setspawnuse");
    String nospawn = messagesfile.getString("spawn.nospawn");

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (args.length == 0) {
            if (!(warpsconfig.getString("Spawn") == null)) {
                Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(warpsconfig.getString("Spawn.world"))),
                        warpsconfig.getDouble("Spawn.x"),
                        warpsconfig.getDouble("Spawn.y"),
                        warpsconfig.getDouble("Spawn.z"));
                loc.setPitch((float) warpsconfig.getDouble("Spawn.pitch"));
                loc.setYaw((float) warpsconfig.getDouble("Spawn.yaw"));

                player.teleport(loc);
                player.playSound(player.getLocation(), (Sound.ENTITY_ENDERMAN_TELEPORT), 1, 1);
                player.playEffect(EntityEffect.TELEPORT_ENDER);
                player.sendMessage(prefix + spawntp);
            }else{
                player.sendMessage(prefix + nospawn);
            }
        }else player.sendMessage(prefix + setspawnuse);
        return false;
    }
}
