package cn.szzxol.pro.essential.permission;

import static cn.szzxol.pro.essential.Essential.Perm;
import static cn.szzxol.pro.essential.commands.CommandExecute.EO;
import static cn.szzxol.pro.essential.commands.CommandExecute.OP;
import static cn.szzxol.pro.essential.messages.MsgError.MsgNoPermission;
import java.util.List;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class Permission {

    public static boolean checkPermised(Player player, String cmd) {
        List listOP = Perm.getList("Commands.Permission.OP") == null ? OP : Perm.getList("Commands.Permission.OP");
        List listEO = Perm.getList("Commands.Permission.EveryOne") == null ? EO : Perm.getList("Commands.Permission.EveryOne");
        if (listOP.contains(cmd)) {
            return player.isOp();
        } else if (listEO.contains(cmd)) {
            return true;
        } else {
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
