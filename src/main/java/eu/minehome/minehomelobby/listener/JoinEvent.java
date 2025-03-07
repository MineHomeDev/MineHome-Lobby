package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;

import eu.minehome.minehomelobby.manager.WorldUpdate;
import eu.minehome.minehomelobby.utils.LobbyInventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;


import static eu.minehome.minehomelobby.data.Data.*;

public class JoinEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");
    boolean joinmsg = configfile.getBoolean("Messages.Join");
    boolean joinactionbar = configfile.getBoolean("Messages.Actionbar");

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String actionbar = messagesfile.getString("actionbar");

    @EventHandler
    public void OnPlayerJoinEvent(PlayerJoinEvent e){

        Player p =e.getPlayer();

        if (p.getWorld().getName().equals(lobbyworld)){
            if (joinactionbar == true){
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!p.isOnline()) {
                            cancel(); // this cancels it when they leave
                        }
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbar));
                    }
                }.runTaskTimer(MinehomeLobby.getInstance() /*<-- your plugin instance*/, 5L, 5L);
            }
            if (joinmsg == true){
                e.setJoinMessage(joinmsg + e.getPlayer().getName());
            }else {
                e.setJoinMessage(null);
            }
            p.setGameMode(GameMode.SURVIVAL);
            p.setFoodLevel(20);
            p.setHealth(20);
            p.getInventory().clear();
            LobbyInventory.GetLobbyInventory(e.getPlayer());
            new WorldUpdate().DayNightCycle();
            p.performCommand("spawn");


        }

    }
}
