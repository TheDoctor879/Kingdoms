package net.valdaycraft.kingdoms.cmd;

import java.util.UUID;

import net.valdaycraft.kingdoms.Core;
import net.valdaycraft.kingdoms.UUIDFetcher;
import net.valdaycraft.kingdoms.cmd.sub.Help;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KingdomsCommand implements CommandExecutor {
	
	Core thisPlugin;
	
	public KingdomsCommand(Core iPlugin) {
		this.thisPlugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("k")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				UUID id = null;
				try {
					id = UUIDFetcher.getUUIDOf(player.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (args.length == 0) {
					Help.display(player);
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("h")) {
						Help.display(player);
					}
					if (args[0].equalsIgnoreCase("i") || args[0].equalsIgnoreCase("info")) {
						
					}
				}
			}
		}
		return true;
	}

}
