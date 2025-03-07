package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;
import eu.minehome.minehomelobby.data.Data.*;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemHeldEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");

    @EventHandler
    public void OnPlayerItemHeldEvent(PlayerItemHeldEvent e){
        Player p = e.getPlayer();

        if (p.getWorld().getName().equals(lobbyworld)){
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.1F, 0.1F);
        }
    }
}
