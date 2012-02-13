package com.voidzm.supergold;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperGold extends JavaPlugin {

	public FileConfiguration cfg;
	public PluginManager pluginManager;
	public Logger logObj = Logger.getLogger("Minecraft");
	private final SuperGoldListener listener = new SuperGoldListener(this);
	
	public void onEnable() {
		cfg = this.getConfig();
		pluginManager = this.getServer().getPluginManager();
		pluginManager.registerEvents(listener, this);
		logObj.info("[SuperGold] v1.0.0 enabled!");
		if(!cfg.contains("block.netherrack.enabled")) {
			writeDefaultConfig();
		}
	}
	
	public void onDisable() {
		logObj.info("[SuperGold] v1.0.0 disabled!");
	}
	
	private void writeDefaultConfig() {
		cfg.set("block.netherrack.enabled", true);
		cfg.set("block.netherrack.source", 1);
		List<Integer> netherrackList = new ArrayList<Integer>();
		netherrackList.add(new Integer(285));
		cfg.set("block.netherrack.tool", netherrackList);
		cfg.set("block.netherrack.drop", 1);
		cfg.set("block.soulsand.enabled", true);
		cfg.set("block.soulsand.source", 12);
		List<Integer> soulsandList = new ArrayList<Integer>();
		soulsandList.add(new Integer(284));
		soulsandList.add(new Integer(285));
		cfg.set("block.soulsand.tool", soulsandList);
		cfg.set("block.soulsand.drop", 1);
		cfg.set("block.netherbrick.enabled", true);
		cfg.set("block.netherbrick.source", 98);
		List<Integer> netherbrickList = new ArrayList<Integer>();
		netherbrickList.add(new Integer(285));
		cfg.set("block.netherbrick.tool", netherbrickList);
		cfg.set("block.netherbrick.drop", 1);
		cfg.set("block.glowstone.enabled", true);
		cfg.set("block.glowstone.source", 20);
		List<Integer> glowstoneList = new ArrayList<Integer>();
		glowstoneList.add(new Integer(283));
		glowstoneList.add(new Integer(285));
		cfg.set("block.glowstone.tool", glowstoneList);
		cfg.set("block.glowstone.drop.min", 2);
		cfg.set("block.glowstone.drop.max", 4);
		this.saveConfig();
		logObj.warning("[SuperGold] Config missing! This is normal if this is your first time running SuperGold!");
	}
}
