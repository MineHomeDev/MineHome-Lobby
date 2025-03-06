package eu.minehome.minehomelobby.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SneakInventory {
    public static void GetSneakInventory(Player p) {

        // Navigator
        ItemStack Fly = new ItemStack(Material.FEATHER);
        ItemMeta FlyMeta = Fly.getItemMeta();
        FlyMeta.setDisplayName("§b§lFly §7§l| §7§lRechtsklick");
        Fly.setItemMeta(FlyMeta);

        // LobbySwitcher
        ItemStack Build = new ItemStack(Material.BRICK);
        ItemMeta BuildMeta = Build.getItemMeta();
        BuildMeta.setDisplayName("§b§lBuild §7§l| §7§lRechtsklick");
        Build.setItemMeta(BuildMeta);

        // Give Player Lobby Inventory
        p.getInventory().setItem(2, Fly);
        p.getInventory().setItem(4, Build);
    }
}
