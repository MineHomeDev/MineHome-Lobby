package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;

import eu.minehome.minehomelobby.manager.WorldUpdate;
import eu.minehome.minehomelobby.utils.LobbyInventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.Objects;

import static eu.minehome.minehomelobby.data.Data.*;

public class JoinEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();
    String lobbyworld = configfile.getString("Lobby-World");
    String prefix = messagesfile.getString("prefix");
    String nospawn = messagesfile.getString("spawn.nospawn");
    boolean joinmsg = configfile.getBoolean("Messages.Join");
    boolean joinactionbar = configfile.getBoolean("Messages.Actionbar");

    String actionbar = messagesfile.getString("actionbar");
    String joinmsgtext= messagesfile.getString("connection.join");

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
                e.setJoinMessage(joinmsgtext + e.getPlayer().getName());
            }else {
                e.setJoinMessage(null);
            }
            p.setGameMode(GameMode.SURVIVAL);
            p.setFoodLevel(20);
            p.setHealth(20);
            p.getInventory().clear();
            LobbyInventory.GetLobbyInventory(e.getPlayer());
            new WorldUpdate().DayNightCycle();

            if (!(warpsconfig.getString("Spawn") == null)) {
                Location SpawnOnJoin = new Location(Bukkit.getWorld(Objects.requireNonNull(warpsconfig.getString("Spawn.world"))),
                        warpsconfig.getDouble("Spawn.x"),
                        warpsconfig.getDouble("Spawn.y"),
                        warpsconfig.getDouble("Spawn.z"));
                SpawnOnJoin.setPitch((float) warpsconfig.getDouble("Spawn.pitch"));
                SpawnOnJoin.setYaw((float) warpsconfig.getDouble("Spawn.yaw"));
                p.teleport(SpawnOnJoin);
                p.playSound(p.getLocation(), (Sound.ENTITY_ENDERMAN_TELEPORT), 1, 1);
                p.playEffect(EntityEffect.TELEPORT_ENDER);
            }else {
                p.sendMessage(prefix + nospawn);
            }



        }

    }
}
