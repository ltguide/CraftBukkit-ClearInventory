package ltguide.clearinventory;

import ltguide.base.Base;
import ltguide.base.Debug;
import ltguide.clearinventory.configuration.Config;
import ltguide.clearinventory.listeners.CommandListener;

import org.bukkit.plugin.java.JavaPlugin;

public class ClearInventory extends JavaPlugin {
	public Config config;
	
	@Override public void onDisable() {}
	
	@Override public void onEnable() {
		if (Debug.ON) Debug.init(this);
		Base.init(this);
		config = new Config(this);
		
		if (getServer().getPluginManager().getPlugin("Vault") != null) Base.usePermission();
		
		new CommandListener(this);
		
		Base.info("v" + getDescription().getVersion() + " enabled");
	}
}
