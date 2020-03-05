package us.bones.firstplugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

class BonesPlugin extends JavaPlugin {

    private final PlayerListener playerListener = new PlayerListener(this);
    private final BlockListener blockListener = new BlockListener();

    @Override
    public void onEnable(){

        //Fired when the server enables the plugin
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);

        getCommand("pos").setExecutor(new PosCommand());

        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }


    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins

        getLogger().info("Goodbye world!");

    }
}
