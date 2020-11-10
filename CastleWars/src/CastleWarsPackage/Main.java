package CastleWarsPackage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin{
	

	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Handler(),this);// eto register drugogo clasa
		getLogger().warning("Plugin enable");
	}
	public void onDisable() {
		getLogger().info("Plugin disable");
	}
	
}