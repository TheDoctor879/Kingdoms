package net.valdaycraft.kingdoms.util;

import java.io.File;
import java.io.IOException;

import net.valdaycraft.kingdoms.KingdomAPI;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Disassembler {
	
	public static void disassembleKingdom(String kingdom, Player owner) {
		File file = KingdomAPI.getRawKingdomFile(kingdom);
		if (file != null) {
			FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
			if (fc.getStringList("Colonies") == null || fc.getStringList("Colonies").isEmpty()) {
				String s = KingdomAPI.getStatus(kingdom);
				owner.sendMessage(ChatColor.GREEN + "The " + s + " " + ChatColor.YELLOW + kingdom + ChatColor.GREEN + " has collapsed.");
				try {
					fc.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.delete();
			} else {
				String status = KingdomAPI.getStatus(kingdom);
				owner.sendMessage(ChatColor.GREEN + "The " + status + " " + ChatColor.YELLOW + kingdom + ChatColor.GREEN + " has disbanded.");
				
			}
		}
	} 
}
