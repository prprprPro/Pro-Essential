package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.messages.MsgTip.MsgRain;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandRain {

    public static boolean CommandRain(Player player, Command cmd, String label, String[] args) {
        World world = player.getWorld();
        world.setStorm(true);
        if (args.length == 1) {
            try {
                int number = Integer.valueOf(args[0]);
            } catch (Exception e) {
                return true;
            }
            if (Integer.valueOf(args[0]) < 0) {
                return true;
            }
            world.setWeatherDuration(Integer.valueOf(args[0]));
        }
        MsgRain(player);
        return true;
    }
}
