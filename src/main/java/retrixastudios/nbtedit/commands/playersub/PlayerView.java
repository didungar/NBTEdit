package retrixastudios.nbtedit.commands.playersub;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

public class PlayerView extends SubCommand {

    @Override
    public void execute(Player player, String... args) {
        if(args.length == 4) {
            try {
                String pluginName = args[1];
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[2]);
                String tag = args[3];

                int value = target.getPlayer().getPersistentDataContainer().get(new NamespacedKey(Bukkit.getPluginManager().getPlugin(pluginName), tag), PersistentDataType.INTEGER);

                ChatUtils.tell(player, target.getName() + " : " + tag + " -> " + value);
            } catch (Exception e) {
                ChatUtils.tell(player, getSyntax());
            }
        }
    }

    @Override
    public String getName() {
        return "view";
    }

    @Override
    public String getDescription() {
        return "View NBT Tag Data.";
    }

    @Override
    public String getSyntax() {
        return "/nbtplayer view (plugin) (player) (tag)";
    }

    @Override
    public String getPermission() {
        return "nbtedit.admin";
    }
}
