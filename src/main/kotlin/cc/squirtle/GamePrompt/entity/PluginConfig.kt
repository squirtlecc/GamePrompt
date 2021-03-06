package cc.squirtle.GamePrompt.entity

object PluginConfig {
    val PLUGIN_NAME: String?
    val PLUGIN_VERSION: String?
    val CHAT_COLOR: Array<String>

    init {
        PLUGIN_NAME = "PluginName"
        PLUGIN_VERSION = "PluginVersion"
        // &0 black do not using
        CHAT_COLOR = arrayOf(
            "&r",
            "&1",
            "&2",
            "&3",
            "&4",
            "&5",
            "&6",
            "&7",
            "&8",
            "&9",
            "&a",
            "&b",
            "&c",
            "&d",
            "&e",
            "&f",
            "&l",
            "&m",
            "&n",
            "&o",
            "&r"
        )
    }
}