package retrixastudios.nbtedit.commands.playersub;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

public class PlayerCheck extends SubCommand {
    @Override
    public String getName() {
        return "check";
    }

    @Override
    public String getDescription() {
        return "Check if the player has the NBT tag";
    }

    @Override
    public String getSyntax() {
        return "/nbtedit check (player) (tag)";
    }

    @Override
    public String getPermission() {
        return "nbtedit.admin";
    }

    @Override
    public void execute(Player player, String... args) {
        if(args.length == 4) {
            try {
                String pluginName = args[1];
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[2]);
                String tag = args[3];

                boolean value = target.getPlayer().getPersistentDataContainer().has(new NamespacedKey(Bukkit.getPluginManager().getPlugin(pluginName), tag), PersistentDataType.INTEGER);
                String response = value ? "has" : "does not have";

                ChatUtils.tell(player, target.getName() + " " + response + " the tag: &a" + tag);

            } catch (Exception e) {
                ChatUtils.tell(player, getSyntax());
            }
        }
    }
}
