package retrixastudios.nbtedit;

import org.bukkit.plugin.java.JavaPlugin;
import retrixastudios.nbtedit.commands.CommandManager;

public final class NBTEdit extends JavaPlugin {

    private static NBTEdit instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getCommand("nbtedit").setExecutor(new CommandManager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static NBTEdit getInstance() {
        return instance;
    }
}
