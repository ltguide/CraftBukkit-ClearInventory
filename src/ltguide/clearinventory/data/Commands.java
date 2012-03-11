package ltguide.clearinventory.data;

import ltguide.base.data.ICommand;

public enum Commands implements ICommand {
	ALL("self", Messages.CLEAR_ALL, "[@playername]", true),
	MAIN("self", Messages.CLEAR_MAIN, "[@playername]", true),
	BAR("self", Messages.CLEAR_BAR, "[@playername]", true),
	RELOAD("reload", Messages.RELOAD, "", false);
	
	private String permission;
	private Messages message;
	private String syntax;
	private boolean usesTarget;
	
	Commands(final String permission, final Messages message, final String syntax, final boolean usesTarget) {
		this.permission = "clearinventory." + permission;
		this.message = message;
		this.syntax = syntax;
		this.usesTarget = usesTarget;
	}
	
	public static Commands get(final String[] args) {
		try {
			return valueOf(args[0].toUpperCase());
		}
		catch (final Exception e) {
			return null;
		}
	}
	
	@Override
	public String permission() {
		return permission;
	}
	
	@Override
	public Messages message() {
		return message;
	}
	
	@Override
	public String syntax() {
		return syntax;
	}
	
	@Override
	public boolean usesTarget() {
		return usesTarget;
	}
}
