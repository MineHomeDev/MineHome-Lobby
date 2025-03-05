package eu.minehome.minehomeLobby.utils;

import eu.minehome.minehomeLobby.menu.SimpleMenu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NavigatorInventory extends SimpleMenu {
    public NavigatorInventory() {
        super(Rows.FOUR, Component.text("§b§lNavigator"));

    }
    @Override
    public void onSetItems() {
        // This method can be used to add items to the GUI
        final ItemStack Spawn = new ItemStack(Material.MAGMA_CREAM);
        final ItemMeta spawn = Spawn.getItemMeta();
        spawn.displayName(Component.text("Spawn"));
        Spawn.setItemMeta(spawn);

        final ItemStack JumpandRum = new ItemStack(Material.BARRIER);
        final ItemMeta jumpandrun= JumpandRum.getItemMeta();
        jumpandrun.displayName(Component.text("JumpandRum"));
        JumpandRum.setItemMeta(jumpandrun);

        setItem(31, Spawn, player -> {
            // This will be executed when the player clicks this item
            player.performCommand("spawn");
            player.closeInventory();
        });

        setItem(22, JumpandRum, player -> {
            player.performCommand("warp jumpandrun");
            player.closeInventory();
        });
    }
}
