package net.valdaycraft.kingdoms.cmd.sub;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Information {
	
	public static void display(String Kingdom, Player sendee) {
		File kingdomFile = new File("ValdayCraft" + File.separator + "Kingdoms" + File.separator + "Interface" + File.separator + Kingdom + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(kingdomFile);
		String capitol = config.getString("Capitol");
		String name = config.getString("");
	}
	@Deprecated
	public static void display(Player player, Player sendee) {
		
	}
	public static void displaySingle(Player player) {
		
	}
}
