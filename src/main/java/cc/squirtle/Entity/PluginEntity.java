package cc.squirtle.Entity;

import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
/**
 * Universal variable and method storage
 */
public class PluginEntity {
    public static PluginEntity instance;
    public static PluginDescriptionFile pluginDescrption;
	public static FileConfiguration fileConfig;
	public static Map<String, FileConfiguration> muiltFileConfig;
    public PluginEntity(){

    }

	public static PluginEntity getInstance() {
		return instance;
	}

	public static void setInstance(PluginEntity instance) {
		PluginEntity.instance = instance;
	}

	public static PluginDescriptionFile getPluginDescrption() {
		return pluginDescrption;
	}

	public static void setPluginDescrption(PluginDescriptionFile pluginDescrption) {
		PluginEntity.pluginDescrption = pluginDescrption;
	}

	public static FileConfiguration getFileConfig() {
		return fileConfig;
	}

	public static void setFileConfig(FileConfiguration fileConfig) {
		PluginEntity.fileConfig = fileConfig;
	}

	public static Map<String, FileConfiguration> getMuiltFileConfig() {
		return muiltFileConfig;
	}

	public static void setMuiltFileConfig(Map<String, FileConfiguration> muiltFileConfig) {
		PluginEntity.muiltFileConfig = muiltFileConfig;
	}



}
