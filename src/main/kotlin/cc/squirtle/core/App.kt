package cc.squirtle.core

import cc.squirtle.entity.CmdResult
import cc.squirtle.entity.PluginEntity

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class App :JavaPlugin() {
    companion object{

    }


    override fun onEnable(){
        InitInstance()
        PluginLoadMsgs()
        //Bukkit.getConsoleSender().sendMessage(Entity.SUCCESS("data").title)
    }

    override fun onDisable() {
        SendMsgOnDisable()
    }


    fun InitInstance(){

        PluginEntity.INSTANCE = this
        PluginEntity.PLUGIN_DESCFILE = this.description
        PluginEntity.FILE_CONFIG = this.config

        // load the default configuration file to your plugin's folder
        //https://sodocumentation.net/bukkit/topic/6824/configuration-files

        this.saveDefaultConfig()
        this.reloadConfig()
    }

    fun PluginLoadMsgs(){
        CmdResult.SUCCESS("Plugin Enable now").Send2Console()
        CmdResult.SUCCESS("Minecraft Version: ${Bukkit.getBukkitVersion()}").Send2Console()

    }

    fun SendMsgOnDisable(){
        CmdResult.FAILED("Plugin Disable now").Send2Console()
    }

}