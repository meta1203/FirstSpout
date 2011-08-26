package meta1203.FirstSpout;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * FirstSpout block listener
 * @author meta1203
 */
public class FirstSpoutBlockListener extends BlockListener {
    private final FirstSpout plugin;

    public FirstSpoutBlockListener(final FirstSpout plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
