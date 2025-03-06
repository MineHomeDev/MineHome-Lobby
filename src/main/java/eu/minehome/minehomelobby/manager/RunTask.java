package eu.minehome.minehomelobby.manager;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.Bukkit;

public class RunTask {
    public  void LevelPlayerCounter(){
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(MinehomeLobby.getInstance(),() -> Bukkit.getOnlinePlayers().forEach(players -> {
            players.setLevel(Bukkit.getOnlinePlayers().size());
            players.setExp((float)Bukkit.getOnlinePlayers().size() / (float)Bukkit.getMaxPlayers());
        }), 20, 20);
    }
}
