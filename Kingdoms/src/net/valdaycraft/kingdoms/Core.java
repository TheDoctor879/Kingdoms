package net.valdaycraft.kingdoms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Kingdoms: " + ChatColor.YELLOW + "Loading properties...");
		File file = new File("ValdayCraft" + File.separator + "Kingdoms" + File.separator + "config.yml");
		if (!file.exists()) {
		    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		    config.set("Default", "Wilderness");
		    List<String> list = new ArrayList<String>();
		    list.add(config.getString("Default"));
		    config.set("Kingdoms", list);
		    try {
			    config.save(file);
		    } catch (IOException e) {
		    	getServer().getLogger().severe(ChatColor.RED + "FileConfiguration did not save correctly. Check lines 23-30 in net.valdaycraft.kingdoms.Core");
			    e.printStackTrace();
		    }
		} else {
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			List<String> kingdoms = config.getStringList("Kingdoms");
			getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Kingdoms: " + ChatColor.YELLOW + "Loaded (" + ChatColor.LIGHT_PURPLE + kingdoms.size() + ChatColor.YELLOW + ") kingdoms and empires.");
		}
	}
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Kingdoms: " + ChatColor.YELLOW + "Saved all properties and kingdoms.");
	}
}
