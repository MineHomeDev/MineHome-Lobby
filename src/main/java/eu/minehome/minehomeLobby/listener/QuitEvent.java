package eu.minehome.minehomeLobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static eu.minehome.minehomeLobby.data.Data.lobbyworld;
import static eu.minehome.minehomeLobby.data.Data.quitmsg;

public class QuitEvent implements Listener {

    @EventHandler
    public void OnPlayerQuitEvent(PlayerQuitEvent e){
        Player p =e.getPlayer();
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            if (!quitmsg.contains("null")){
                e.setQuitMessage(quitmsg + e.getPlayer().getName());
            }else {
                e.setQuitMessage(null);
            }

        }
    }
}
