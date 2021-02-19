package retrixastudios.nbtedit.commands.sub;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import retrixastudios.nbtedit.NBTEdit;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class NBTView extends SubCommand {

    @Override
    public void execute(Player player, String... args) {
        if(args.length == 3) {
            try {
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                String tag = args[2];

                int value = target.getPlayer().getPersistentDataContainer().get(new NamespacedKey(NBTEdit.getInstance(), tag), PersistentDataType.INTEGER);

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
        return "/nbtedit view (player) (tag)";
    }

    @Override
    public String getPermission() {
        return "nbtedit.admin";
    }
}
