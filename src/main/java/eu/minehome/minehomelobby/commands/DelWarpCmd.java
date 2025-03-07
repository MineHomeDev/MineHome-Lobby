package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomelobby.data.Data.*;

public class DelWarpCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String delwarpuse = messagesfile.getString("warp.delwarpuse");

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
