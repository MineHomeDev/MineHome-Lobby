package eu.minehome.minehomelobby.utils;

import eu.minehome.minehomelobby.MinehomeLobby;
import eu.minehome.minehomelobby.menu.SimpleMenu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NavigatorInventory extends SimpleMenu {

    FileConfiguration messagesfile = MinehomeLobby.getInstance().getMessagesFile().getMessagesconfig();
    String prefix = messagesfile.getString("prefix");

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
        final ItemMeta comingsoon = ComingSoon.getItemMeta();
        comingsoon.displayName(Component.text("§b§lComming Soon"));
        ComingSoon.setItemMeta(comingsoon);

        final ItemStack Sky = new ItemStack(Material.GRASS_BLOCK);
        final ItemMeta sky= Sky.getItemMeta();
        sky.displayName(Component.text("§b§lSkyBlock"));
        Sky.setItemMeta(sky);

        setItem(22, Spawn, player -> {
            // This will be executed when the player clicks this item
            // player.sendMessage(prefix + "§c§lSpawn");
            player.performCommand("spawn");
            player.closeInventory();
        });

        setItem(11, Sky, player -> {
            // This will be executed when the player clicks this item
            // player.sendMessage(prefix + "§c§lSkyBlock");
            player.closeInventory();
            player.performCommand("warp sky");
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
