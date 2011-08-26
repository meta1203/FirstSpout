package meta1203.FirstSpout;

import java.io.File;
import java.util.HashMap;

import net.minecraft.server.Item;
import net.minecraft.server.ItemBlock;

import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * FirstSpout for Bukkit
 *
 * @author meta1203
 */
public class FirstSpout extends JavaPlugin {
    private final FirstSpoutPlayerListener playerListener = new FirstSpoutPlayerListener(this);
    private final FirstSpoutBlockListener blockListener = new FirstSpoutBlockListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    BlockVar block = new BlockVar(101, net.minecraft.server.Material.WOOD, 1F);
    
    public FirstSpout() {
        // TODO: Place any custom initialisation code here

        // NOTE: Event registration should be done in onEnable not here as all events are unregistered when a plugin is disabled
    }

   

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_LOGIN, playerListener , Priority.Low, this);
        Item.byId[101] = new ItemBlock(101-256);
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled
    	Item.byId[101] = null;
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

