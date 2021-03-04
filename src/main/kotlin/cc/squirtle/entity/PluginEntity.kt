package cc.squirtle.entity

import cc.squirtle.GamePrompt.App
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.PluginDescriptionFile

/**
 * Universal variable and method storage
 */
object PluginEntity {

    var INSTANCE: App? = null
    @JvmStatic
	var PLUGIN_DESCFILE: PluginDescriptionFile? = null
    @JvmStatic
	var FILE_CONFIG: FileConfiguration? = null
    var MUIL_FILECONFIG: Map<String, FileConfiguration>? = null
}