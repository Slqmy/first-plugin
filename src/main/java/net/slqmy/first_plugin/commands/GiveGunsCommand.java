package net.slqmy.first_plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import net.slqmy.first_plugin.utility.Utility;

public final class GiveGunsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command,
			@NotNull final String label,
			@NotNull final String[] args) {
		if (args.length != 0) {
			return false;
		}

		if (sender instanceof Player) {
			final Player player = (Player) sender;

			final PlayerInventory playerInventory = player.getInventory();

			final ItemStack pistol = new ItemStack(Material.WOODEN_HOE);
			final ItemStack shotgun = new ItemStack(Material.STONE_HOE);
			final ItemStack miniGun = new ItemStack(Material.IRON_HOE);
			final ItemStack gatlingGun = new ItemStack(Material.GOLDEN_HOE);
			final ItemStack poisonLauncher = new ItemStack(Material.DIAMOND_HOE);
			final ItemStack rocketLauncher = new ItemStack(Material.NETHERITE_HOE);

			final ItemMeta pistolMeta = pistol.getItemMeta();
			final ItemMeta shotGunMeta = shotgun.getItemMeta();
			final ItemMeta miniGunMeta = miniGun.getItemMeta();
			final ItemMeta gatlingGunMeta = gatlingGun.getItemMeta();
			final ItemMeta poisonLauncherMeta = poisonLauncher.getItemMeta();
			final ItemMeta rocketLauncherMeta = rocketLauncher.getItemMeta();

			pistolMeta.setDisplayName(ChatColor.GOLD + "Pistol");
			shotGunMeta.setDisplayName(ChatColor.BLUE + "Shotgun");
			miniGunMeta.setDisplayName(ChatColor.WHITE + "Mini-gun");
			gatlingGunMeta.setDisplayName(ChatColor.DARK_BLUE.toString() + ChatColor.BOLD + "Gatling gun");
			poisonLauncherMeta.setDisplayName(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Poison launcher");
			rocketLauncherMeta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Rocket launcher");

			pistol.setItemMeta(pistolMeta);
			shotgun.setItemMeta(shotGunMeta);
			miniGun.setItemMeta(miniGunMeta);
			gatlingGun.setItemMeta(gatlingGunMeta);
			poisonLauncher.setItemMeta(poisonLauncherMeta);
			rocketLauncher.setItemMeta(rocketLauncherMeta);

			playerInventory.addItem(pistol);
			playerInventory.addItem(shotgun);
			playerInventory.addItem(miniGun);
			playerInventory.addItem(gatlingGun);
			playerInventory.addItem(poisonLauncher);
			playerInventory.addItem(rocketLauncher);
		} else {
			Utility.log("/give-guns is a player-only command!");

			return false;
		}

		return true;
	}
}
