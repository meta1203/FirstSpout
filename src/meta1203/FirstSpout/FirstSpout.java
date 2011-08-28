package meta1203.FirstSpout;

import java.io.File;
import java.util.HashMap;

import net.minecraft.server.Item;
import net.minecraft.server.ItemBlock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.packet.PacketBlockTextures;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 * FirstSpout for Bukkit
 *
 * @author meta1203
 */
public class FirstSpout extends JavaPlugin {
    private final FirstSpoutPlayerListener playerListener = new FirstSpoutPlayerListener(this);
    private final FirstSpoutBlockListener blockListener = new FirstSpoutBlockListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public BlockVar jumpBlock;
    int jumpID = SpoutManager.getCustomBlockManager().createCustomBlock((byte)22, new int[] {4,42,4,4,4,4}, 32);
    public FirstSpout() {
        // TODO: Place any custom initialisation code here

        // NOTE: Event registration should be done in onEnable not here as all events are unregistered when a plugin is disabled
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player)) {
    		return false;
    	}
    	Player player = (Player)sender;
    	SpoutPlayer scp = SpoutManager.getPlayer(player);
    	scp.sendPacket(new PacketBlockTextures(101, new int[] {4,42,4,4,4,4}, (byte)7));
    	return true;
    }

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events
    	 jumpBlock = new BlockVar(jumpID, net.minecraft.server.Material.WOOD, 0.5F);
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        // Item.byId[101] = new ItemBlock(101 - 256);
        Item.byId[jumpID] = new ItemBlock(jumpID - 256);
        // pm.registerEvent(Event.Type.PLAYER_LOGIN, playerListener , Priority.Low, this);
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    public void onDisable() {

        // NOTE: All registered events are automatically unregistered when a plugin is disabled
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        System.out.println("Goodbye world!");
    }
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}

