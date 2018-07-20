package me.kyllian.magic8ball.utils;

import me.kyllian.magic8ball.Magic8BallPlugin;

public class ConfigManager {

    private Magic8BallPlugin plugin;

    public ConfigManager(Magic8BallPlugin plugin) {
        this.plugin = plugin;
    }

    public String getPrefix() {
        return plugin.getConfig().getString("Settings.MessagePrefix");
    }

    public boolean isDelayEnabled() {
        return plugin.getConfig().getBoolean("Settings.Delay.Enabled");
    }

    public long getDelay() {
        return plugin.getConfig().getLong("Settings.Delay.Delay");
    }
}
