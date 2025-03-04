package eu.minehome.minehomeLobby;

import eu.minehome.minehomeLobby.commands.BuildCmd;
import eu.minehome.minehomeLobby.commands.FlyCmd;
import eu.minehome.minehomeLobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class MinehomeLobby extends JavaPlugin {

    public static MinehomeLobby instance;
    public static MinehomeLobby getInstance(){return instance;}

    @Override
    public void onEnable() {
        instance = this;
        registerEvent();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvent(){
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemHeldEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SneakEvent(), this);

    }
    private void registerCommands() {
        getCommand("build").setExecutor(new BuildCmd());
        getCommand("fly").setExecutor(new FlyCmd());
    }
}
