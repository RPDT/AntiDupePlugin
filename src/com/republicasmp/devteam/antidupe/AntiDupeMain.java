package com.republicasmp.devteam.antidupe;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.SignChangeEvent;

public class AntiDupeMain extends JavaPlugin implements Listener{
	
	public void onEnable(){
		getLogger().info("Plugin Enabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
 
	public void onDisable(){
		getLogger().info("Plugin Disabled!");
	}
	
	@EventHandler
	public void onPlayerSign(SignChangeEvent e){
		String temp = e.getLine(3);
		
		if(temp.equalsIgnoreCase("wool:17") || temp.equalsIgnoreCase("35:17")){
			e.getBlock().breakNaturally();
			e.getPlayer().kickPlayer("Don't attempt to dupe " + e.getPlayer().getDisplayName() + " it just makes you look stupid");
			getLogger().info("Player " + e.getPlayer().getName() + " attempted the duplication bug");
		}
	}
}
