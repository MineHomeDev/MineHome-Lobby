package eu.minehome.minehomeLobby.data;

import org.bukkit.ChatColor;

public class Data {

    //Permissions
    public final static String buildperms = "minehome.build";
    public final static String flyperms = "minehome.fly";

    public final static String lobbyworld = "world";
    public final static String prefix = "§7§l[§b§lLobby§7§l] ";
    public final static String actionbarmsg = "§c§lDas Netzwerk ist in der Beta!";
    //Info Nachrichen
    public final static String noplayer = "§7§lDu bist kein Spieler!";
    public final static String noperms = "§7§lDazu hast du keine §c§lRechet§7§l!";

    //Build Nachrichen
    public final static String buildon = "§7§lDu bist im §a§lBaumodus§7§l!";
    public final static String buildoff = "§7§lDu bist nicht mehr im §c§lBaumodus§7§l!";
    public final static String builuse = "§7§lBitte benutze §c§l/build";

    //Fly Nachrichten
    public final static String flyon = "§7§lDu bist im §a§lBaumodus§7§l!";
    public final static String flyoff = "§7§lDu bist nicht mehr im §c§lBaumodus§7§l!";
    public final static String flyuse = "§7§lBitte benutze §c§l/fly";

    // Join und Quit Nachrichten können deaktiviert werden mit null
    public final static String joinmsg = "§7§l[§a§l+§7§l]§r ";
    public final static String quitmsg = "§7§l[§c§l-§7§l]§r ";

    // das ist eine einface dbug nachricht
    public final static String dbugmsg = prefix + "Du bist in der Lobby";


}
