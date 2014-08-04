package net.valdaycraft.kingdoms.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.valdaycraft.kingdoms.UUIDFetcher;

public class Generator {
	
	public void load(String kingdom, String leader, String type, String capitol) {
		@SuppressWarnings("deprecation")
		Player player = Bukkit.getPlayer(leader);
		UUID leaderId = null;
		try {
			leaderId = UUIDFetcher.getUUIDOf(leader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (leaderId != null) {
			File f = new File("ValdayCraft" + File.separator + "Kingdoms" + File.separator + "Interface" + File.separator + kingdom + ".yml");
			FileConfiguration config = YamlConfiguration.loadConfiguration(f);
			List<UUID> players = new ArrayList<UUID>();
			config.set("Name", kingdom);
			players.add(leaderId);
			config.set("Players", 1);
			if (type == "Oligarchy") {
				config.set("System", type);
				config.set("Leader", leaderId.toString());
			}
			if (type == "Monarchy") {
				config.set("System", type);
				config.set("Leader", leaderId.toString());
			}
			if (type == "Democracy") {
				config.set("System", type);
				config.set("Leader", leaderId.toString());
			}
			if (type == "Tyrrany") {
				config.set("System", type);
				config.set("Leader", leaderId.toString());
			}
			if (type != "Tyrrany" && type != "Democracy" && type != "Oligarcy" && type != "Monarchy") {
				config.set("System", "Monarchy");
				config.set("Leader", leaderId.toString());
			}
			config.set("Capitol", capitol);
			config.set("HomeX", player.getLocation().getBlockX() + 0.5);
			config.set("HomeY", player.getLocation().getBlockY());
			config.set("HomeZ", player.getLocation().getBlockZ());
			config.set("HomeWorld", player.getWorld().getName());
			config.set("HomeYaw", player.getLocation().getYaw());
			config.set("HomePitch", player.getLocation().getPitch());
			config.set("STatus", "Kingdom");
			config.set("Players", players);
			config.set("Population", players.size());
			try {
				config.save(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.sendMessage(ChatColor.GREEN + "You have established " + ChatColor.AQUA + kingdom + ChatColor.GREEN + " as a new kingdom.");
		} else {
			Bukkit.getServer().getLogger().log(Level.SEVERE, ChatColor.RED + "No leader found. The kingdom '" + kingdom + "' was not created.");
		}
	}
}
