package ltguide.clearinventory.configuration;

import ltguide.base.data.Configuration;
import ltguide.clearinventory.data.Commands;
import ltguide.clearinventory.data.Messages;

import org.bukkit.plugin.java.JavaPlugin;

public class Config extends Configuration {
	public Config(final JavaPlugin instance) {
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
		Base.warning("migrating configuration");
		
		if (versionCompare(oldVersion, new int[] { 0, 0, 0 })) {
			
		}
		*/
	}
	
	private void checkConfig() {
		super.setDefaults(Messages.values(), Commands.values());
	}
}
