package CastleWarsPackage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;



public class Handler implements Listener{
	
	
	@EventHandler
	public void join(PlayerJoinEvent event){
		Player player = event.getPlayer();
		ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
		player.getInventory().addItem(item);
	}
	
	/* Create at inventory */
	private Inventory InventoryTeamBlu;
	private Inventory InventoryTeamRed;
	
	/*	Create Item of Inventory */
	private ItemStack Bow = new ItemStack(Material.BOW);
	private ItemStack Golden_sword = new ItemStack(Material.GOLDEN_SWORD);
	private ItemStack Potion = new ItemStack(Material.POTION);
	
	@EventHandler
	public void SelectTeam(PlayerInteractEvent ivent){
		
		/* Get Players*/
		Player p = ivent.getPlayer();
		
		if(ivent.getAction() == Action.RIGHT_CLICK_BLOCK && ivent.getClickedBlock().getType() == Material.BLUE_WOOL){
			
			/* Set default size of inventory*/
			InventoryTeamBlu = Bukkit.createInventory(null, 27, "Blue Team");
			
			/* Add item to inventory*/
			InventoryTeamBlu.setItem(11, Bow);
			InventoryTeamBlu.setItem(12, Golden_sword);
			InventoryTeamBlu.setItem(13, Potion);
			
			/* Open inventory */
			p.openInventory(InventoryTeamBlu);
			
		}else {
			if(ivent.getAction() == Action.RIGHT_CLICK_BLOCK && ivent.getClickedBlock().getType() == Material.RED_WOOL){
				
				/* Set default size of inventory*/
				InventoryTeamRed = Bukkit.createInventory(null, 27, "Red Team");
				
				/* Add item to inventory*/
				InventoryTeamRed.setItem(11, Bow);
				InventoryTeamRed.setItem(12, Golden_sword);
				InventoryTeamRed.setItem(13, Potion);
				
				/* Open inventory */
				p.openInventory(InventoryTeamRed);
			}
		}
	}
	
}
