package me.cageydinosaur.portablevillagers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
	Main plugin;

	public Events(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof LivingEntity) {
			LivingEntity entity = e.getEntity();
			Location loc = entity.getLocation();
			if (entity.getType() == EntityType.VILLAGER) {
				entity.getKiller().getWorld().dropItem(loc, new ItemStack(Material.VILLAGER_SPAWN_EGG));
			} else if (entity.getType() == EntityType.ZOMBIE_VILLAGER) {
				entity.getKiller().getWorld().dropItem(loc, new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
			}
		}
	}

}
