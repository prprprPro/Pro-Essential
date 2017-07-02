package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.Essential.SpawnLocation;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgSpawn;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandSpawn {

    public static boolean CommandSpawn(Player player, Command cmd, String label, String[] args) {
        PlayerSpawn(player);
        return true;
    }

    public static void PlayerSpawn(Player player) {
        MsgSpawn(player);
        World world = player.getWorld();
        Location LocationTo = new Location(world, SpawnLocation.getDouble("Position.x"), SpawnLocation.getDouble("Position.y"), SpawnLocation.getDouble("Position.z"), (float) SpawnLocation.getDouble("Position.yaw"), (float) SpawnLocation.getDouble("Position.pitch"));
        player.teleport(LocationTo);
    }
}
