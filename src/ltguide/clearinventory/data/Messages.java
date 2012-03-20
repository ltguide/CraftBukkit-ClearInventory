package ltguide.clearinventory.data;

import ltguide.base.data.IMessage;

public enum Messages implements IMessage {
	SYNTAX(false),
	PERMISSION(false),
	RELOAD(true),
	TARGET_RESULTS(false),
	TARGET_REQUIRED(false),
	CLEAR_ALL(true),
	CLEAR_MAIN(true),
	CLEAR_BAR(true),
	CLEAR_DONE(true);
	
	private boolean usesPrefix;
	
	Messages(final boolean usesPrefix) {
		this.usesPrefix = usesPrefix;
	}
	
	@Override
	public boolean usesPrefix() {
		return usesPrefix;
	}
}
