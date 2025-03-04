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
    public void OnLobbyClickEvent(PlayerInteractEvent e){

        Player player = e.getPlayer();

        if (player.getWorld().getName().equals(lobbyworld)){
           if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
               if (e.getItem().getItemMeta().getDisplayName().equals("§b§lFly §b§l| §b§lRechtsklick")){

                   player.performCommand("fly");
               }
           }
       }
    }
}
