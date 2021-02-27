package cc.squirtle.GamePrompt.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.squirtle.Entity.CmdResult;

public class GamePromptCmd implements CommandExecutor{
        // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(! (sender instanceof Player)) {
            return true;
        }
        Player ply = (Player) sender;
        if(args.length == 0){
            // when command no args
            CmdResult.PlayerPrint(ply, CmdResult.RAINBOW("GamePrompt Plugins is called!") );
            return true;
        }
        return false;
        
    }
}
