package riyaya1528.paper.doubledrop;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class Drop implements Listener {

    @EventHandler
    public void onBreakDrop(BlockBreakEvent e) {
        World World =  e.getBlock().getWorld();
        Location Location = e.getBlock().getLocation();
        for(ItemStack item : e.getBlock().getDrops()) {
            DropItem(World,Location,item);
        }
    }
    @EventHandler
    public void onEntityDrop(EntityDropItemEvent e) {
        Location Location = e.getItemDrop().getLocation();
        World World = e.getItemDrop().getWorld();
        ItemStack Item = e.getItemDrop().getItemStack();

        DropItem(World,Location,Item);
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e) {
        Location Location = e.getItemDrop().getLocation();
        World World = e.getItemDrop().getWorld();
        ItemStack Item = e.getItemDrop().getItemStack();

        DropItem(World,Location,Item);
    }
    @EventHandler
    public void onEntityExplode(BlockExplodeEvent e) {
        World World = e.getBlock().getWorld();
        Location Location = e.getBlock().getLocation();
        for(ItemStack Item : e.getBlock().getDrops()) {
            DropItem(World,Location,Item);
        }
    }
    @EventHandler
    public void onEntityDrop(EntityDeathEvent e) {
        World World = e.getEntity().getWorld();
        Location Location = e.getEntity().getLocation();
        for(ItemStack Item : e.getDrops()) {
            DropItem(World,Location,Item);
        }
    }

    public static void DropItem(World World,Location Location,ItemStack DropItem) {
        int n = 0;
        while (n < DoubleDrop.Drop()){
            n = n + 1;
            World.dropItemNaturally(Location,DropItem);
        }
    }
}