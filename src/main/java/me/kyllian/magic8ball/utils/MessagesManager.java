package me.kyllian.magic8ball.utils;

import me.kyllian.magic8ball.Magic8BallPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessagesManager {

    private Magic8BallPlugin plugin;

    public MessagesManager(Magic8BallPlugin plugin) {
        this.plugin = plugin;
    }

    public String colorTranslate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String getCooldownMessage(Player player) {
        long timeToGo = (plugin.getPlayerData(player).getDelayedTimestamp() - System.currentTimeMillis()) / 1000;
        return String.format(colorTranslate(plugin.getConfig().getString("Messages.Cooldown")), timeToGo);
    }

    public String getNoPermissionMessage() {
        return colorTranslate(plugin.getConfig().getString("Messages.NoPermissions"));
    }

    public String getUnknownArgumentMessage() {
        return colorTranslate(plugin.getConfig().getString("Messages.UnknownArgument"));
    }

    public String getAnswerMessage() {
        return String.format(colorTranslate(plugin.getConfig().getString("Messages.Answer")), plugin.getRandomAnswer());
    }

    public String getReloadMessage() {
        return colorTranslate(plugin.getConfig().getString("Messages.ReloadMessage"));
    }
}
