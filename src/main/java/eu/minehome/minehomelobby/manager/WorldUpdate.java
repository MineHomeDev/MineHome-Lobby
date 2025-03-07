package eu.minehome.minehomelobby.manager;

import eu.minehome.minehomelobby.MinehomeLobby;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class WorldUpdate {
    FileConfiguration configfile = MinehomeLobby.getInstance().getConfigFile().getConfigfile();
    String lobbyworld = configfile.getString("Lobby-World");
    public void DayNightCycle(){

        for (World world : Bukkit.getWorlds()) {
            if (world.getName().equals(lobbyworld)){

                    world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                    world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
                    world.setTime(6000);


            }

        }

    }

}
