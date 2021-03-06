package cc.squirtle.GamePrompt.core.commands

import cc.squirtle.GamePrompt.entity.PluginEntity

object ManageCmds {
    fun RegisterCmds(cmd: String){

        when(cmd) {
            "gameprompt" -> {
                PluginEntity.INSTANCE!!.getCommand(cmd)!!.setExecutor(MainCmd)
                PluginEntity.INSTANCE!!.getCommand(cmd)!!.tabCompleter = CmdOptions
            }
        }

    }

}