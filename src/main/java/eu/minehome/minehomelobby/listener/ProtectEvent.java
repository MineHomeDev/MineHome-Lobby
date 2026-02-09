package eu.minehome.minehomelobby.listener;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static eu.minehome.minehomelobby.data.Data.*;

public class ProtectEvent implements Listener {

    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");

    @EventHandler
    public void OnPlaceEvent (BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if(e.getPlayer().getWorld().getName().equals(lobbyworld)) {
            if (player.hasPermission(buildperms) && player.getGameMode().equals(GameMode.CREATIVE)) {
                e.setCancelled(false);
            }else if (!player.hasPermission(buildperms) || player.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
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
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void OnFramjupm(PlayerInteractEvent e){
        if (e.getAction() != Action.PHYSICAL) return;

        Block b = e.getClickedBlock();
        if (b == null) return;

        Material type = b.getType();

        // 1) Direkt auf Farmland
        if (type == Material.FARMLAND) {
            e.setCancelled(true);
            return;
        }

        // 2) Auf Crop/Pflanze treten -> darunter Farmland schützen
        // Tag.CROPS deckt z.B. WHEAT, CARROTS, POTATOES, BEETROOTS, STEMS ab
        if (Tag.CROPS.isTagged(type)) {
            Block below = b.getRelative(BlockFace.DOWN);
            if (below.getType() == Material.FARMLAND) {
                e.setCancelled(true);
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
    public void Ex(EntityExplodeEvent e){
        if (e.getLocation().getWorld().getName().equals(lobbyworld)){
            e.setCancelled(true);
        }
    }

}
