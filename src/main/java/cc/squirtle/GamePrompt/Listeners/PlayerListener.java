package cc.squirtle.GamePrompt.Listeners;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

import cc.squirtle.Entity.CmdResult;
import cc.squirtle.Entity.PluginEntity;
import cc.squirtle.GamePrompt.App;
import cc.squirtle.GamePrompt.Bean.PlayersEntity;


/**
 * Listener player event when they playing game
 * PlayerListener
 */
public class PlayerListener implements Listener{
    
    public static App instance;
    public PlayerListener(){}
    public PlayerListener(App instance){
        PlayerListener.instance = instance;
    }



    @EventHandler(priority = EventPriority.LOWEST)
    public void PlayerJoinON(PlayerJoinEvent event){
        Player player = event.getPlayer();
        
        //get plugin config
        if(player.isOnline()){
            if(player.hasPlayedBefore()){
                CmdResult.PlayerPrint(Bukkit.getOnlinePlayers(), 
                CmdResult.RAINBOW(PluginEntity.getFileConfig().getString("join.broadcast.player-join").replaceAll("%playername%", player.getName())));

            }else{
                CmdResult.PlayerPrint(player, 
                CmdResult.RAINBOW(PluginEntity.getFileConfig().getString("join.broadcast.player-welcome").replaceAll("%playername%", player.getName())));
            }

            /**
             * prompt server commands
             */
            List<Map<?, ?>> commands_list = PluginEntity.getFileConfig().getMapList("join.dispatch.commands");
                for(Entry<?, ?> entry : commands_list.get(0).entrySet()){
                    CmdResult.PlayerPrint(player, 
                    CmdResult.NOTICE(entry.getValue().toString()));
                }
    
            /**
             * prompt server notices
             */
            List<Map<?, ?>> notices_list = PluginEntity.getFileConfig().getMapList("join.dispatch.notices");
                for(Entry<?, ?> entry : notices_list.get(0).entrySet()){
                    CmdResult.PlayerPrint(player, 
                    CmdResult.NOTICE(entry.getValue().toString()));
                }
            return;
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void PlayerQuit(PlayerQuitEvent event){
        Player ply = event.getPlayer();

        if(ply.hasPlayedBefore()){
            CmdResult.PlayerPrint(Bukkit.getOnlinePlayers(), 
            CmdResult.NOTICE(PluginEntity.getFileConfig().getString("join.broadcast.player-quit").replaceAll("%playername%", ply.getName())));

            return;
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void PlayerDeath(PlayerDeathEvent event){
        Player ply = event.getEntity();
        //如果玩家在线 才给他发送消息
        if(ply.isOnline()){
            //to do 
            Location death_location = ply.getLocation();
            String death_locate = "("+(int)death_location.getX()+", "+(int)death_location.getY()+", "+(int)death_location.getZ()+")";
            String death_message = death_location.getWorld().getName() +","+death_locate;
            // 向玩家发送上次死亡地点
            CmdResult.PlayerPrint(ply, CmdResult.NOTICE("死亡地点: "+death_message));
            PlayersEntity.PLAYERS_DEATH_LOCATION.put(ply.getUniqueId(),"上次的死亡地点: "+death_message);
            return;
        }
    }


    public PluginManager RegisterListener(){
        PluginManager pm = instance.getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(instance), instance);
        return pm;
    }
    
}