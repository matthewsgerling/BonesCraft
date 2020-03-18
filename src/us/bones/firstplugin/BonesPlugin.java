package us.bones.firstplugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BonesPlugin extends JavaPlugin {
    private final PlayerListener playerListener = new PlayerListener(this);
    private final BlockListener blockListener = new BlockListener();

    BonesPlugin() {

    }

    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.blockListener, this);
        this.getCommand("pos").setExecutor(new PosCommand());
        this.getCommand("boboss").setExecutor(new BobossCommand());
        PluginDescriptionFile pdfFile = this.getDescription();
        this.getLogger().info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
    }

    public void onDisable() {
        this.getLogger().info("Goodbye world!");
    }
}
