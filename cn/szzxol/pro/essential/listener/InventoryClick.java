package cn.szzxol.pro.essential.listener;

import static cn.szzxol.pro.essential.commands.CommandHome.PlayerHome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 *
 * @author I_promise
 */
public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        if (!"回家".equals(event.getInventory().getName())) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        player.updateInventory();
        if (event.getRawSlot() < 0) {
            player.closeInventory();
            return;
        }
        String str = event.getCurrentItem().getItemMeta().getDisplayName();
        PlayerHome(player, Integer.valueOf(str.substring(str.lastIndexOf("家") + 1)));
    }
}
