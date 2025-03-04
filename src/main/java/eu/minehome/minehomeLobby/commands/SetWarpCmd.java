package eu.minehome.minehomeLobby.commands;


import eu.minehome.minehomeLobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import static eu.minehome.minehomeLobby.data.Data.*;

public class SetWarpCmd implements CommandExecutor {

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(setwarpperms)) {
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 1) {
            warpsconfig.set(args[0] + ".world", player.getWorld().getName());
            warpsconfig.set(args[0] + ".x", player.getLocation().getX());
            warpsconfig.set(args[0] + ".y", player.getLocation().getY());
            warpsconfig.set(args[0] + ".z", player.getLocation().getZ());
            warpsconfig.set(args[0] + ".yaw", player.getLocation().getYaw());
            warpsconfig.set(args[0] + ".pitch", player.getLocation().getPitch());
            player.sendMessage(prefix + "§7Warp §a§l" + args[0] + " §7wurde erfolgreich erstellt!");
            MinehomeLobby.getInstance().getLocationFile().save();
        }else {
            player.sendMessage(prefix + setwarpuse);
        }

        return false;
    }
}
