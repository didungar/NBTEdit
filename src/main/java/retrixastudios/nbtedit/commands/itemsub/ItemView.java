package retrixastudios.nbtedit.commands.itemsub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import retrixastudios.nbtedit.NBTEdit;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;
import retrixastudios.nbtedit.util.DataFinder;

import java.nio.charset.StandardCharsets;

public class ItemView extends SubCommand {
    @Override
    public String getName() {
        return "view";
    }

    @Override
    public String getDescription() {
        return "View the value of specified NBT tag.";
    }

    @Override
    public String getSyntax() {
        return "/nbtitem view ([s:i:b:]tag)";
    }

    @Override
    public String getPermission() {
        return "nbtedit.admin";
    }

    @Override
    public void execute(Player player, String... args) {

        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() == Material.AIR) {
            ChatUtils.tell(player, "You must have an item in your hand.");
            return;
        }

        try {
            String tag = args[1];
            Object value;

            if(NBTEditor.contains(item, tag)) {

                String sVal = NBTEditor.getString(item, tag);
                int iVal = NBTEditor.getInt(item, tag);
                boolean bVal = NBTEditor.getBoolean(item, tag);

                if(sVal != null) {
                    value = sVal;
                } else if(iVal == 0) {
                    value = bVal;
                } else {
                    value = iVal;
                }

                ChatUtils.tell(player, "The value of '&a" + tag + "&f' is '&a" + value + "&f'.");
            } else {
                ChatUtils.tell(player, "The item doesn't contain tag: &c" + tag);
            }

        } catch (IndexOutOfBoundsException indexException) {
            ChatUtils.tell(player, "Please use correct Syntax.");
            ChatUtils.tell(player, getSyntax());
        } catch (Exception e) {
            ChatUtils.tell(player, "An error occurred.");
        }
    }
}
