package me.kyllian.magic8ball;

import me.kyllian.magic8ball.commands.Magic8BallCommand;
import me.kyllian.magic8ball.listeners.AsyncPlayerChatListener;
import me.kyllian.magic8ball.listeners.PlayerQuitListener;
import me.kyllian.magic8ball.utils.ConfigManager;
import me.kyllian.magic8ball.utils.MessagesManager;
import me.kyllian.magic8ball.utils.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Magic8BallPlugin extends JavaPlugin {

    private List<String> answers;
    private HashMap<UUID, PlayerData> playerDataHashMap;
    private MessagesManager messageUtils;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        answers = getConfig().getStringList("Answers");
        playerDataHashMap = new HashMap<>();

        new AsyncPlayerChatListener(this);
        new PlayerQuitListener(this);

        getCommand("magic8ball").setExecutor(new Magic8BallCommand(this));

        messageUtils = new MessagesManager(this);
        configManager = new ConfigManager(this);
    }

    public PlayerData getPlayerData(Player player) {
        return playerDataHashMap.computeIfAbsent(player.getUniqueId(), f -> new PlayerData(player.getUniqueId()));
    }

    public void removePlayerData(Player player) {
        playerDataHashMap.remove(player.getUniqueId());
    }

    public String getRandomAnswer() {
        return answers.get(ThreadLocalRandom.current().nextInt(answers.size()));
    }

    public MessagesManager getMessageUtils() {
        return messageUtils;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
