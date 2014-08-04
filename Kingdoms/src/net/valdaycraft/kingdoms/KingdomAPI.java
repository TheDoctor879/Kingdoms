package net.valdaycraft.kingdoms;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class KingdomAPI {
	public static File getRawKingdomFile(String k) {
		File f = new File("ValdayCraft" + File.separator + "Kingdoms" + File.separator + "Interface" + File.separator + k + ".yml");
		return f;
		
	}
	public static FileConfiguration getKingdomFile(String k) {
		File f = new File("ValdayCraft" + File.separator + "Kingdoms" + File.separator + "Interface" + File.separator + k + ".yml");
		FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
		try {
			fc.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fc;
	}
	public static int getPlayersTotal(String kingdom) {
		int p = KingdomAPI.getKingdomFile(kingdom).getInt("Population");
		return p;
	}
	public static void getColonies(String kingdom) {
	}
	public static String getStatus(String kingdom) {
		File file = getRawKingdomFile(kingdom);
		FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
		String status = fc.getString("Status");
		return status;
	}
}
