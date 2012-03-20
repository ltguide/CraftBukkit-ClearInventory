package ltguide.clearinventory.configuration;

import ltguide.base.Base;
import ltguide.base.configuration.StringsConfiguration;
import ltguide.clearinventory.data.Commands;
import ltguide.clearinventory.data.Messages;

public class Strings extends StringsConfiguration {
	public Strings(final Base instance) {
		super(instance, Messages.values(), Commands.values());
		reload();
	}
	
	@Override
	protected void migrate() {
		/*
		if (versionCompare(0, 4)) {
			
		}
		*/
	}
}
