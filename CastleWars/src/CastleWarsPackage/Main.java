package CastleWarsPackage;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin implements Plugin{
	

	
	public void onEnable() {
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if(!config.exists()) {
			getLogger().info("Creating new config ...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		Bukkit.getPluginManager().registerEvents(new Handler(this),this);// eto register drugogo clasa
		getLogger().warning("Plugin enable");
		
	}
	public void onDisable() {
		getLogger().info("Plugin disable");
	}
	
}