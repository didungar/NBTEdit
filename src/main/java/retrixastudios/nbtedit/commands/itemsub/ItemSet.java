package retrixastudios.nbtedit.commands.itemsub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;
import retrixastudios.nbtedit.util.DataFinder;

public class ItemSet extends SubCommand {
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getDescription() {
        return "Set the NBT tag of an Item";
    }

    @Override
    public String getSyntax() {
        return "/nbtitem set (tag) (value)";
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
            String valText = args[2];

            Object type = DataFinder.getType(valText);
            player.getInventory().setItemInMainHand(NBTEditor.set(item, type, tag));
            ChatUtils.tell(player, "Set '&a" + tag + "&f' to '&a" + type + "&f'.");

        } catch (IndexOutOfBoundsException indexException) {
            ChatUtils.tell(player, "Please use correct Syntax.");
            ChatUtils.tell(player, getSyntax());
        } catch (Exception e) {
            ChatUtils.tell(player, "An error occurred");
        }

    }
}
