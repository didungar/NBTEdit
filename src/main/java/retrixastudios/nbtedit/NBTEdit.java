package retrixastudios.nbtedit;

import org.bukkit.plugin.java.JavaPlugin;
import retrixastudios.nbtedit.commands.ItemCommandManager;
import retrixastudios.nbtedit.commands.PlayerCommandManager;

public final class NBTEdit extends JavaPlugin {

    private static NBTEdit instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getCommand("nbtplayer").setExecutor(new PlayerCommandManager());
        getCommand("nbtitem").setExecutor(new ItemCommandManager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static NBTEdit getInstance() {
        return instance;
    }
}
