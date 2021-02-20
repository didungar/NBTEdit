package retrixastudios.nbtedit.commands.itemsub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

public class ItemCheck extends SubCommand {
    @Override
    public String getName() {
        return "check";
    }

    @Override
    public String getDescription() {
        return "Check an Item's NBT Tags.";
    }

    @Override
    public String getSyntax() {
        return "/nbtitem check (tag)";
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

        String name = item.getType().name();

        if(item.getItemMeta().hasDisplayName()) name = item.getItemMeta().getDisplayName();

        try {
            String tag = args[1];
            boolean hasTag = NBTEditor.contains(item, tag);

            String response = hasTag ? "has" : "does not have";
            ChatUtils.tell(player, name + "&f " + response + " the tag: &a" + tag);
        } catch (IndexOutOfBoundsException indexException) {
            ChatUtils.tell(player, "Please use correct Syntax.");
            ChatUtils.tell(player, getSyntax());
        } catch (Exception e) {
            ChatUtils.tell(player, "An error occurred.");
        }
    }
}
