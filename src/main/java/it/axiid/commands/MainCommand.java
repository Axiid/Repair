package it.axiid.commands;

import it.axiid.Repair;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        
        if(!(sender instanceof Player)){
         return false;   
        }

        FileConfiguration config = Repair.getInstance().getConfig();
        
        if(!(sender instanceof Player)) {
            sender.sendMessage("Non puoi fare questo da console.");
        }
        
        Player p = (Player) sender;
        
        if(p.hasPermission("repair.use")) {
            if(!(p.getItemInHand().getType() == Material.AIR)) {
                if(p.getItemInHand().getDurability() != 0) {

                    p.getItemInHand().setDurability((short)0);
                    p.sendMessage(chatFormat(config.getString("repaired")));

                }else {
                    p.sendMessage(chatFormat(config.getString("cannot-repair")));
                }
            }else {
                p.sendMessage(chatFormat(config.getString("cannot-repair")));
            }

        }else {
            p.sendMessage(chatFormat(config.getString("no-permissions")));
        }
        return true;
    }

    public static String chatFormat(final String path) {
        return ChatColor.translateAlternateColorCodes('&', path);
    }
}
