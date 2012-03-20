package ltguide.clearinventory;

import ltguide.base.Base;
import ltguide.base.exceptions.CommandException;
import ltguide.clearinventory.configuration.Strings;
import ltguide.clearinventory.listeners.CommandListener;

import org.bukkit.inventory.PlayerInventory;

public class ClearInventory extends Base {
	public Strings strings;
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		strings = new Strings(this);
		
		if (getServer().getPluginManager().getPlugin("Vault") != null) usePermission();
		
		new CommandListener(this);
	}
	
	public void reload() {
		strings.reload();
	}
	
	public void clearPlayerInventory(final int firstSlot, int lastSlot) throws CommandException {
		if (command.getSender() != command.getTarget()) {
			if (!hasPermission(command.getSender(), "others")) throw new CommandException(getMessage("PERMISSION"));
			send(command.getSender(), getMessage("CLEAR_DONE", command.getTarget().getName() + "'s"));
		}
		
		final PlayerInventory inventory = command.getTarget().getInventory();
		
		if (lastSlot == -1) lastSlot = inventory.getSize();
		
		for (Integer i = firstSlot; i < lastSlot; i++)
			inventory.clear(i);
		
		broadcast(command.getTarget());
	}
}
