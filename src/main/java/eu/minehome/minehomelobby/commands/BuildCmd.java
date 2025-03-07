package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import eu.minehome.minehomelobby.utils.LobbyInventory;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static eu.minehome.minehomelobby.data.Data.*;

public class BuildCmd implements CommandExecutor {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");
    String noplayer = messagesfile.getString("noplayer");
    String noperms = messagesfile.getString("noperms");
    String builduse = messagesfile.getString("build.use");
    String buildon = messagesfile.getString("build.on");
    String buildoff = messagesfile.getString("build.off");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof final Player player)){
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (!player.hasPermission(buildperms)){
            player.sendMessage(prefix + noperms);
            return true;
        }
        if (args.length > 0){
            player.sendMessage(prefix + builduse);
            return true;
        }
        if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE) || player.getGameMode().equals(GameMode.SPECTATOR)){
            player.getInventory().clear();
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(prefix + buildon);
        } else
            if (player.getGameMode().equals(GameMode.CREATIVE)) {
            player.getInventory().clear();
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(prefix + buildoff);
            LobbyInventory.GetLobbyInventory(player);
        }
        return false;
    }
}
