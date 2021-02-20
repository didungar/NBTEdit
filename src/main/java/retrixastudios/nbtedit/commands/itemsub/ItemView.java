package retrixastudios.nbtedit.commands.itemsub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

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
            String tag = args[1].split(":")[1];
            String type = args[1].split(":")[0];

            if(NBTEditor.contains(item, tag)) {

                switch (type) {
                    case "s": {
                        ChatUtils.tell(player, "The String value of '" + tag + "' is &a" + NBTEditor.getString(item, tag));
                        return;
                    }

                    case "i": {
                        ChatUtils.tell(player, "The Integer value of '" + tag + "' is &a" + NBTEditor.getInt(item, tag));
                        return;
                    }

                    case "b": {
                        ChatUtils.tell(player, "The Boolean value of '" + tag + "' is &a" + NBTEditor.getBoolean(item, tag));
                        return;
                    }

                    default: {
                        ChatUtils.tell(player, "Please use correct Syntax.");
                        ChatUtils.tell(player, getSyntax());
                    }
                }
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
