package ltguide.clearinventory.data;

import java.util.Arrays;

import ltguide.base.data.Command;
import ltguide.base.data.IEnum;
import ltguide.base.exceptions.CommandException;

import org.bukkit.command.CommandSender;

public enum Commands implements IEnum {
	ALL("self", Messages.CLEAR_ALL, "[@playername]", true),
	MAIN("self", Messages.CLEAR_MAIN, "[@playername]", true),
	BAR("self", Messages.CLEAR_BAR, "[@playername]", true),
	RELOAD("reload", Messages.RELOAD, "", false);
	
	public Command handle;
	
	Commands(final String permission, final Messages messages, final String syntax, final boolean usesTarget) {
		handle = new Command(name(), "clearinventory." + permission, messages.handle, syntax, usesTarget);
		Command.put(handle);
	}
	
	public static Commands get(final CommandSender sender, final String label, final String[] args) throws CommandException {
		try {
			final Commands commands = valueOf(args[0].toUpperCase());
			commands.handle.init(sender, label, Arrays.asList(args));
			return commands;
		}
		catch (final CommandException e) {
			throw e;
		}
		catch (final Exception e) {
			for (final Commands commands : Commands.values())
				commands.handle.sendSyntax(sender, label);
			
			return null;
		}
	}
}
