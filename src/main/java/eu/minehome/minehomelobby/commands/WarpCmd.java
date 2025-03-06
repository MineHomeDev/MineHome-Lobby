package eu.minehome.minehomelobby.commands;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static eu.minehome.minehomelobby.data.Data.*;

public class WarpCmd implements CommandExecutor {

    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(prefix + noplayer);
            return true;
        }
        if (args.length == 1) {
            if (!(warpsconfig.getString(args[0]) == null)) {
                Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(warpsconfig.getString(args[0] + ".world"))),
                        warpsconfig.getDouble(args[0] + ".x"),
                        warpsconfig.getDouble(args[0] + ".y"),
                        warpsconfig.getDouble(args[0] + ".z"));
                loc.setPitch((float) warpsconfig.getDouble(args[0] + ".pitch"));
                loc.setYaw((float) warpsconfig.getDouble(args[0] + ".yaw"));

                player.teleport(loc);
                player.playSound(player.getLocation(), (Sound.ENTITY_ENDERMAN_TELEPORT), 1, 1);
                player.playEffect(EntityEffect.TELEPORT_ENDER);
                player.sendMessage(prefix + "§7Du bist beim Warp §a§l " + args[0] + "§7!");
            }else{
                player.sendMessage(prefix + "§7Warp §a§l" + args[0] + " §7nicht gefunden!");
            }
        }else player.sendMessage(prefix + warpuse);
        return false;
    }
}
