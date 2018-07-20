package me.kyllian.magic8ball.listeners;

import me.kyllian.magic8ball.Magic8BallPlugin;
import me.kyllian.magic8ball.utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private Magic8BallPlugin plugin;

    public AsyncPlayerChatListener(Magic8BallPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!event.getMessage().startsWith(plugin.getConfigManager().getPrefix())) return;
        if (!player.hasPermission("magic8ball.use")) return;
        PlayerData playerData = plugin.getPlayerData(player);
        if (playerData.getDelayedTimestamp() > System.currentTimeMillis() && plugin.getConfigManager().getDelayEnabled()) {
            player.sendMessage(plugin.getMessageUtils().getCooldownMessage(player));
            return;
        }
        if (plugin.getConfigManager().getDelayEnabled()) playerData.setDelayedTimestamp(System.currentTimeMillis() + plugin.getConfigManager().getDelay());
        Bukkit.broadcastMessage(plugin.getMessageUtils().getAnswerMessage());
    }
}
