package cc.squirtle.GamePrompt.core.listeners

import cc.squirtle.GamePrompt.App
import cc.squirtle.GamePrompt.entity.CmdResult
import cc.squirtle.GamePrompt.entity.PlayersEntity
import cc.squirtle.GamePrompt.entity.PluginEntity
import org.bukkit.Bukkit

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.PluginManager

/**
 * Listener player event when they playing game
 * PlayerListener
 */
class PlayerListener(instance: App) : Listener {
    private val instance: App = instance

    companion object{
    }
    fun RegisterListener(): PluginManager {
        val pm = instance.server.pluginManager
        pm.registerEvents(PlayerListener(instance), instance)
        //pm.registerEvent(PlayerJoinEvents,this,EventPriority.LOW,Player)
        return pm
    }


    @EventHandler(priority = EventPriority.LOWEST)
    fun PlayerJoin(event: PlayerJoinEvent?) {
        val player = event!!.player

        //get plugin config
        if (player.isOnline) {
            if (player.hasPlayedBefore()) {
                CmdResult.RAINBOW(PluginEntity.FILE_CONFIG!!.getString("join.broadcast.player-join")!!
                    .replace("%playername%", player.name)).Send2Player(Bukkit.getOnlinePlayers())

            } else {
                CmdResult.RAINBOW(PluginEntity.FILE_CONFIG!!.getString("join.broadcast.player-welcome")!!
                    .replace("%playername%", player.name)).Send2Player(Bukkit.getOnlinePlayers())

            }
            /**
             * prompt server commands
             */
            val commands_list: List<Map<*, *>> = PluginEntity.FILE_CONFIG!!.getMapList("join.dispatch.commands")
            for ((_, value) in commands_list[0]) {
                CmdResult.Send2Player(player,
                    CmdResult.NOTICE(value.toString()))
            }
            /**
             * prompt server notices
             */
            val notices_list: List<Map<*, *>> = PluginEntity.FILE_CONFIG!!.getMapList("join.dispatch.notices")
            for ((_, value) in notices_list[0]) {
                CmdResult.Send2Player(player,
                    CmdResult.NOTICE(value.toString()))
            }
            return
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun PlayerQuit(event: PlayerQuitEvent?) {
        val ply = event!!.player
        if (ply.hasPlayedBefore()) {
            CmdResult.RAINBOW(PluginEntity.FILE_CONFIG!!.getString("join.broadcast.player-quit")!!
                .replace("%playername%", ply.name)).Send2Player(Bukkit.getOnlinePlayers())

            return
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    fun PlayerDeath(event: PlayerDeathEvent?) {
        val ply = event!!.entity
        //如果玩家在线 才给他发送消息
        if (ply.isOnline) {
            //to do
            val death_location = ply.location
            val death_locate =
                "(" + death_location.x.toInt() + ", " + death_location.y.toInt() + ", " + death_location.z
                    .toInt() + ")"
            val death_message = "于${death_location.world!!.name} 被 ${ply.lastDamageCause?.entityType?.name} 杀死在 ${death_locate}"
            // 向玩家发送上次死亡地点
            CmdResult.Send2Player(ply, CmdResult.NOTICE(" $death_message"))

            //TODO: add command to send last death place
            PlayersEntity.PLAYERS_DEATH_LOCATION[ply.uniqueId] = death_message
            return
        }
    }




}