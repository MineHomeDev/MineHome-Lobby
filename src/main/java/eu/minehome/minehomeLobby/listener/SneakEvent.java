package eu.minehome.minehomeLobby.listener;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import static eu.minehome.minehomeLobby.data.Data.actionbarmsg;

public class SneakEvent implements Listener {
    @EventHandler
    public void ONSneakEvent(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (e.isSneaking()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("Du bist abgeblutten"));
        }
    }

}
