package cc.squirtle.GamePrompt.core.commands


import cc.squirtle.GamePrompt.entity.CmdResult
import cc.squirtle.GamePrompt.entity.PlayersEntity
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


object MainCmd : CommandExecutor {


    // This method is called, when somebody uses our command
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            CmdResult.INFO("Console dont need prompt!").Send2Console()
            return true
        }
        val ply: Player = sender
        if (args.isEmpty()) {
            // when command no args
            CmdResult.RAINBOW("GamePrompt Plugins is called!").Send2Player(ply)
            return true
        }
        if (args.size == 1) {
            if (args[0].equals("dm", ignoreCase = true) || args[0].equals("deathmsg", ignoreCase = true)) {
                val death_msg = PlayersEntity.PLAYERS_DEATH_LOCATION.getOrElse(ply.uniqueId){ "没死过,看给你牛的..." }
                if (PlayersEntity.PLAYERS_DEATH_LOCATION.containsKey(ply.uniqueId)) {
                    CmdResult.INFO(death_msg).Send2Player(ply)
                } else {
                    CmdResult.INFO(death_msg).Send2Player(ply)
                }
                return true
            }
        }
        return false
    }


}