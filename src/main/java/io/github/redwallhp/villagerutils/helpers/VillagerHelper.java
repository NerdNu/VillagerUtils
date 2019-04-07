package io.github.redwallhp.villagerutils.helpers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Career;
import org.bukkit.util.Vector;

public class VillagerHelper {

    /**
     * Get the villager that the player is looking at
     * 
     * @param player The player to check for
     * @return Villager entity or null
     */
    public static Villager getVillagerInLineOfSight(Player player) {
        List<Entity> entities = player.getNearbyEntities(5, 1, 5);
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity ent = iterator.next();
            if (!(ent instanceof Villager))
                iterator.remove();
        }
        for (Block block : player.getLineOfSight(null, 6)) {
            if (block.getType() != Material.AIR)
                break; // view is obstructed
            for (Entity ent : entities) {
                Vector b = block.getLocation().toVector();
                Vector head = ent.getLocation().toVector().add(new Vector(0, 1, 0));
                Vector foot = ent.getLocation().toVector();
                if (head.isInSphere(b, 1.25) || foot.isInSphere(b, 1.25)) {
                    return (Villager) ent;
                }
            }
        }
        return null;
    }

    public static Villager.Career getCareerFromString(String key) {
        try {
            return Villager.Career.valueOf(key.toUpperCase());
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Return a sorted list of all career names in lower case.
     * 
     * @return a sorted list of all career names in lower case.
     */
    public static List<String> getCareerNames() {
        return Arrays.asList(Career.values()).stream()
        .map(c -> c.name().toLowerCase())
        .sorted()
        .collect(Collectors.toList());
    }

}
