package eu.minehome.minehomelobby.manager;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;

import static eu.minehome.minehomelobby.data.Data.lobbyworld;


public class WorldUpdate {

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
