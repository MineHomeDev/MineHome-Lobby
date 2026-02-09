package eu.minehome.minehomelobby.listener;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

import java.util.Objects;

import static eu.minehome.minehomelobby.data.Data.buildperms;

public class PlayerProtectEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    FileConfiguration warpsconfig = MinehomeLobby.getInstance().getWarpsFile().getLocationcfg();
    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String lobbyworld = configfile.getString("Lobby-World");
    String prefix = messagesfile.getString("prefix");
    String nospawn = messagesfile.getString("spawn.nospawn");


    @EventHandler
    public void onPlayerFood (FoodLevelChangeEvent e){
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerFood (EntityDamageEvent e){
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerFood (EntityDamageByBlockEvent e){
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerFood (EntityDamageByEntityEvent e){
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerItemDamageEvent (PlayerItemDamageEvent e){
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onMobDamagePlayer(EntityDamageByEntityEvent e) {
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            if (e.getEntity() instanceof Player) {
                if (e.getDamager() instanceof LivingEntity && !(e.getDamager() instanceof Player)) {
                    e.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void PlayerDropItem(PlayerDropItemEvent e){
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerPickupItem(PlayerPickupItemEvent e){
        Player player = e.getPlayer();
        if (player.getWorld().getName().equals(lobbyworld)){
            if (player.hasPermission(buildperms) && player.getGameMode().equals(GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!player.hasPermission(buildperms) || player.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void EntityPickupItem(EntityPickupItemEvent e){
        if (e.getEntity().getWorld().getName().equals(lobbyworld)){
            if (e.getEntity() instanceof Player){
                Player player = (Player) e.getEntity();
                if (player.hasPermission(buildperms) && player.getGameMode() == GameMode.CREATIVE){
                    e.setCancelled(false);
                }else if (!player.hasPermission(buildperms) || player.getGameMode() != (GameMode.CREATIVE)) {
                    e.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void ItemSwapHandEvent(PlayerSwapHandItemsEvent e){
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent e){
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            e.setKeepInventory(true);
            e.setDeathMessage(null);
        }
    }
    @EventHandler
    public void PlayerFallEvent(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            if (e.getFrom().getY() != e.getTo().getY()){
                if (p.getLocation().getY() <= -10) {
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
                    } else {
                        p.teleport(Bukkit.getWorld(Objects.requireNonNull(configfile.getString("Lobby-World"))).getSpawnLocation());
                        p.sendMessage(prefix + nospawn);
                    }
                }
            }
        }
    }
}
