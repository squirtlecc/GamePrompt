package cc.squirtle.GamePrompt.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayersEntity<T> {
    public static Map<UUID,String> PLAYERS_DEATH_LOCATION;
    static{
        PLAYERS_DEATH_LOCATION = new HashMap<>();
    }

}
