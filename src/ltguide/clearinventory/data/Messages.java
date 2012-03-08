package ltguide.clearinventory.data;

import ltguide.base.data.IEnum;
import ltguide.base.data.Message;

public enum Messages implements IEnum {
	PREFIX(false),
	SYNTAX(false),
	PERMISSION(false),
	RELOAD(true),
	TARGET_RESULTS(false),
	TARGET_REQUIRED(false),
	CLEAR_ALL(true),
	CLEAR_MAIN(true),
	CLEAR_BAR(true),
	CLEARED(true);
	
	public Message handle;
	
	Messages(final boolean usesPrefix) {
		handle = new Message(name(), usesPrefix);
		Message.put(handle);
	}
}
