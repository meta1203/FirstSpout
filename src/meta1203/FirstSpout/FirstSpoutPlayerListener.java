package meta1203.FirstSpout;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.packet.PacketBlockTextures;
import org.getspout.spoutapi.packet.PacketItemName;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 * Handle events for all Player related events
 * @author meta1203
 */
public class FirstSpoutPlayerListener extends PlayerListener {
    private final FirstSpout plugin;

    public FirstSpoutPlayerListener(FirstSpout instance) {
        plugin = instance;
    }
    
    //Insert Player related code here
}

