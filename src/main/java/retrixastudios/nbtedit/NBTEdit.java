package retrixastudios.nbtedit;

import org.bukkit.plugin.java.JavaPlugin;
import retrixastudios.nbtedit.commands.ItemCommandManager;

public final class NBTEdit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("nbtedit").setExecutor(new ItemCommandManager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
