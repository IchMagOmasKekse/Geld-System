package me.teamdream.de.server.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.teamdream.de.server.AccountManager;
import me.teamdream.de.server.GServer;
import me.teamdream.de.server.events.GeldAuszahlEvent;
import me.teamdream.de.server.events.GeldEinzahlEvent;
import me.teamdream.de.server.events.GeldGesetztEvent;
import me.teamdream.de.server.events.GeldVerschickenEvent;

public class MoneyListener implements Listener {
	
	
	public MoneyListener(GServer pl) {
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}
	
	@EventHandler
	public void onMoneyAdd(GeldEinzahlEvent e) {
		Player p = Bukkit.getPlayer(e.getGetter());
		if(e.wasSuccess()) {
			if(e.getAnzahl() > 0) p.sendMessage("�b[GeldEinzahlEvent] �7Dein Kontostand hat sich ver�ndert �7-> �2+"+e.getAnzahl());
			else p.sendMessage("�b[GeldEinzahlEvent] �7Dein Kontostand hat sich ver�ndert �7-> �c"+e.getAnzahl());
			
			p.sendMessage("�b[GeldEinzahlEvent] �7Kontostand: �f"+AccountManager.getMoney(e.getGetter()));
		}else {
			p.sendMessage("�b[GeldEinzahlEvent] �cDein Transfer-Vorgang konnte nicht abgeschlossen werden");
		}
	}
	@EventHandler
	public void onMoneySubtract(GeldAuszahlEvent e) {
		Player p = Bukkit.getPlayer(e.getGetter());
		if(e.wasSuccess()) {
			if(e.getAnzahl() > 0) p.sendMessage("�b[GeldAuszahlEvent] �7Dein Kontostand hat sich ver�ndert �7-> �2+"+e.getAnzahl());
			else p.sendMessage("�b[GeldAuszahlEvent] �7Dein Kontostand hat sich ver�ndert �7-> �c"+e.getAnzahl());
			
			p.sendMessage("�b[GeldAuszahlEvent] �7Kontostand: �f"+AccountManager.getMoney(e.getGetter()));
		}else {
			p.sendMessage("�b[GeldAuszahlEvent] �cDein Transfer-Vorgang konnte nicht abgeschlossen werden");
		}
	}
	@EventHandler
	public void onVerschicken(GeldVerschickenEvent e) {
		Bukkit.broadcastMessage("�bGeldVerschickenEvent �7hat ausgel�st!");
	}
	@EventHandler
	public void onSetzen(GeldGesetztEvent e) {
		Bukkit.broadcastMessage("�bGeldGesetztEvent �7hat ausgel�st!");
	}
}
