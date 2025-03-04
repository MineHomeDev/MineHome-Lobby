package eu.minehome.minehomeLobby.data;

import org.bukkit.ChatColor;

public class Data {

    //Permissions
    public final static String buildperms = "minehome.build";
    public final static String flyperms = "minehome.fly";
    public final static String setwarpperms = "minehome.setwarp";
    public final static String delwarpperms = "minehome.delwarp";
    public final static String warplistperms = "minehome.warplist";
    public final static String setspawnperms = "minehome.setspawn";
    public final static String delspawnperms = "minehome.delspawn";
    //Netzwerk Nachrichten
    public final static String lobbyworld = "world";
    public final static String prefix = "§7§l[§b§lLobby§7§l] ";
    public final static String actionbarmsg = "§c§lDas Netzwerk ist in der Beta!";
    //Info Nachrichten
    public final static String noplayer = "§7Du bist kein Spieler!";
    public final static String noperms = "§7Dazu hast du keine §c§lRechet§7!";

    //Build Nachrichten
    public final static String buildon = "§7Du bist im §a§lBaumodus§7!";
    public final static String buildoff = "§7Du bist nicht mehr im §c§lBaumodus§7!";
    public final static String builuse = "§7Bitte benutze §c§l/build";

    //Fly Nachrichten
    public final static String flyon = "§7Du bist im §a§lFlugmodus§7!";
    public final static String flyoff = "§7Du bist nicht mehr im §c§lFlugmodus§7!";
    public final static String flyuse = "§7Bitte benutze §c§l/fly";
    //Warps Nachrichten
    public final static String setwarpuse = "§7Bitte benutze §c§l/setwarp <Name>";
    public final static String warpuse= "§7Bitte benutze §c§l/warp <Name>";
    public final static String delwarpuse = "§7Bitte benutze §c§l/delwarp <Name>";
    public final static String warplistuse = "§7Bitte benutze §c§l/warplist";


    public final static String setspawnuse = "§7Bitte benutze §c§l/setspawn";
    public final static String delspawn = "§7Der §a§lSpawn §7wurde gelöscht!";
    public final static String setspawn = "§7Der §a§lSpawn §7wurde erfolgreich erstellt!";
    public final static String spaentp = "§7§Du bist am §a§lSpawn";
    public final static String nospawn = "§7Der §c§lSpawn §7nicht gefunden!";

    // Join und Quit Nachrichten können deaktiviert werden mit null
    public final static String joinmsg = "§7§l[§a§l+§7§l]§r ";
    public final static String quitmsg = "§7§l[§c§l-§7§l]§r ";

    // Die Dbug Nachrichten können mit null Deaktiviert werden
    public final static String dbugmsg = prefix + "Du bist in der Lobby";


}
