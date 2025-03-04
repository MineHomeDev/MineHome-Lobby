package eu.minehome.minehomeLobby.commands;

import eu.minehome.minehomeLobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomeLobby.data.Data.*;

public class SetSpawnCmd implements CommandExecutor {

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(setspawnperms)) {
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 0) {
            warpsconfig.set("Spawn.world", player.getWorld().getName());
            warpsconfig.set("Spawn.x", player.getLocation().getX());
            warpsconfig.set("Spawn.y", player.getLocation().getY());
            warpsconfig.set("Spawn.z", player.getLocation().getZ());
            warpsconfig.set("Spawn.yaw", player.getLocation().getYaw());
            warpsconfig.set("Spawn.pitch", player.getLocation().getPitch());
            player.sendMessage(prefix + setspawn);
            MinehomeLobby.getInstance().getLocationFile().save();
        }else {
            player.sendMessage(prefix + setspawnuse);
        }

        return false;
    }
}

