package cc.squirtle.core.events

import cc.squirtle.entity.CmdResult
import cc.squirtle.entity.PluginEntity
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinEvents {
    @EventHandler(priority = EventPriority.LOWEST)
    fun PlayerJoinON(event: PlayerJoinEvent) {
        val player = event.player

        //get plugin config
        if (player.isOnline) {
            if (player.hasPlayedBefore()) {
                CmdResult.Send2Player(Bukkit.getOnlinePlayers(),
                    CmdResult.RAINBOW(PluginEntity.FILE_CONFIG!!.getString("join.broadcast.player-jin")!!
                        .replace("%playername%", player.name)))
            } else {
                CmdResult.Send2Player(player,
                    CmdResult.RAINBOW(PluginEntity.FILE_CONFIG!!.getString("join.broadcast.player-welcome")!!
                        .replace("%playername%", player.name)))
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
}