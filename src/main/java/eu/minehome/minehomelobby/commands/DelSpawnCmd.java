package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomelobby.data.Data.*;

public class DelSpawnCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String delspawn = messagesfile.getString("spawn.delspawn");
    String nospawn = messagesfile.getString("spawn.nospawn");
    String delspawnuse = messagesfile.getString("spawm.delspawnuse");


    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(delspawnperms)) {
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length == 0) {
            if (!(warpsconfig.getString("Spawn") == null)) {
                warpsconfig.set("Spawn", null);
                player.sendMessage(prefix + delspawn);
                MinehomeLobby.getInstance().getLocationFile().save();
            } else{
                player.sendMessage(prefix + nospawn);
            }
        } else{
            player.sendMessage(prefix + delspawnuse);
        }
        return false;
    }
}
