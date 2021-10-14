package org.namespace.bangui.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd ,String commandLabel, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(p.hasPermission("bangui.ban")) {

                ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());

                Inventory bangui = Bukkit.createInventory(p, 64, ChatColor.BLUE + "Player List");

                for(int i=0; i < list.size(); i++) {

                    ItemStack ph = new ItemStack(Material.PLAYER_HEAD, 1);
                    ItemMeta im = ph.getItemMeta();
                    im.setDisplayName(list.get(i).getDisplayName());
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + (int) list.get(i).getHealth());
                    lore.add(ChatColor.GOLD + "XP: " + ChatColor.AQUA + list.get(i).getExp());
                    im.setLore(lore);
                    ph.setItemMeta(im);

                    bangui.addItem(ph);

                }

                p.openInventory(bangui);

            }

        }

        return true;
    }
}
