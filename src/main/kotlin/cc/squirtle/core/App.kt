package cc.squirtle.core

import cc.squirtle.GamePrompt.Commands.TopCmd
import cc.squirtle.GamePrompt.Listeners.PlayerListener
import cc.squirtle.entity.CmdResult
import cc.squirtle.entity.PluginEntity

import org.bukkit.Bukkit
import org.bukkit.configuration.Configuration
import org.bukkit.plugin.java.JavaPlugin

import java.lang.Exception


class App :JavaPlugin() {
    companion object{

    }


    override fun onEnable(){
        InitInstance()
        if (PluginRegisterCmds() && PluginRegisterEvents()) {
            PluginLoadMsgs()
        }
        //Bukkit.getConsoleSender().sendMessage(Entity.SUCCESS("data").title)
    }

    override fun onDisable() {
        SendMsgOnDisable()
    }


    private fun InitInstance(){

        PluginEntity.INSTANCE = this
        PluginEntity.PLUGIN_DESCFILE = this.description
        PluginEntity.FILE_CONFIG = this.config

        // load the default configuration file to your plugin's folder
        //https://sodocumentation.net/bukkit/topic/6824/configuration-files

        this.saveDefaultConfig()
        this.reloadConfig()
    }

    private fun PluginRegisterCmds(): Boolean {
        try {
            this.getCommand("gameprompt")?.setExecutor(TopCmd())
        } catch (e: Throwable) {
            CmdResult.FAILED("GamePrompt Plugins cant startup!").Send2Console()
            return false
        }
        return true
    }

    private fun PluginRegisterEvents(): Boolean{
        val player_listener: PlayerListener = PlayerListener(this)
        try {
            player_listener.RegisterListener()
            //this.server.pluginManager.registerEvents(player_listener,this)
        }catch (e: Throwable){
            CmdResult.FAILED("GamePrompt Plugin cant Register Events").Send2Console()
            return false
        }
        return true
    }

    private fun PluginLoadMsgs(){
        CmdResult.SUCCESS("Plugin Enable now").Send2Console()
        CmdResult.SUCCESS("Minecraft Version: ${Bukkit.getBukkitVersion()}").Send2Console()

    }

    private fun SendMsgOnDisable(){
        CmdResult.FAILED("Plugin Disable now").Send2Console()
    }

}