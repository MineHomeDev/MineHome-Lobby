package eu.minehome.minehomeLobby;

import eu.minehome.minehomeLobby.listener.ItemHeldEvent;
import eu.minehome.minehomeLobby.listener.JoinEvent;
import eu.minehome.minehomeLobby.listener.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinehomeLobby extends JavaPlugin {

    public static MinehomeLobby instance;
    public static MinehomeLobby getInstance(){return instance;}


    @Override
    public void onEnable() {
        instance = this;
        registerEvent();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvent(){
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemHeldEvent(), this);
    }
}
