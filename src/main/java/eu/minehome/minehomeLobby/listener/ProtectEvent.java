package eu.minehome.minehomeLobby.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import static eu.minehome.minehomeLobby.data.Data.*;

public class ProtectEvent implements Listener {

    @EventHandler
    public void OnBlockPlaceEvent(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(lobbyworld)) {
            if(p.hasPermission(buildperms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                if (!dbugmsg.contains("null")){
                    p.sendMessage(dbugmsg);
                }else {
                    return;
                }
            }
        }
    }
    @EventHandler
    public void OnBlockBreakEvent(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(lobbyworld)) {
            if(p.hasPermission(buildperms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                if (!dbugmsg.contains("null")){
                    p.sendMessage(dbugmsg);
                }else {
                    return;
                }
            }
        }
    }
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketFillEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(lobbyworld)) {
            if(p.hasPermission(buildperms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                if (!dbugmsg.contains("null")){
                    p.sendMessage(dbugmsg);
                }else {
                    return;
                }
            }
        }
    }
    @EventHandler
    public void BucketEmptyEvent(PlayerBucketEmptyEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(lobbyworld)) {
            if(p.hasPermission(buildperms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                if (!dbugmsg.contains("null")){
                    p.sendMessage(dbugmsg);
                }else {
                    return;
                }
            }
        }
    }
    @EventHandler
    public void ItemMoveEvent(InventoryClickEvent e){
        if (e.getWhoClicked().getWorld().getName().equals(lobbyworld)){
            if (e.getWhoClicked() instanceof Player p){
                if (p.hasPermission(buildperms) && p.getGameMode() == (GameMode.CREATIVE)){
                    e.setCancelled(false);
                } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                    e.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getPlayer().getWorld().getName().equals(lobbyworld)){
            if (p.hasPermission(buildperms) && p.getGameMode().equals(GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(buildperms) || p.getGameMode() != (GameMode.CREATIVE)) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getClickedBlock().getType().isInteractable()){
                        e.setCancelled(true);
                    }
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

}
