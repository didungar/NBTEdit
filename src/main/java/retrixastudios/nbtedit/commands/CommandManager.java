package retrixastudios.nbtedit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import retrixastudios.nbtedit.commands.sub.NBTCheck;
import retrixastudios.nbtedit.commands.sub.NBTSet;
import retrixastudios.nbtedit.commands.sub.NBTView;
import retrixastudios.nbtedit.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor, TabCompleter {

    private ArrayList<SubCommand> commands;

    public CommandManager() {
        this.commands = new ArrayList<>();
        commands.add(new NBTView());
        commands.add(new NBTSet());
        commands.add(new NBTCheck());
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

        if(args.length == 2) {
            for(Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                if(plugin.getName().toLowerCase().startsWith(args[1].toLowerCase())) tabComplete.add(plugin.getName());
            }
        }

        if(args.length == 3) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(p.getName().toLowerCase().startsWith(args[2].toLowerCase())) tabComplete.add(p.getName());
            }
        }

        return tabComplete;
    }
}
