package me.kyllian.magic8ball.utils;

import java.util.UUID;

public class PlayerData {

    public PlayerData (UUID uuid) {
        this.uuid = uuid;
    }

    protected UUID uuid;
    protected long delayedTimestamp;

    public long getDelayedTimestamp() {
        return delayedTimestamp;
    }

    public void setDelayedTimestamp(long delayedTimestamp) {
        this.delayedTimestamp = delayedTimestamp;
    }
}
