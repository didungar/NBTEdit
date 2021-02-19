package retrixastudios.nbtedit.commands;

import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public abstract class SubCommand {

    public abstract String getName();
    public abstract String getDescription();
    public abstract String getSyntax();
    public abstract String getPermission();
    public abstract void execute(Player player, String... args);

}
