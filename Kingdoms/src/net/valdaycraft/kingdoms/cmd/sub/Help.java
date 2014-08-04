package net.valdaycraft.kingdoms.cmd.sub;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
	
	public static void display(Player player) {
		player.sendMessage(ChatColor.YELLOW + "------- " + ChatColor.AQUA + "Kingdoms Help" + ChatColor.YELLOW + " -------");
		player.sendMessage(ChatColor.AQUA + "/k help" + ChatColor.LIGHT_PURPLE + ": Displays all command and sub-command descriptions.");
		player.sendMessage(ChatColor.AQUA + "/k c, e, claim, expand" + ChatColor.LIGHT_PURPLE + ": Claim more land for your empire.");
		player.sendMessage(ChatColor.AQUA + "/k create, load, form <Kingdom Name> <Political System> <Capitol>" + ChatColor.LIGHT_PURPLE + ": Creates a new Kingdom.");
		player.sendMessage(ChatColor.AQUA + "/k dis, disband, collapse" + ChatColor.LIGHT_PURPLE + ": Destroys your current kingdom. (Only works for leader presently.)");
		player.sendMessage(ChatColor.AQUA + "/k h, home" + ChatColor.LIGHT_PURPLE + ": Teleport to your kingdom's home.");
		player.sendMessage(ChatColor.AQUA + "/k i, info (Kingdom Name/Player Name)" + ChatColor.LIGHT_PURPLE + ": Displays all information of specified kingdoms.");
		player.sendMessage(ChatColor.AQUA + "/k w, war, attack <Kingdom Name/Player Name>" + ChatColor.LIGHT_PURPLE + ": Declares a state of war with the designated kingdom/empire.");
	}
}
