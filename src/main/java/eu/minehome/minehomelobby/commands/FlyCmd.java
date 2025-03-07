package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomelobby.data.Data.*;

public class FlyCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String flyuse = messagesfile.getString("fly.use");
    String flyon = messagesfile.getString("fly.on");
    String flyoff = messagesfile.getString("fly.off");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)){
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(flyperms)){
            sender.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length > 0){
            sender.sendMessage(prefix + flyuse);
            return true;
        }

        if (player.getAllowFlight()){
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(prefix + flyoff);
        }else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(prefix + flyon);
        }

        return false;
    }
}
