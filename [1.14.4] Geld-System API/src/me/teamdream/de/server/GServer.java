package me.teamdream.de.server;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GServer extends JavaPlugin {

	private static GServer pl;

	@Override
	public void onEnable() {
		pl = this;

		Bukkit.getConsoleSender().sendMessage("§aDas Plugin wurde erfolgreich geladen!");
	}

	public static GServer getInstance() {
		return pl;
	}

}
