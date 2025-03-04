package eu.minehome.minehomeLobby.commands;

import eu.minehome.minehomeLobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomeLobby.data.Data.*;

public class DelWarpCmd implements CommandExecutor {

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(delwarpperms)) {
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 1) {
            if (!(warpsconfig.getString(args[0]) == null)) {
                warpsconfig.set(args[0], null);
                player.sendMessage(prefix + "§7Warp §a§l " + args[0] + " §7wurde gelöscht!");
                MinehomeLobby.getInstance().getLocationFile().save();
            } else{
                player.sendMessage(prefix + "§7Warp §a§l " + args[0] + " §7nicht gefunden!");
            }
        } else{
            player.sendMessage(prefix + delwarpuse);
        }
        return false;
    }

}
