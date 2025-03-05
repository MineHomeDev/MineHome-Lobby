package eu.minehome.minehomeLobby.utils;

import eu.minehome.minehomeLobby.menu.SimpleMenu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;

import static eu.minehome.minehomeLobby.data.Data.prefix;

public class NavigatorInventory extends SimpleMenu {
    public NavigatorInventory() {
        super(Rows.FIVE, Component.text("§b§lNavigator"));

    }
    @Override
    public void onSetItems() {
        // This method can be used to add items to the GUI
        final ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
        final ItemMeta spawn = Spawn.getItemMeta();
        spawn.displayName(Component.text("§b§lSpawn"));
        Spawn.setItemMeta(spawn);

        final ItemStack ComingSoon = new ItemStack(Material.BARRIER);
        final ItemMeta comingsoon= ComingSoon.getItemMeta();
        comingsoon.displayName(Component.text("§b§lComing Soon"));
        ComingSoon.setItemMeta(comingsoon);

        setItem(22, Spawn, player -> {
            // This will be executed when the player clicks this item
            player.performCommand("spawn");
            player.closeInventory();
        });

        setItem(11, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });

        setItem(15, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });

        setItem(19, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });

        setItem(25, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });

        setItem(29, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });
        setItem(33, ComingSoon, player -> {
            // This will be executed when the player clicks this item
            player.sendMessage(prefix + "§c§lComing Soon");
            player.closeInventory();
        });


    }
}
