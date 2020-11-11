package CastleWarsPackage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class Handler implements Listener{

	private Main MainClassOfPlugin;
	
	/*----------CREAT CONSTRUCTOR--------------*/
	public Handler(Main MainClassOfPlugin){
		this.MainClassOfPlugin = MainClassOfPlugin; 
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event){
		Player player = event.getPlayer();
		ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
		player.getInventory().addItem(item);
	}
	
	/* Name of plugin */
	private String PluginName = MainClassOfPlugin.getConfig().getString("PluginName");
	
	/* 	Id of task	&& time for task*/
	private int id;
	private int TimeForTask = 20;
	
	/*---------SecondToWaitForSpawn------------*/
	private int SecondToWaitForSpawn = 10;
	private int ReloaderOfTimeSpawn = 10;
	
	/* Seconds for spawn of Red and Blue Team*/
	//private int secondsForSpawn = 80;
	
	/*-----------BLUE TEAM SPAWN LOCATION----------------*/
	private double[] BlueTeamCoordination = {254.00, 30.00, 17.00};
	
	/*-----------red TEAM SPAWN LOCATION----------------*/
	private double[] RedTeamCoordination = {232.00, 30.00, 17.00};
	
	/* Create at inventory */
	private Inventory InventoryTeamBlu;
	
	/* Create at inventory */
	private Inventory InventoryTeamRed;
	
	/*	 SIZE  OF INVENTORY		*/
	private int SizeOfInventory = 3 * 9; // 3-rige 9-colone
	
	/*_____Name of Inventorys_______*/
	private String NameOfINventory_BlueTeam = "Blue Team";
	private String NameOfINventory_RedTeam = "Red Team"; 
	
	/*	Create Item of Inventory */
	private ItemStack Bow = new ItemStack(Material.BOW);
	private ItemStack Golden_sword = new ItemStack(Material.GOLDEN_SWORD);
	private ItemStack Potion = new ItemStack(Material.POTION);
	
	/* RED and BLUE tained_glass_pane */
	private ItemStack blue_stained_glass_pane = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
	private ItemStack red_stained_glass_pane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
	
	/*--------------- LIST OF ITEMS OF CLASS TEAM ------------------*/
	/* Bow class */
	private ItemStack bow_arrow = new ItemStack(Material.ARROW, 32);
	private ItemStack bow_leather_helmet = new ItemStack(Material.LEATHER_HELMET, 1);
	private ItemStack bow_leather_chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	private ItemStack bow_leather_leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	private ItemStack bow_leather_boots = new ItemStack(Material.LEATHER_BOOTS, 1);
	private ItemStack bow_water_bucket = new ItemStack(Material.WATER_BUCKET, 10);
	
	/* Sword Class*/
	private ItemStack Sword_iron_sword = new ItemStack(Material.IRON_SWORD, 1);
	private ItemStack Sword_golden_helmet = new ItemStack(Material.GOLDEN_HELMET, 1);
	private ItemStack Sword_golden_chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
	private ItemStack Sword_golden_leggings = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
	private ItemStack Sword_golden_boots = new ItemStack(Material.GOLDEN_BOOTS, 1);
	private ItemStack Sword_water_bucket = new ItemStack(Material.WATER_BUCKET, 2);
	
	/* Potion Class */
	private ItemStack Potion_flint_and_steel = new ItemStack(Material.FLINT_AND_STEEL, 1);
	private ItemStack Potion_chainmail_helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
	private ItemStack Potion_chainmail_chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
	private ItemStack Potion_chainmail_leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
	private ItemStack Potion_chainmail_boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
	private ItemStack Potion_COBWEB = new ItemStack(Material.COBWEB, 15);
	
	/* EATing */
	private ItemStack golden_apple = new ItemStack(Material.GOLDEN_APPLE, 5);
	private ItemStack cooked_porkchop = new ItemStack(Material.COOKED_PORKCHOP, 16);
	private ItemStack bread = new ItemStack(Material.BREAD, 5);
	private ItemStack ENCHANTED_APPLE = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 20);

	
	
	
	@EventHandler
	public void SelectTeam(PlayerInteractEvent ivent){
		
		/* Get Players*/
		Player p = ivent.getPlayer();
		
		if(ivent.getAction() == Action.RIGHT_CLICK_BLOCK && ivent.getClickedBlock().getType() == Material.BLUE_WOOL){
			
			/* Set default size of inventory*/
			InventoryTeamBlu = Bukkit.createInventory(null, SizeOfInventory, NameOfINventory_BlueTeam);
			
			/* Add item to inventory*/
			for (int i = 0; i < InventoryTeamBlu.getSize(); i++) {
				switch(i) {
				case 12:
					InventoryTeamBlu.setItem(12, Bow);
					break;
				case 13:
					InventoryTeamBlu.setItem(13, Golden_sword);
					break;
				case 14:
					InventoryTeamBlu.setItem(14, Potion);
					break;
				default:
					InventoryTeamBlu.setItem(i, blue_stained_glass_pane);
				}
			}
			
			/* Open inventory */
			p.openInventory(InventoryTeamBlu);
			
		}else {
			if(ivent.getAction() == Action.RIGHT_CLICK_BLOCK && ivent.getClickedBlock().getType() == Material.RED_WOOL){
				
				/* Set default size of inventory*/
				InventoryTeamRed = Bukkit.createInventory(null, SizeOfInventory, NameOfINventory_RedTeam);
				
				/* Add item to inventory*/
				for (int i = 0; i < InventoryTeamRed.getSize(); i++) {
					switch(i) {
					case 12:
						InventoryTeamRed.setItem(12, Bow);
						break;
					case 13:
						InventoryTeamRed.setItem(13, Golden_sword);
						break;
					case 14:
						InventoryTeamRed.setItem(14, Potion);
						break;
					default:
						InventoryTeamRed.setItem(i, red_stained_glass_pane);
					}
				}
				
				/* Open inventory */
				p.openInventory(InventoryTeamRed);
			}
		}
	}
	
	@EventHandler
	public void InventoryChecker(InventoryClickEvent e){
		/* NO set/get item to castom Inventory	*/
		Inventory i = e.getInventory();
		
		if(!i.equals(this.InventoryTeamBlu) && !i.equals(this.InventoryTeamRed))return;
		
		Inventory ClikedInventory = e.getClickedInventory();
		
		if(ClikedInventory == null)return;
		
		if(ClikedInventory.equals(InventoryTeamBlu) || ClikedInventory.equals(InventoryTeamRed))
			e.setCancelled(true);
		
		
		/*--------------SELECT CALSS----------------*/
		
		/*		BOW CLASS		*/
		if(e.getCurrentItem().equals(Bow)){
			/*	Ecqupiment ad eat */
			e.getWhoClicked().getInventory().addItem(Bow);
			e.getWhoClicked().getInventory().addItem(bow_arrow);
			e.getWhoClicked().getInventory().addItem(bow_leather_helmet);
			e.getWhoClicked().getInventory().addItem(bow_leather_chestplate);
			e.getWhoClicked().getInventory().addItem(bow_leather_leggings);
			e.getWhoClicked().getInventory().addItem(bow_leather_boots);
			e.getWhoClicked().getInventory().addItem(bow_water_bucket);
			
			e.getWhoClicked().getInventory().addItem(golden_apple);
			e.getWhoClicked().getInventory().addItem(cooked_porkchop);
			e.getWhoClicked().getInventory().addItem(bread);
			
		}
		
		/*		SWORD CLASS		*/
		if(e.getCurrentItem().equals(Golden_sword)){
			/*	Ecqupiment ad eat */
			e.getWhoClicked().getInventory().addItem(Sword_iron_sword);
			e.getWhoClicked().getInventory().addItem(Sword_golden_helmet);
			e.getWhoClicked().getInventory().addItem(Sword_golden_chestplate);
			e.getWhoClicked().getInventory().addItem(Sword_golden_leggings);
			e.getWhoClicked().getInventory().addItem(Sword_golden_boots);
			e.getWhoClicked().getInventory().addItem(Sword_water_bucket);
			
			e.getWhoClicked().getInventory().addItem(golden_apple);
			e.getWhoClicked().getInventory().addItem(cooked_porkchop);
			e.getWhoClicked().getInventory().addItem(bread);
			
		}
		
		/*		POTION CLASS		*/
		if(e.getCurrentItem().equals(Potion)){
			/*	Ecqupiment ad eat */
			e.getWhoClicked().getInventory().addItem(Potion_flint_and_steel);
			e.getWhoClicked().getInventory().addItem(Potion_chainmail_helmet);
			e.getWhoClicked().getInventory().addItem(Potion_chainmail_chestplate);
			e.getWhoClicked().getInventory().addItem(Potion_chainmail_leggings);
			e.getWhoClicked().getInventory().addItem(Potion_chainmail_boots);
			e.getWhoClicked().getInventory().addItem(Potion_COBWEB);
			
			e.getWhoClicked().getInventory().addItem(golden_apple);
			e.getWhoClicked().getInventory().addItem(cooked_porkchop);
			e.getWhoClicked().getInventory().addItem(bread);
			e.getWhoClicked().getInventory().addItem(ENCHANTED_APPLE);
			
		}
		
		
		/*------------TELEPORT TO MAP BUTTLE-------------*/
		if(i.equals(InventoryTeamBlu)){
			
			Runnable s = new Runnable() {
				
				@Override
				public void run() {
					e.getWhoClicked().sendMessage("Wait Second : " + SecondToWaitForSpawn);
					SecondToWaitForSpawn--;
					if(SecondToWaitForSpawn == 0){
						e.getWhoClicked().sendMessage("Teleporting...");
						Bukkit.getScheduler().cancelTask(id);
						e.getWhoClicked().teleport(new Location(e.getWhoClicked().getLocation().getWorld(), BlueTeamCoordination[0], BlueTeamCoordination[1], BlueTeamCoordination[2]));
						SecondToWaitForSpawn = ReloaderOfTimeSpawn;
					}
				}
			};
			id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin(PluginName), s, 0, TimeForTask);
		}
			/*Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin(PluginName), r, secondsForSpawn);*/
		
		/*------------TELEPORT TO MAP BUTTLE-------------*/
		if(i.equals(InventoryTeamRed)){
			
				Runnable s = new Runnable() {
				
				@Override
				public void run() {
					e.getWhoClicked().sendMessage("Wait Second : " + SecondToWaitForSpawn);
					SecondToWaitForSpawn--;
					if(SecondToWaitForSpawn == 0){
						e.getWhoClicked().sendMessage("Teleporting...");
						Bukkit.getScheduler().cancelTask(id);
						e.getWhoClicked().teleport(new Location(e.getWhoClicked().getLocation().getWorld(), RedTeamCoordination[0], RedTeamCoordination[1], RedTeamCoordination[2]));
						SecondToWaitForSpawn = ReloaderOfTimeSpawn;
					}	
				}
			};
			id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin(PluginName), s, 0, TimeForTask);

		}
	}
}
