package eu.minehome.minehomeLobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static eu.minehome.minehomeLobby.data.Data.*;
import static eu.minehome.minehomeLobby.data.Data.noperms;

public class LobbyClickEvent implements Listener {

    @EventHandler
    public void OnLobbyClickEvent(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (player.getWorld().getName().equals(lobbyworld)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                // Check if the player is holding an item
                if (e.getItem() != null && e.getItem().getItemMeta() != null) {
                    String displayName = e.getItem().getItemMeta().getDisplayName();
                    // Handle the item logic
                    if (!"§b§lFly §7§l| §7§lRechtsklick".equals(displayName)) {
                        e.setCancelled(true);
                    } else {
                        player.performCommand("fly");
                    }
                }
            }
        }
    }
}
