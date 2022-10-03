package mcstarforce01.starforce;

import org.bukkit.plugin.java.JavaPlugin;

public final class Starforce extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starforce has been enabled!");
        getServer().getPluginManager().registerEvents(new OpenGUI(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Starforce has been disabled!");
    }
}
