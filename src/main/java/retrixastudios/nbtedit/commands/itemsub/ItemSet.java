package retrixastudios.nbtedit.commands.itemsub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

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
        return "/nbtitem set (tag) ([s:i:b:]value)";
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
            String dataType = valText.split(":")[0];

            switch (dataType) {

                case "s": {
                    String value = valText.split(":")[1];
                    player.getInventory().setItemInMainHand(NBTEditor.set(item, value, tag));
                    ChatUtils.tell(player, "Set Item Tag &a" + tag + "&f to: &a" + value);
                    return;
                }

                case "b": {
                    boolean value = Boolean.parseBoolean(valText.split(":")[1]);
                    ChatUtils.tell(player, "BOOL: " + value + " -- " + valText.split(":")[1]);
                    player.getInventory().setItemInMainHand(NBTEditor.set(item, value, tag));
                    ChatUtils.tell(player, "Set Item Tag &a" + tag + "&f to: &a" + value);
                    return;
                }

                case "i": {
                    int value = Integer.parseInt(valText.split(":")[1]);
                    ChatUtils.tell(player, "INT: " + value + " -- " + valText.split(":")[1]);
                    player.getInventory().setItemInMainHand(NBTEditor.set(item, value, tag));
                    ChatUtils.tell(player, "Set Item Tag &a" + tag + "&f to: &a" + value);
                    return;
                }

                default: {
                    ChatUtils.tell(player, "No data type provided, please use correct Syntax.");
                    ChatUtils.tell(player, getSyntax());
                    break;
                }

            }

        } catch (IndexOutOfBoundsException indexException) {
            ChatUtils.tell(player, "Please use correct Syntax.");
            ChatUtils.tell(player, getSyntax());
        } catch (Exception e) {
            ChatUtils.tell(player, "An error occurred");
        }

    }
}
