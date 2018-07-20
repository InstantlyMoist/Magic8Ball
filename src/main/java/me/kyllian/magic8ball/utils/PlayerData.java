package me.kyllian.magic8ball.utils;

import java.util.UUID;

public class PlayerData {

    private UUID uuid;
    private long delayedTimestamp;

    public PlayerData (UUID uuid) {
        this.uuid = uuid;
    }

    public long getDelayedTimestamp() {
        return delayedTimestamp;
    }

    public void setDelayedTimestamp(long delayedTimestamp) {
        this.delayedTimestamp = delayedTimestamp;
    }
}
