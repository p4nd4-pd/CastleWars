package CastleWarsPackage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin implements Plugin{
	

	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Handler(),this);// eto register drugogo clasa
		getLogger().warning("Plugin enable");
	}
	public void onDisable() {
		getLogger().info("Plugin disable");
	}
	
}