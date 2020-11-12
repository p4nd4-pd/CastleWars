package CastleWarsPackage;

import java.util.ArrayList;

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
	
	/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!----PlayerToBatle---!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	private int PlayerToBatle = 2;
	
	/*---------------Getters of PlayerToBatle--------------------*/
	public int getPlayerToBatle() {
		return PlayerToBatle;
	}
	
	/*------------------CREATE LIST OF PLAYERS----------------------*/
	private ArrayList<Player> BlueTeam = new ArrayList<Player>();
	private ArrayList<Player> RedTeam = new ArrayList<Player>();
	
	/*---------------Getters of BlueTeam and RedTeam --------------------*/
	public ArrayList<Player> getBlueTeam() {
		return BlueTeam;
	}
	
	public ArrayList<Player> getRedTeam() {
		return RedTeam;
	}
	
	
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
	
	
	/* getter of ArmorStand */
	public ArmorStand getArmorStandblueBlock() {
		return ArmorStandblueBlock;
	}
	
	public ArmorStand getArmorStandredBlock() {
		return ArmorStandredBlock;
	}


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
		ArmorStandblueBlock.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Team" + " [ " + BlueTeam.size() + " / " + (PlayerToBatle / 2) + " ] ");
		ArmorStandblueBlock.setCustomNameVisible(true);
		ArmorStandblueBlock.setCanPickupItems(false);
		
		/* inizialig of ArmorStandredBlock*/
		ArmorStandredBlock.setArms(false);
		ArmorStandredBlock.setGravity(true);
		ArmorStandredBlock.setSmall(false);
		ArmorStandredBlock.setVisible(false);
		ArmorStandredBlock.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Red Team" + " [ " + RedTeam.size() + " / " + (PlayerToBatle / 2) + " ] ");
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
			p.sendMessage(ChatColor.GREEN + "Welcom to " + ChatColor.AQUA + "" + ChatColor.BOLD + "CastleWars Mini Game ");
			p.sendMessage(ChatColor.YELLOW + "Teleporting to lobby...");
			p.teleport(SpawnMiniGame);
			
			return true;
			
		}
		/*--------------------------------------------END OF COMMAND MENEGER--------------------------------------------------*/
	
}