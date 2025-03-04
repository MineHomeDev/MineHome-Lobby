package eu.minehome.minehomeLobby.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class LobbyInventory {
    public static void GetLobbyInventory(Player p) {

        // Navigator
        ItemStack Navigator = new ItemStack(Material.COMPASS);
        ItemMeta NavigatorMeta = Navigator.getItemMeta();
        NavigatorMeta.setDisplayName("§b§lNavigator");
        Navigator.setItemMeta(NavigatorMeta);

        // LobbySwitcher
        ItemStack LobbySwitcher = new ItemStack(Material.NETHER_STAR);
        ItemMeta LobbySwitcherMeta = LobbySwitcher.getItemMeta();
        LobbySwitcherMeta.setDisplayName("§b§lLobbySwitcher");
        LobbySwitcher.setItemMeta(LobbySwitcherMeta);

        // Settings
        ItemStack Settings = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta playerheadmeta = (SkullMeta) Settings.getItemMeta();
        playerheadmeta.setOwner(p.getName());
        playerheadmeta.setDisplayName("§b§l" + p.getName());
        Settings.setItemMeta(playerheadmeta);

        // Give Player Lobby Inventory
        p.getInventory().setItem(2, Navigator);
        p.getInventory().setItem(4, LobbySwitcher);
        p.getInventory().setItem(6, Settings);
    }
}
