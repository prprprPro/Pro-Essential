package cn.szzxol.pro.essential.commands;

import static cn.szzxol.pro.essential.commands.CommandBack.CommandBack;
import static cn.szzxol.pro.essential.commands.CommandDay.CommandDay;
import static cn.szzxol.pro.essential.commands.CommandFly.CommandFly;
import static cn.szzxol.pro.essential.commands.CommandGamemode.CommandGamemode;
import static cn.szzxol.pro.essential.commands.CommandHeal.CommandHeal;
import static cn.szzxol.pro.essential.commands.CommandHome.CommandHome;
import static cn.szzxol.pro.essential.commands.CommandInvsee.CommandInvsee;
import static cn.szzxol.pro.essential.commands.CommandNight.CommandNight;
import static cn.szzxol.pro.essential.commands.CommandRain.CommandRain;
import static cn.szzxol.pro.essential.commands.CommandSethome.CommandSetHome;
import static cn.szzxol.pro.essential.commands.CommandSetspawn.CommandSetspawn;
import static cn.szzxol.pro.essential.commands.CommandSpawn.CommandSpawn;
import static cn.szzxol.pro.essential.commands.CommandSpeed.CommandSpeed;
import static cn.szzxol.pro.essential.commands.CommandSun.CommandSun;
import static cn.szzxol.pro.essential.commands.CommandTp.CommandTp;
import static cn.szzxol.pro.essential.commands.CommandTpa.CommandTpa;
import static cn.szzxol.pro.essential.commands.CommandTpaccept.CommandTpaccept;
import static cn.szzxol.pro.essential.commands.CommandTpdeny.CommandTpadeny;
import static cn.szzxol.pro.essential.commands.CommandTpahere.CommandTpahere;
import static cn.szzxol.pro.essential.commands.CommandTpall.CommandTpall;
import static cn.szzxol.pro.essential.commands.CommandTphere.CommandTphere;
import static cn.szzxol.pro.essential.permission.Permission.isPermised;
import static java.util.Arrays.asList;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author I_promise
 */
public class CommandExecute {

    public static List EO = new LinkedList<>(asList("back", "spawn", "tpa", "tpaccept", "tpdeny", "tpahere", "sethome", "home"));
    public static List OP = new LinkedList<>(asList("fly", "gm", "speed", "tp", "tphere", "setspawn", "heal", "sun", "rain", "ess", "tpall", "invsee", "day", "night"));

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
                case "setspawn":
                    return CommandSetspawn(player, cmd, label, args);
                case "spawn":
                    return CommandSpawn(player, cmd, label, args);
                case "speed":
                    return CommandSpeed(player, cmd, label, args);
                case "tp":
                    return CommandTp(player, cmd, label, args);
                case "tpa":
                    return CommandTpa(player, cmd, label, args);
                case "tpall":
                    return CommandTpall(player, cmd, label, args);
                case "tpaccept":
                    return CommandTpaccept(player, cmd, label, args);
                case "tpahere":
                    return CommandTpahere(player, cmd, label, args);
                case "tpdeny":
                    return CommandTpadeny(player, cmd, label, args);
                case "tphere":
                    return CommandTphere(player, cmd, label, args);
                case "heal":
                    return CommandHeal(player, cmd, label, args);
                case "sun":
                    return CommandSun(player, cmd, label, args);
                case "rain":
                    return CommandRain(player, cmd, label, args);
                case "invsee":
                    return CommandInvsee(player, cmd, label, args);
                case "day":
                    return CommandDay(player, cmd, label, args);
                case "night":
                    return CommandNight(player, cmd, label, args);
                default:
                    return true;
            }
        }
        return true;
    }
}
