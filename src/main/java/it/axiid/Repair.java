package it.axiid;

import it.axiid.commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Repair extends JavaPlugin {

    private static Repair instance;

    public static Repair getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        getCommand("repair").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
