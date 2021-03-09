package cc.squirtle.GamePrompt.core.listeners

import cc.squirtle.GamePrompt.App
import cc.squirtle.GamePrompt.entity.CmdResult
import cc.squirtle.GamePrompt.entity.PluginEntity
import net.md_5.bungee.api.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import org.bukkit.plugin.PluginManager
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MotdListener(instance: App)  : Listener{
    private val instance: App = instance
    fun RegisterListener(): PluginManager {
        val pm = instance.server.pluginManager
        pm.registerEvents(this, instance)
        //pm.registerEvent(PlayerJoinEvents,this,EventPriority.LOW,Player)
        return pm
    }
    @EventHandler(priority = EventPriority.NORMAL)
    fun onServerListPing(event: ServerListPingEvent) {

      if(PluginEntity.FILE_CONFIG!!.getString("motd.enabled") == "true"){
          var line_1 :String = ""
          var line_2 :String = ""
          val motd_main = PluginEntity.FILE_CONFIG!!.getList("motd.display.main")
          val motd_intro = PluginEntity.FILE_CONFIG!!.getList("motd.display.intro")

          line_1 = motd_main?.get((0..motd_main.size-1).random()).toString() ?: "MineCraft"
          line_1 = ChatColor.translateAlternateColorCodes('&', line_1)
          line_2 = motd_intro?.get((0..motd_intro.size-1).random()).toString()
          line_2 = ChatColor.translateAlternateColorCodes('&', line_2)

          //CmdResult.INFO(result).Send2Console()
          event.motd = line_1 + "\n " + line_2


      }

    }
}