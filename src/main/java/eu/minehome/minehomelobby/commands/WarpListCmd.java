package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomelobby.data.Data.*;

public class WarpListCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String warplistuse = messagesfile.getString("warp.warplistuse");

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(warplistperms)) {
            player.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 0) {
            int i = 0;
            player.sendMessage(prefix + "§7§lAlle §a§lWarps §7§lder Lobby:");
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
