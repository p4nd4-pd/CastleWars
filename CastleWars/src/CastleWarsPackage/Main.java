package CastleWarsPackage;

import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin{
	
	public void onEnable() {
		//Bukkit.getPluginManager().registerEvents(new start(this),this); eto register drugogo clasa
		getLogger().warning("Plugin enable");
	}
	public void onDisable() {
		getLogger().info("Plugin disable");
	}
	
}