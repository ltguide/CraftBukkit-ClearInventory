package ltguide.clearinventory.listeners;

import ltguide.base.Base;
import ltguide.base.data.Command;
import ltguide.base.data.Message;
import ltguide.base.exceptions.CommandException;
import ltguide.clearinventory.ClearInventory;
import ltguide.clearinventory.data.Commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class CommandListener implements CommandExecutor {
	private final ClearInventory plugin;
	
	public CommandListener(final ClearInventory plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("clearinventory").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(final CommandSender sender, final org.bukkit.command.Command c, final String label, final String[] args) {
		try {
			final Commands commands;
			if ((commands = Commands.get(sender, label, args)) == null) return true;
			
			switch (commands) {
				case ALL:
					clearPlayerInventory(commands.handle, 0, -1);
					break;
				case MAIN:
					clearPlayerInventory(commands.handle, 9, -1);
					break;
				case BAR:
					clearPlayerInventory(commands.handle, 0, 9);
					break;
				case RELOAD:
					plugin.config.reload();
					Base.broadcast(sender, commands.handle);
					break;
			}
			
		}
		catch (final CommandException e) {
			Base.send(sender, e.getMessage());
		}
		
		return true;
	}
	
	private void clearPlayerInventory(final Command command, final int firstSlot, int lastSlot) throws CommandException {
		if (command.getTarget() == null) throw new CommandException(Message.get("TARGET_REQUIRED"));
		
		if ((Player) command.getSender() != command.getTarget()) {
			if (!Base.hasPermission(command.getSender(), "others")) throw new CommandException(Message.get("PERMISSION"));
			Base.send(command.getSender(), Message.getText("CLEAR_DONE", command.getTarget().getName() + "'s"));
		}
		
		final PlayerInventory inventory = command.getTarget().getInventory();
		
		if (lastSlot == -1) lastSlot = inventory.getSize();
		
		for (Integer i = firstSlot; i < lastSlot; i++)
			inventory.clear(i);
		
		Base.broadcast(command.getTarget(), command);
	}
}
