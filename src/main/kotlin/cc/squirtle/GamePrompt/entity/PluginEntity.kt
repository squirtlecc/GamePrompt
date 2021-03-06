package cc.squirtle.GamePrompt.entity

import cc.squirtle.GamePrompt.App
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.PluginDescriptionFile

/**
 * Universal variable and method storage
 */
object PluginEntity {

    var INSTANCE: App? = null
	var PLUGIN_DESCFILE: PluginDescriptionFile? = null
	var FILE_CONFIG: FileConfiguration? = null
    var MUIL_FILECONFIG: MutableMap<String, FileConfiguration>? = null
}