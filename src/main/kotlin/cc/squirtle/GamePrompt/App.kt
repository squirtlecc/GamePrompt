package cc.squirtle.GamePrompt

import cc.squirtle.GamePrompt.core.commands.TopCmd
import cc.squirtle.GamePrompt.core.listeners.PlayerListener
import cc.squirtle.entity.CmdResult
import cc.squirtle.entity.PluginEntity

import org.bukkit.Bukkit

import org.bukkit.plugin.java.JavaPlugin



class App : JavaPlugin()  {

    //constructor(): super()

    /* Constructor used for tests. */
//    internal constructor(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File)
//            : super(loader, description, dataFolder, file)
    companion object{

    }


    override fun onEnable(){

        InitInstance()
        PluginLoadMsgs()
        PluginRegisterEvents()
        this.getCommand("gameprompt")?.setExecutor(TopCmd())
        //
//        if (PluginRegisterCmds() && PluginRegisterEvents()) {
//            PluginLoadMsgs()
//        }
        //Bukkit.getConsoleSender().sendMessage(Entity.SUCCESS("data").title)
    }

    override fun onDisable() {
        SendMsgOnDisable()
    }

    /**
     * init all config and setting in this function
     */
    private fun InitInstance(){

        PluginEntity.INSTANCE = this
        PluginEntity.PLUGIN_DESCFILE = this.description
        PluginEntity.FILE_CONFIG = this.config

        // load the default configuration file to your plugin's folder
        //https://sodocumentation.net/bukkit/topic/6824/configuration-files

        this.saveDefaultConfig()
        this.reloadConfig()
    }

    /**
     * register all command in this function
     */
    private fun PluginRegisterCmds(): Boolean {
        try {
            getCommand("gameprompt")?.setExecutor(TopCmd())
            CmdResult.SUCCESS(getCommand("gameprompt").toString())
        } catch (e: Throwable) {
            CmdResult.FAILED("GamePrompt Plugins cant Register Commands!").Send2Console()
            return false
        }
        return true
    }

    /**
     * register all events and listener in this function
     */
    private fun PluginRegisterEvents(): Boolean{

        try {
            PlayerListener(this).RegisterListener()
            //this.server.pluginManager.registerEvents(PlayerListener(this),this)
        }catch (e: Throwable){
            println(e)
            CmdResult.FAILED("GamePrompt Plugin cant Register Events").Send2Console()
            return false
        }
        return true
    }

    /**
     * when plugins successful loading, console to remind messages
     */
    private fun PluginLoadMsgs(){
        CmdResult.SUCCESS("Plugin Enable now").Send2Console()
        CmdResult.SUCCESS("Minecraft Version: ${Bukkit.getBukkitVersion()}").Send2Console()

    }

    /**
     * when plugins disable ,to print messages
     */
    private fun SendMsgOnDisable(){
        CmdResult.FAILED("Plugin Disable now").Send2Console()
    }

}