package retrixastudios.nbtedit.commands.sub;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import retrixastudios.nbtedit.NBTEdit;
import retrixastudios.nbtedit.commands.SubCommand;
import retrixastudios.nbtedit.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class NBTSet extends SubCommand {

    @Override
    public void execute(Player player, String... args) {
        if(args.length == 4) {
            try {
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                String tag = args[2];
                int value = Integer.parseInt(args[3]);

                target.getPlayer().getPersistentDataContainer().set(new NamespacedKey(NBTEdit.getInstance(), tag), PersistentDataType.INTEGER, value);

                ChatUtils.tell(player, "Set TAG:"+tag + " to: " + value);
            } catch (Exception e) {
                ChatUtils.tell(player, getSyntax());
            }
        } else {
            ChatUtils.tell(player, getSyntax());
        }
    }


    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getDescription() {
        return "Set NBT Tag Data.";
    }

    @Override
    public String getSyntax() {
        return "/nbtedit set (player) (tag) (value)";
    }

    @Override
    public String getPermission() {
        return "nbtedit.admin";
    }
}

