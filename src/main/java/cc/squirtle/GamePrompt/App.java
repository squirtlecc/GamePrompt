package cc.squirtle.GamePrompt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import cc.squirtle.Entity.CmdResult;
import cc.squirtle.Entity.PluginEntity;
import cc.squirtle.GamePrompt.Commands.GamePromptCmd;
import cc.squirtle.GamePrompt.Listeners.PlayerListener;



public class App extends JavaPlugin {
    

    @Override
    public void onEnable() {
        InitInstance();

        if (PluginRegisterCmds() && PluginRisterEvents()) {
			PluginLoadMsgs();
		}

    }
    @Override
    public void onDisable() {
        CmdResult.ConsolePrint(CmdResult.SUCCESS("GamePrompt Plugins onDisable is called!") );
        //getLogger().info("[GamePrompt]"+"GamePrompt Plugins  onDisable is called!");
    }


    private void InitInstance(){
        PluginEntity.setPluginDescrption(this.getDescription());
        PluginEntity.setFileConfig(this.getConfig());
        // load the default configuration file to your plugin's folder
        //https://sodocumentation.net/bukkit/topic/6824/configuration-files
        saveDefaultConfig();
        reloadConfig();
    }


    private void PluginLoadMsgs(){
        CmdResult.ConsolePrint(CmdResult.NAME(Bukkit.getServer().getVersion()+"-----") );
        CmdResult.ConsolePrint(CmdResult.NAME(""+this.getDescription().getName()+" loaded!"));
        CmdResult.ConsolePrint(CmdResult.NOTICE(""+Bukkit.getServer().getVersion()+"-----") );
        CmdResult.ConsolePrint(CmdResult.INFO("---------------------------------") );
    }

    private boolean PluginRegisterCmds(){
        try {
            this.getCommand("gameprompt").setExecutor(new GamePromptCmd());
        } catch (Exception e) {
            CmdResult.ConsolePrint(CmdResult.FAILED("GamePrompt Plugins cant startup!") );
            return false;
        }
        return true;
        
    }

    private boolean PluginRisterEvents(){
        PlayerListener player_listener = new PlayerListener(this);
        //PluginManager pm = player_listener.RegisterListener();
        try {
            this.getServer().getPluginManager().registerEvents(player_listener, this);
        } catch (Exception e) {
            CmdResult.ConsolePrint(CmdResult.FAILED("GamePrompt Plugins cant startup!") );
            return false;
        }
        return true;
    }
}