package us.bones.firstplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class BobossCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        //diamond gear
        ItemStack dboots = new ItemStack(Material.DIAMOND_BOOTS);
        dboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack dleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        dleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack dchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        dchestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack dhelmat= new ItemStack(Material.DIAMOND_HELMET);
        dhelmat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack dsword= new ItemStack(Material.DIAMOND_SWORD);
        dsword.addEnchantment(Enchantment.DAMAGE_ALL, 4);

        Player player = (Player) sender;
        Zombie bob = player.getPlayer().getWorld().spawn((Location) player.getPlayer(), Zombie.class);

        bob.setCustomNameVisible(true);
        bob.setCustomName("Bobby 2");

        bob.getEquipment().setBoots(dboots);
        bob.getEquipment().setLeggings(dleggings);
        bob.getEquipment().setChestplate(dchestplate);
        bob.getEquipment().setHelmet(dhelmat);

        bob.getEquipment().setItemInMainHand(dsword);


        return true;
    }
}
