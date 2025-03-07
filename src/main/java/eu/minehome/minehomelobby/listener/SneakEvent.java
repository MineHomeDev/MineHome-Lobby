package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;
import eu.minehome.minehomelobby.utils.LobbyInventory;
import eu.minehome.minehomelobby.utils.SneakInventory;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import static eu.minehome.minehomelobby.data.Data.*;

public class SneakEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");

    @EventHandler
    public void ONSneakEvent(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        if (player.getWorld().getName().equals(lobbyworld) && player.hasPermission(sneakperms)) {
            if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                if (e.isSneaking()) {
                    e.getPlayer().getInventory().clear();
                    SneakInventory.GetSneakInventory(e.getPlayer());
                } else if (!e.isSneaking()) {
                    e.getPlayer().getInventory().clear();
                    LobbyInventory.GetLobbyInventory(e.getPlayer());
                }
            }
        }
    }
}
