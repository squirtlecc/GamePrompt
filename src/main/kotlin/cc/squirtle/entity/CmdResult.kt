package cc.squirtle.entity

import cc.squirtle.util.DealString
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

class CmdResult<T>
    (type: Int?, title: String?, data: T?){
    private var type: Int? = type
    private var title: String? = title
    private var data: T? = data

    override fun toString():String {
        var msg :String
        when(this.type){
            203 -> {
                this.title = this.title!!.replace("%name%".toRegex(), PluginEntity.PLUGIN_DESCFILE!!.name)
                msg = "${this.title} ${this.data}"
            }
            102 -> {
                msg = "${this.title} ${this.data}"
                msg = DealString.RanbowString(msg)
            }
            else -> {
                msg = "${this.title} ${this.data}"
            }
        }

        return msg
    }

    /**
     * send message to console
     * ex:Entity.SUCCESS("success").Send2Console()
     */
    fun Send2Console(){
        var result = this.toString()
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', result))
    }



    /**
     * send message to console
     * ex:Entity.Send2Console(Entity.SUCCESS("success"))
     */
    fun <T> Send2Console(msg: CmdResult<T>){
        var result = msg.toString()
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', result))
    }





companion object {

    fun <T> SUCCESS(data: T): CmdResult<T> {
        return CmdResult(ResType.SUCCESS.type,ResType.SUCCESS.title,data)
    }

    fun <T> FAILED(data: T): CmdResult<T> {
        return CmdResult(ResType.FAILED.type,ResType.FAILED.title,data)
    }

    fun <T> NOTICE(data: T): CmdResult<T> {
        return CmdResult(ResType.NOTICE.type, ResType.NOTICE.title, data)
    }

    fun <T> INFO(data: T): CmdResult<T> {
        return CmdResult(ResType.INFO.type, ResType.INFO.title, data)
    }

    fun <T> NAME(data: T): CmdResult<T> {
        return CmdResult(ResType.NAME.type, ResType.NAME.title, data)
    }

    fun <T> UNAVAIL(data: T): CmdResult<T> {
        return CmdResult(ResType.UNAVAIL.type, ResType.UNAVAIL.title, data)
    }

    fun <T> RAINBOW(data: T): CmdResult<T> {
        return CmdResult(ResType.RAINBOW.type, ResType.RAINBOW.title, data)
    }

    /**
     * send Message to single-player
     * @param player
     * @param cmdResult
     */
    fun <T> Send2Player(player: Player, msg: CmdResult<T>) {
        // result name
        var result = msg.toString()
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', result))
    }

    /**
     * send  Message to mulit-player
     * @param players
     * @param cmdResult
     */
    fun <T> Send2Player(players: Collection<Player>, cmdResult: CmdResult<T>) {
        for (ply in players) {
            Send2Player(ply, cmdResult)
        }
    }


}



}
