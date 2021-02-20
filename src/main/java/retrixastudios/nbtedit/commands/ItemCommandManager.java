package retrixastudios.nbtedit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import retrixastudios.nbtedit.commands.itemsub.ItemCheck;
import retrixastudios.nbtedit.commands.itemsub.ItemSet;
import retrixastudios.nbtedit.commands.itemsub.ItemView;
import retrixastudios.nbtedit.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemCommandManager implements CommandExecutor, TabCompleter {

    private ArrayList<SubCommand> commands;

    public ItemCommandManager() {
        this.commands = new ArrayList<>();
        commands.add(new ItemView());
        commands.add(new ItemSet());
        commands.add(new ItemCheck());
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;
            if(args.length > 0) {
                for(SubCommand cmd : commands) {
                    if(args[0].toLowerCase().equalsIgnoreCase(cmd.getName())) {
                        if(player.hasPermission(cmd.getPermission())) {
                            cmd.execute(player, args);
                        } else {
                            ChatUtils.tell(player, "You don't have permission.");
                        }
                        return true;
                    }
                }
            }
            ChatUtils.tell(player, "Invalid Syntax.");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> tabComplete = new ArrayList<>();


        if(args.length == 1) {
            for(SubCommand cmds : commands) {
                if(cmds.getName().startsWith(args[0].toLowerCase())) tabComplete.add(cmds.getName());
            }
        }

        return tabComplete;
    }
}
