package eu.minehome.minehomeLobby.listener;

import eu.minehome.minehomeLobby.utils.NavigatorInventory;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static eu.minehome.minehomeLobby.data.Data.*;


public class LobbyClickEvent implements Listener {

    @EventHandler
    public void OnLobbyClickEvent(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null && e.getItem().getItemMeta() != null) {
                String displayName = e.getItem().getItemMeta().getDisplayName();
                switch (displayName) {
                    case "§b§lFly §7§l| §7§lRechtsklick":
                        player.performCommand("fly");
                        break;
                    case "§b§lNavigator §7§l| §7§lRechtsklick":
                        // Anstelle `new NavigatorInventory`, direkte Funktionalität:
                        new NavigatorInventory().open( player);
                        break;
                    default:
                        if (player.getWorld().getName().equals(lobbyworld)){
                            if (player.hasPermission(buildperms) && player.getGameMode() == GameMode.CREATIVE){
                                e.setCancelled(false);
                                break;
                            }else if (!player.hasPermission(buildperms) || player.getGameMode() != (GameMode.CREATIVE)) {
                                e.setCancelled(true);
                            }
                        }
                        break;
                }
            }
        }
    }
}
