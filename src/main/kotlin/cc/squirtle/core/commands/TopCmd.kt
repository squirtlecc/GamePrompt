package cc.squirtle.GamePrompt.Commands


import cc.squirtle.entity.CmdResult
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class TopCmd : CommandExecutor {
    // This method is called, when somebody uses our command
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            return true
        }
        val ply: Player = sender
        if (args.isEmpty()) {
            // when command no args
            CmdResult.Send2Player(ply, CmdResult.RAINBOW("GamePrompt Plugins is called!"))
            return true
        }
//        if (args.size == 1) {
//            if (args[0].equals("dl", ignoreCase = true) || args[0].equals("deathlocation", ignoreCase = true)) {
//                if (PlayersEntity.PLAYERS_DEATH_LOCATION.containsKey(ply.uniqueId)) {
//                    CmdResult.PlayerPrint(ply, CmdResult.NOTICE(PlayersEntity.PLAYERS_DEATH_LOCATION.get(ply.uniqueId)))
//                } else {
//                    CmdResult.PlayerPrint(ply, CmdResult.NOTICE("你并没有死亡过"))
//                }
//            }
//        }
        return false
    }
}