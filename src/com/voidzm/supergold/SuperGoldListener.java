package com.voidzm.supergold;

import java.util.Iterator;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SuperGoldListener implements Listener {
	
	public SuperGold plugin;
	
	public SuperGoldListener(SuperGold owner) {
		this.plugin = owner;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if(event.getPlayer().hasPermission("supergold.blocks")) {
			Block brokenBlock = event.getBlock();
			int breakingItemID = event.getPlayer().getItemInHand().getTypeId();
			boolean wasBrokenWithPermissibleTool = false;
			if(brokenBlock.getTypeId() == plugin.getConfig().getInt("block.netherrack.source") && plugin.getConfig().getBoolean("block.netherrack.enabled")) {
				List<Integer> permissibleIds = plugin.getConfig().getIntegerList("block.netherrack.tool");
				Iterator<Integer> iterator = permissibleIds.iterator();
				while(iterator.hasNext()) {
					if(iterator.next() == breakingItemID) {
						wasBrokenWithPermissibleTool = true;
						break;
					}
				}
				if(wasBrokenWithPermissibleTool) {
					event.setCancelled(true);
					brokenBlock.setTypeId(0);
					ItemStack stackToDrop = new ItemStack(87, plugin.getConfig().getInt("block.netherrack.drop"));
					brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), stackToDrop);
				}
			}
			else if(brokenBlock.getTypeId() == plugin.getConfig().getInt("block.soulsand.source") && plugin.getConfig().getBoolean("block.soulsand.enabled")) {
				List<Integer> permissibleIds = plugin.getConfig().getIntegerList("block.soulsand.tool");
				Iterator<Integer> iterator = permissibleIds.iterator();
				while(iterator.hasNext()) {
					if(iterator.next() == breakingItemID) {
						wasBrokenWithPermissibleTool = true;
						break;
					}
				}
				if(wasBrokenWithPermissibleTool) {
					event.setCancelled(true);
					brokenBlock.setTypeId(0);
					ItemStack stackToDrop = new ItemStack(88, plugin.getConfig().getInt("block.soulsand.drop"));
					brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), stackToDrop);
				}
			}
			else if(brokenBlock.getTypeId() == plugin.getConfig().getInt("block.netherbrick.source") && plugin.getConfig().getBoolean("block.netherbrick.enabled")) {
				List<Integer> permissibleIds = plugin.getConfig().getIntegerList("block.netherbrick.tool");
				Iterator<Integer> iterator = permissibleIds.iterator();
				while(iterator.hasNext()) {
					if(iterator.next() == breakingItemID) {
						wasBrokenWithPermissibleTool = true;
						break;
					}
				}
				if(wasBrokenWithPermissibleTool) {
					event.setCancelled(true);
					brokenBlock.setTypeId(0);
					ItemStack stackToDrop = new ItemStack(112, plugin.getConfig().getInt("block.netherbrick.drop"));
					brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), stackToDrop);
				}
			}
			else if(brokenBlock.getTypeId() == plugin.getConfig().getInt("block.glowstone.source") && plugin.getConfig().getBoolean("block.glowstone.enabled")) {
				List<Integer> permissibleIds = plugin.getConfig().getIntegerList("block.glowstone.tool");
				Iterator<Integer> iterator = permissibleIds.iterator();
				while(iterator.hasNext()) {
					if(iterator.next() == breakingItemID) {
						wasBrokenWithPermissibleTool = true;
						break;
					}
				}
				if(wasBrokenWithPermissibleTool) {
					event.setCancelled(true);
					brokenBlock.setTypeId(0);
					int numToDrop = plugin.getConfig().getInt("block.glowstone.drop.min") + (int)(Math.random() * ((plugin.getConfig().getInt("block.glowstone.drop.max") - plugin.getConfig().getInt("block.glowstone.drop.min")) + 1));
					int i;
					for(i = 0; i < numToDrop; i++) {
						ItemStack stackToDrop = new ItemStack(348, 1);
						brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), stackToDrop);
					}
				}
			}
		}
		if(event.getPlayer().hasPermission("supergold.ice") && event.getBlock().getTypeId() == 79) {
			int breakingItemID = event.getPlayer().getItemInHand().getTypeId();
			boolean wasBrokenWithPermissibleTool = false;
			List<Integer> permissibleIds = plugin.getConfig().getIntegerList("ice.tool");
			Iterator<Integer> iterator = permissibleIds.iterator();
			while(iterator.hasNext()) {
				if(iterator.next() == breakingItemID) {
					wasBrokenWithPermissibleTool = true;
					break;
				}
			}
			if(wasBrokenWithPermissibleTool) {
				float coefficient = 100 / plugin.getConfig().getInt("ice.chance");
				int rand = 1 + (int)(Math.random() * coefficient);
				event.setCancelled(true);
				event.getBlock().setTypeId(0);
				if(rand == 1) {
					ItemStack stackToDrop = new ItemStack(79, 1);
					event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), stackToDrop);
				}
			}
		}
	}
}
