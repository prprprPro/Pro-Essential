package cn.szzxol.pro.essential.utils;

import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class Teleport {
    
    public static void PlayerTeleport(Player player, Player target) {
        player.teleport(target);
    }
    
}
