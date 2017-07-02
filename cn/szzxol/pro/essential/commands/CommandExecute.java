package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.commands.CommandBack.CommandBack;
import static cn.szzxol.pro.essential.commands.CommandFly.CommandFly;
import static cn.szzxol.pro.essential.commands.CommandGamemode.CommandGamemode;
import static cn.szzxol.pro.essential.commands.CommandHome.CommandHome;
import static cn.szzxol.pro.essential.commands.CommandSethome.CommandSetHome;
import static cn.szzxol.pro.essential.commands.CommandSpawn.CommandSpawn;
import static cn.szzxol.pro.essential.commands.CommandSpeed.CommandSpeed;
import static cn.szzxol.pro.essential.commands.CommandTp.CommandTp;
import static cn.szzxol.pro.essential.commands.CommandTpa.CommandTpa;
import static cn.szzxol.pro.essential.commands.CommandTpaccept.CommandTpaccept;
import static cn.szzxol.pro.essential.commands.CommandTpdeny.CommandTpadeny;
import static cn.szzxol.pro.essential.commands.CommandTpahere.CommandTpahere;
import static cn.szzxol.pro.essential.commands.CommandTphere.CommandTphere;
import static cn.szzxol.pro.essential.permission.Permission.isPermised;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandExecute {

    public static boolean CommandExecute(CommandSender sender, Command cmd, String label, String[] args) {
        String command = cmd.getName().toLowerCase();
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!isPermised(player, command)) {
                return true;
            }
            switch (command) {
                case "back":
                    return CommandBack(player, cmd, label, args);
                case "fly":
                    return CommandFly(player, cmd, label, args);
                case "gm":
                    return CommandGamemode(player, cmd, label, args);
                case "home":
                    return CommandHome(player, cmd, label, args);
                case "sethome":
                    return CommandSetHome(player, cmd, label, args);
                case "spawn":
                    return CommandSpawn(player, cmd, label, args);
                case "speed":
                    return CommandSpeed(player, cmd, label, args);
                case "tp":
                    return CommandTp(player, cmd, label, args);
                case "tpa":
                    return CommandTpa(player, cmd, label, args);
                case "tpaccept":
                    return CommandTpaccept(player, cmd, label, args);
                case "tpahere":
                    return CommandTpahere(player, cmd, label, args);
                case "tpdeny":
                    return CommandTpadeny(player, cmd, label, args);
                case "tphere":
                    return CommandTphere(player, cmd, label, args);
                default:
                    return true;
            }
        }
        return true;
    }
}
