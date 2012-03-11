package ltguide.clearinventory.configuration;

import ltguide.base.Base;
import ltguide.base.configuration.Configuration;
import ltguide.clearinventory.data.Commands;
import ltguide.clearinventory.data.Messages;

public class Config extends Configuration {
	public Config(final Base instance) {
		super(instance);
		
		loadConfig();
		
		if (upgradeConfig()) {
			migrateConfig();
			saveConfig();
		}
		
		checkConfig();
	}
	
	public void reload() {
		loadConfig();
		checkConfig();
	}
	
	private void migrateConfig() {
		/*
		plugin.warning("migrating configuration");
		
		if (versionCompare(oldVersion, new int[] { 0, 0, 0 })) {
			
		}
		*/
	}
	
	private void checkConfig() {
		super.setDefaults(Messages.values(), Commands.values());
	}
}
