package eu.minehome.minehomelobby;

import eu.minehome.minehomelobby.commands.*;
import eu.minehome.minehomelobby.manager.*;
import eu.minehome.minehomelobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class MinehomeLobby extends JavaPlugin {

    public static MinehomeLobby instance;
    private WarpsFile locationFile;
    private ConfigFile configfile;
    private LangConfig messagesfile;
    public static MinehomeLobby getInstance(){return instance;}
    public WarpsFile getWarpsFile() {return locationFile;}
    public ConfigFile getConfigFile(){return configfile;}
    public LangConfig getMessagesFile(){return messagesfile;}


    @Override
    public void onEnable() {
        init();
        createConfig();
        registerEvent();
        registerCommands();
        new WorldUpdate().DayNightCycle();
    }

    @Override
    public void onDisable() {
        getLocationFile().save();
        Bukkit.getLogger().info("Minehome-Lobby wurde deaktiviert");
    }

    public void init(){
        instance = this;
        new RunTask().LevelPlayerCounter();
    }

    private void registerEvent(){
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ItemHeldEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SneakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerProtectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getLogger().info("Minehome-Lobby Event registriert");
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
        Bukkit.getLogger().info("Minehome-Lobby Command registriert");
    }
    private void createConfig(){
        locationFile = new WarpsFile();
        locationFile.createFile();
        configfile = new ConfigFile();
        configfile.createFile();
        messagesfile= new LangConfig();
        messagesfile.createFile();
    }
    public WarpsFile getLocationFile() {return locationFile;}
}
