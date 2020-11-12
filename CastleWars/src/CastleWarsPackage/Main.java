package CastleWarsPackage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends JavaPlugin implements Plugin{
	
	/*------Coordination of Gologram-----------*/
	/* BLUE */
	private double blueX = 246.00;
	private double blueY = 22.00;
	private double blueZ = -5;
	
	/* RED	*/
	private double redX = 240.00;
	private double redY = 22.00;
	private double redZ = -5;
	
	/*		 GET WORLD FOR SPAWN		*/
	World world = Bukkit.getServer().getWorld("world");
	
	/*---------------Getters of Coordination--------------------*/
	public double getBlueX() {
		return blueX;
	}

	public double getBlueY() {
		return blueY;
	}

	public double getBlueZ() {
		return blueZ;
	}

	public double getRedX() {
		return redX;
	}

	public double getRedY() {
		return redY;
	}

	public double getRedZ() {
		return redZ;
	}
	
	/*------ CREATE LOCATION----------*/
	Location blueBlock = new Location(world, (blueX + 0.50), blueY, (blueZ + 0.50));
	Location redBlock = new Location(world, (redX + 0.50), redY, (redZ + 0.50));
	
	/* Creating of castom entity */
	ArmorStand  ArmorStandblueBlock = (ArmorStand)  world.spawnEntity(blueBlock, EntityType.ARMOR_STAND);
	ArmorStand  ArmorStandredBlock = (ArmorStand)  world.spawnEntity(redBlock, EntityType.ARMOR_STAND);


	/*------------ONENABLE------------*/
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Handler(this),this);// eto register drugogo clasa
		getCommand("CastleWars").setExecutor(this);
		getLogger().warning("Plugin enable");
		
		/*-----------------------------------------CREATING AND SPAWN GOLOGRAM------------------------------------*/
		
		/* inizialig of ArmorStandblueBlock*/
		ArmorStandblueBlock.setArms(false);
		ArmorStandblueBlock.setGravity(true);
		ArmorStandblueBlock.setSmall(false);
		ArmorStandblueBlock.setVisible(false);
		ArmorStandblueBlock.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Team");
		ArmorStandblueBlock.setCustomNameVisible(true);
		ArmorStandblueBlock.setCanPickupItems(false);
		
		/* inizialig of ArmorStandredBlock*/
		ArmorStandredBlock.setArms(false);
		ArmorStandredBlock.setGravity(true);
		ArmorStandredBlock.setSmall(false);
		ArmorStandredBlock.setVisible(false);
		ArmorStandredBlock.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Red Team");
		ArmorStandredBlock.setCustomNameVisible(true);
		ArmorStandredBlock.setCanPickupItems(false);
		
		/*-----------------------------------------END------------------------------------*/
		
	}
		
	/*------------ONDISABLE------------*/
	public void onDisable() {
		ArmorStandblueBlock.remove();
		ArmorStandredBlock.remove();
		getLogger().info("Plugin disable");
	}
	
	
	/*--------Variable---------*/
	
	/* Name of plugin */
	private String PluginName = "CastleWars";
	
	/* 	Id of task	&& time for task*/
	private int id;
	private int TimeForTask = 20;
	
	/*---------SecondToWaitForSpawn------------*/
	private int SecondToWaitForSpawn = 10;
	private int ReloaderOfTimeSpawn = 10;
	
	/*------Position of spawn Mini Game-------*/
	private double[] PositionOfSpawnMiniGame = {243.50, 30.00, -4.50};
	
	/*--------------------------------------------COMMAND MENEGER--------------------------------------------------*/
		public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
			
			/*-----Control if Sender was Player------*/
			if(!(sender instanceof Player)){
				sender.sendMessage("Only Players Command!!!");
				return true;
			}
			
			/*	Create player from sender	*/
			Player p = (Player) sender;
			
			/*		Creating of location		*/
			Location SpawnMiniGame = new Location(p.getWorld(),PositionOfSpawnMiniGame[0], PositionOfSpawnMiniGame[1], PositionOfSpawnMiniGame[2]);
			
			/*	Teleporting of player sender to spawn	*/
			Runnable s = new Runnable() {
				
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Wait " + ChatColor.RED + SecondToWaitForSpawn + ChatColor.GREEN + " seconds to teleport in " + ChatColor.AQUA + "" + ChatColor.BOLD + "CastleWars Mini Game " + ChatColor.GREEN + " spawn");
					SecondToWaitForSpawn--;
					if(SecondToWaitForSpawn == 0){
						p.sendMessage(ChatColor.YELLOW + "Teleporting to lobby...");
						Bukkit.getScheduler().cancelTask(id);
						p.teleport(SpawnMiniGame);
						SecondToWaitForSpawn = ReloaderOfTimeSpawn;
					}	
				}
			};
			id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin(PluginName), s, 0, TimeForTask);
			
			return true;
			
		}
		/*--------------------------------------------END OF COMMAND MENEGER--------------------------------------------------*/
	
}