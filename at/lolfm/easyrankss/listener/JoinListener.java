package at.lolfm.easyrankss.listener;

import at.lolfm.easyrankss.main.MainClass;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private String prefix = MainClass.prefix;
    private String owner = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.owner"));
    private String admin = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.admin"));
    private String sup = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.supporter"));
    private String yt = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.youtuber"));
    private String mod = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.moderator"));
    private String dev = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.developer"));
    private String builder = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.builder"));
    private String guest = ChatColor.translateAlternateColorCodes('&', MainClass.cfg.getString("rank.guest"));

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§7[§a+§7] " + p.getDisplayName());
        if (p.hasPermission("ranks.owner")) {
            p.sendMessage(prefix + "Welcome back " + owner + "Owner §f" + p.getDisplayName() + "!");
            p.setPlayerListName(owner + "[Owner] §f" + p.getName());
        } else if (p.hasPermission("ranks.admin")) {
            p.sendMessage(prefix + "Welcome back " + admin + "Admin §f" + p.getDisplayName() + "!");
            p.setPlayerListName(admin + "[Admin] §f" + p.getName());
        } else if (p.hasPermission("ranks.supporter")) {
            p.sendMessage(prefix + "Welcome back " + sup + "Supporter §f" + p.getDisplayName() + "!");
            p.setPlayerListName(sup + "[Supporter] §f" + p.getName());
        } else if (p.hasPermission("ranks.mod")) {
            p.sendMessage(prefix + "Welcome back " + mod + "Moderator §f" + p.getDisplayName() + "!");
            p.setPlayerListName(mod + "[Moderator] §f" + p.getName());
        } else if (p.hasPermission("ranks.dev")) {
            p.sendMessage(prefix + "Welcome back " + dev + "Developer §f" + p.getDisplayName() + "!");
            p.setPlayerListName(dev + "[Developer] §f" + p.getName());
        } else if (p.hasPermission("ranks.builder")) {
            p.sendMessage(prefix + "Welcome back " + builder + "Builder §f" + p.getDisplayName() + "!");
            p.setPlayerListName(builder + "[Builder] §f" + p.getName());
        } else if (p.hasPermission("ranks.youtuber")) {
            p.sendMessage(prefix + "Welcome back " + yt + "YouTuber §f" + p.getDisplayName() + "!");
            p.setPlayerListName(yt + "[YouTuber] §f" + p.getName());
        } else {
            p.sendMessage("Welcome to the Server &a" + p.getDisplayName() + "!");
            p.setPlayerListName(guest + "[Guest] §f" + p.getName());
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("ranks.owner")) {
            e.setFormat(owner + "[Owner] §f%s: %s");
        } else if (p.hasPermission("ranks.admin")) {
            e.setFormat(admin + "[Admin] §f%s: %s");
        } else if (p.hasPermission("ranks.supporter")) {
            e.setFormat(sup + "[Supporter] §f%s: %s");
        } else if (p.hasPermission("ranks.mod")) {
            e.setFormat(mod + "[Moderator] §f%s: %s");
        } else if (p.hasPermission("ranks.dev")) {
            e.setFormat(dev + "[Developer] §f%s: %s");
        } else if (p.hasPermission("ranks.builder")) {
            e.setFormat(builder + "[Builder] §f%s: %s");
        } else if (p.hasPermission("ranks.youtuber")) {
            e.setFormat(yt + "[YouTuber] §f%s: %s");
        } else {
            e.setFormat(guest + "[Guest] §f%s: %s");
        }
    }
}
