package cc.squirtle.GamePrompt.core.commands

import cc.squirtle.GamePrompt.entity.CmdResult
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.command.TabExecutor
import java.util.ArrayList




object CmdOptions: TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>,
    ): ArrayList<String> {
        var entityTypes = ArrayList<String>()
        when(args.size){
            1 -> {
                entityTypes = SubcmdOption()
            }
            2 -> {
                entityTypes = ThircmdOption(args[0])
            }
        }
        return entityTypes
    }

    fun SubcmdOption(): ArrayList<String> {
        val entityTypes = ArrayList<String>()
        entityTypes.add("list")
        entityTypes.add("set")
        entityTypes.add("deathmsg")
        return entityTypes
    }

    fun ThircmdOption(cmd :String): ArrayList<String> {
        val entityTypes = ArrayList<String>()
        when(cmd) {
            "set" -> {
                entityTypes.add("add")
                entityTypes.add("remove")
            }
//            else ->{
//                for(ply in Bukkit.getOnlinePlayers()){
//                    entityTypes.add(ply.name)
//                }
//            }
        }
        return entityTypes
    }

}