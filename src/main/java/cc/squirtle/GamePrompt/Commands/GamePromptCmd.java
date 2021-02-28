package cc.squirtle.GamePrompt.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.squirtle.Entity.CmdResult;
import cc.squirtle.GamePrompt.Bean.PlayersEntity;

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

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("dl") || args[0].equalsIgnoreCase("deathlocation")){
                if(PlayersEntity.PLAYERS_DEATH_LOCATION.containsKey(ply.getUniqueId())){
                    CmdResult.PlayerPrint(ply, CmdResult.NOTICE(PlayersEntity.PLAYERS_DEATH_LOCATION.get(ply.getUniqueId())));
                }else{
                    CmdResult.PlayerPrint(ply, CmdResult.NOTICE("你并没有死亡过"));
                }
                
            }
        }

        return false;
        
    }
}
