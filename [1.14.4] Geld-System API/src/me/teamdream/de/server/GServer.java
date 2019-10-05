package me.teamdream.de.server;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.teamdream.de.server.listener.MoneyListener;

public class GServer extends JavaPlugin {
	
	private static GServer pl = null;
	public static GServer getInstance() {
		return pl;
	}
	
	@Override
	public void onEnable() {
		pl = this;
		
		new MoneyListener(this);
		 
		Bukkit.getConsoleSender().sendMessage("§aDas Plugin wurde erfolgreich geladen!");
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
}
