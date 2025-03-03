package eu.minehome.minehomeLobby.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import static eu.minehome.minehomeLobby.data.Data.*;

public class ItemHeldEvent implements Listener {

    @EventHandler
    public void OnPlayerItemHeldEvent(PlayerItemHeldEvent e){
        Player p = e.getPlayer();

        if (p.getWorld().getName().equals(lobbyworld)){
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.1F, 0.1F);
        }
    }
}
