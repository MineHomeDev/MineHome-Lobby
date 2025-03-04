package eu.minehome.minehomeLobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomeLobby.data.Data.*;

public class FlyCmd implements CommandExecutor {
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
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(prefix + flyon);
        }



        return false;
    }
}
