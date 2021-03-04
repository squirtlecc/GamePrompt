package cc.squirtle.GamePrompt.core.events

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerJoinEvents : Event {
    private val handlers = HandlerList()
    override fun getHandlers(): HandlerList {
        return handlers
    }

    constructor(){

    }



}