package cc.squirtle.util

import cc.squirtle.entity.PluginConfig
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import java.util.*
import java.lang.*

object DealString {
    fun RanbowString(rawString: String?): String {
        val buffer = StringBuffer()
        var result: String
        if (Bukkit.getVersion().contains("1.16")) {
            //hex color
            //Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
            for (ch in rawString!!.toCharArray()) {
                val random_color =
                    "#" + java.lang.Long.toHexString(Math.round(7777777 * 2 - Math.random() * 7777777)?:0)
                buffer.append(ChatColor.of(random_color?:"").toString() + ch)
            }
            result = ChatColor.translateAlternateColorCodes('&', buffer.toString())
        } else {
            val r = Random()
            //boolean check_vailable = false;
            for (ch in rawString!!.toCharArray()) {
                val randomColour = PluginConfig.CHAT_COLOR[r.nextInt(21)] //You need to do the get random colour part ;)
                //bai(int)Math.random() * ConfigKV.CHAT_COLOR.length
                //chat_color total type = 21
                buffer.append(randomColour + ch)
            }
            result = buffer.toString()
        }
        return result
    }
}