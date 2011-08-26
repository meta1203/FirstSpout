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
    
    public void onPlayerLogin(PlayerLoginEvent event) {
    	SpoutPlayer scp = SpoutManager.getPlayer(event.getPlayer());
    	PacketBlockTextures pbt = new PacketBlockTextures(101, new int[] {1,2,3,4,5,6}, (byte)7, (byte)22);
    	System.out.println("Player joined, sending block info:");
    	if (pbt == null) {
    		System.out.println("Huh?");
    		return;
    	}
    	if (scp == null) {
    		System.out.println("Huh 2.0!");
    		return;
    	}
    	
    	scp.sendPacket(pbt);
    }
}

