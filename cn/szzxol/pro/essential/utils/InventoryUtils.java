package cn.szzxol.pro.essential.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author I_promise
 */
public class InventoryUtils {

    public static Inventory CreateInventory(String title, ItemStack[] is) {
        Inventory inv = Bukkit.createInventory(null, size(is.length), title);
        for (int i = 0; i < is.length; i++) {
            if (is[i] != null) {
                inv.setItem(i, is[i]);
            }
        }
        return inv;
    }

    final static int[] sizeTable = {9, 18, 27, 36, 45, 54, Integer.MAX_VALUE};

    static int size(int x) {
        for (int i = 0;; i++) {
            if (x <= sizeTable[i]) {
                return sizeTable[i];
            }
        }
    }
}
