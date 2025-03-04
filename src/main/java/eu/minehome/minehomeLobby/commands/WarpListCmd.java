package eu.minehome.minehomeLobby.commands;

import eu.minehome.minehomeLobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomeLobby.data.Data.*;

public class WarpListCmd implements CommandExecutor {

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(warplistperms)) {
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 0) {
            int i = 0;
            player.sendMessage(prefix + "§7§lAlle §a§lWarps:");
            for (String key : warpsconfig.getKeys(true)) {
                if (!(key.contains("."))) {
                    i += 1;
                    player.sendMessage(prefix + "§7§l" + i + ". §a§l'" + key + "'");
                }
            }
        } else player.sendMessage(prefix + warplistuse);

        return false;
    }
}
