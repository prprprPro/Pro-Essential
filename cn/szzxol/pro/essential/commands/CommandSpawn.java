package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.Essential.SpawnLocation;
import static cn.szzxol.pro.essential.messages.MsgTip.MsgSpawn;
import org.bukkit.Bukkit;
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
        String pw = SpawnLocation.getString("Position.world") == null ? "world" : SpawnLocation.getString("Position.world");
        World world = Bukkit.getWorld(pw) == null ? Bukkit.getWorld("world") : Bukkit.getWorld(pw);
        Location LocationTo = new Location(world, SpawnLocation.getDouble("Position.x"), SpawnLocation.getDouble("Position.y"), SpawnLocation.getDouble("Position.z"), (float) SpawnLocation.getDouble("Position.yaw"), (float) SpawnLocation.getDouble("Position.pitch"));
        player.teleport(LocationTo);
    }
}
