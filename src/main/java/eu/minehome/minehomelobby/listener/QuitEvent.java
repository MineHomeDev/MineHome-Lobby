package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");
    boolean quitmsg = configfile.getBoolean("Messages.Quit");

    @EventHandler
    public void OnPlayerQuitEvent(PlayerQuitEvent e){
        Player p =e.getPlayer();
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            if (quitmsg == true){
                e.setQuitMessage(quitmsg + e.getPlayer().getName());
            }else {
                e.setQuitMessage(null);
            }
        }
    }
}
