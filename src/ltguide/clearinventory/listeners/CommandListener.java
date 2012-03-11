package ltguide.clearinventory.listeners;

import ltguide.base.exceptions.CommandException;
import ltguide.clearinventory.ClearInventory;
import ltguide.clearinventory.data.Commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListener implements CommandExecutor {
	private final ClearInventory plugin;
	
	public CommandListener(final ClearInventory instance) {
		plugin = instance;
		
		plugin.getCommand("clearinventory").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(final CommandSender sender, final org.bukkit.command.Command c, final String label, final String[] args) {
		try {
			final Commands commands = Commands.get(args);
			if (commands == null) return plugin.sendCommands(sender, label);
			
			plugin.initCommand(commands, sender, label, args);
			
			switch (commands) {
				case ALL:
					plugin.clearPlayerInventory(0, -1);
					break;
				case MAIN:
					plugin.clearPlayerInventory(9, -1);
					break;
				case BAR:
					plugin.clearPlayerInventory(0, 9);
					break;
				case RELOAD:
					plugin.config.reload();
					plugin.broadcast(sender);
					break;
			}
			
		}
		catch (final CommandException e) {
			plugin.send(sender, e.getMessage());
		}
		
		return true;
	}
}
