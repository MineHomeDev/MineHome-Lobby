package eu.minehome.minehomeLobby;

import eu.minehome.minehomeLobby.commands.*;
import eu.minehome.minehomeLobby.configmanager.WarpsFile;
import eu.minehome.minehomeLobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class MinehomeLobby extends JavaPlugin {

    public static MinehomeLobby instance;
    private WarpsFile locationFile;
    public static MinehomeLobby getInstance(){return instance;}
    public WarpsFile getWarpsFile() {return locationFile;}


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info("Minehome-Lobby wurde aktiviert");
        createConfig();
        registerEvent();
        registerCommands();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Minehome-Lobby wurde deaktiviert");
    }

    private void registerEvent(){
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemHeldEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SneakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyClickEvent(), this);
    }
    private void registerCommands() {
        getCommand("build").setExecutor(new BuildCmd());
        getCommand("fly").setExecutor(new FlyCmd());
        getCommand("setwarp").setExecutor(new SetWarpCmd());
        getCommand( "warp").setExecutor(new WarpCmd());
        getCommand("spawn").setExecutor(new SpawnCmd());
        getCommand("setspawn").setExecutor(new SetSpawnCmd());
        getCommand("warplist").setExecutor(new WarpListCmd());
        getCommand("delwarp").setExecutor(new DelWarpCmd());
        getCommand("delspawn").setExecutor(new DelSpawnCmd());
    }
    private void createConfig(){
        locationFile = new WarpsFile();
        locationFile.createFile();
    }
    public WarpsFile getLocationFile() {return locationFile;}
}
