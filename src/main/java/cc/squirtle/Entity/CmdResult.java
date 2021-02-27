package cc.squirtle.Entity;

import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class CmdResult<T> {
    private int type;
    private String title;
    private T data;

    //get server all setting info
    //public static App app;

    protected CmdResult(){

    }
    protected CmdResult(int type, String title, T data) {
        this.type = type;
        this.title = title;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CmdResult<T> SUCCESS(T data) {
        return new CmdResult<T>(ResType.SUCCESS.getType(), ResType.SUCCESS.getTitle(), data);
    }

    public static <T> CmdResult<T> FAILED(T data) {
        return new CmdResult<T>(ResType.FAILED.getType(), ResType.FAILED.getTitle(), data);
    }
    public static <T> CmdResult<T> NOTICE(T data) {
        return new CmdResult<T>(ResType.NOTICE.getType(), ResType.NOTICE.getTitle(), data);
    }

    public static <T> CmdResult<T> INFO(T data) {
        return new CmdResult<T>(ResType.INFO.getType(), ResType.INFO.getTitle(), data);
    }
    public static <T> CmdResult<T> NAME(T data) {

        return new CmdResult<T>(ResType.NAME.getType(), ResType.NAME.getTitle(), data);
    }

    public static <T> CmdResult<T> UNAVAIL(T data) {
        return new CmdResult<T>(ResType.UNAVAIL.getType(), ResType.UNAVAIL.getTitle(), data);
    }
    public static <T> CmdResult<T> RAINBOW(T data) {
        return new CmdResult<T>(ResType.RAINBOW.getType(), ResType.RAINBOW.getTitle(), data);
    }

    /**
     * print message to console
     * @param cmdResult
     */
    public static void ConsolePrint(CmdResult<String> cmdResult) {
        // result name 
        String result = cmdResult.toString();
        if(cmdResult.type ==  203) {
            //plugin name
            //GetPluginApp().getDescription().getName()
            result = result.replaceAll("%name%", PluginEntity.getPluginDescrption().getName());
        }else if(cmdResult.type == 102){
            //rainbow msg
            result = RanbowString(result);
        }
 
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', result));
    }

    /**
     * send Message to single-player
     * @param player
     * @param cmdResult
     */
    public static void PlayerPrint(Player player, CmdResult<String> cmdResult) {
        // result name 
        String result = cmdResult.toString();
        if(cmdResult.type ==  203) {
            //GetPluginApp().getDescription().getName()
            result = result.replaceAll("%name%", PluginEntity.getPluginDescrption().getName());
        }
        if(cmdResult.type == 102) {
            result = RanbowString(result);
        }
 
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', result));
    }

    /**
     * send  Message to mulit-player
     * @param players
     * @param cmdResult
     */
    public static void PlayerPrint(Collection<? extends Player> players, CmdResult<String> cmdResult) {
        // result name 
        for(Player ply : players) {
            PlayerPrint(ply,cmdResult);
        }
    }

    public static String RanbowString(String rawString){
        StringBuffer buffer = new StringBuffer();
        String result = "";
        if(Bukkit.getVersion().contains("1.16")) {
            //hex color
            //Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
           for(char ch :rawString.toCharArray()){
            String random_color= "#"+Long.toHexString(Math.round(7777777*2 - Math.random() * 7777777));
               buffer.append(ChatColor.of(random_color).toString() + ch);
           }
           result = ChatColor.translateAlternateColorCodes('&', buffer.toString());
        }else{
            Random r = new Random();
            //boolean check_vailable = false;
            for(char ch :rawString.toCharArray()){
                String randomColour = ConfigKV.CHAT_COLOR[r.nextInt(21)]; //You need to do the get random colour part ;)
                //bai(int)Math.random() * ConfigKV.CHAT_COLOR.length 
                //chat_color total type = 21
    
                buffer.append(randomColour + ch);
            }
            result = buffer.toString();
        }



        return result;
    }




	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

    @Override
    public String toString() {
        String result = "";
        if(title.length()>3){
            result = title+" : ";
            
        }
        result = result + data.toString();
        return result;
    }
}
