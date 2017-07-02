package cn.szzxol.pro.essential.permission;

import static cn.szzxol.pro.essential.Essential.Perm;
import static cn.szzxol.pro.essential.messages.MsgError.MsgNoPermission;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class Permission {

    public static boolean checkPermised(Player player, String cmd) {
        String perm = Perm.getString("Commands." + cmd);
        switch (perm) {
            case "EveryOne":
                return true;
            case "OP":
                return player.isOp();
            default:
                return false;
        }
    }

    public static boolean isPermised(Player player, String cmd) {
        if (!checkPermised(player, cmd)) {
            MsgNoPermission(player);
            return false;
        } else {
            return true;
        }
    }

}
