package com.ymt.leetcode.map_set.logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 使用HashMap
 * @author yumingtao
 * @date 2022-03-02 20:29
 */
public class Logger {
    private final int interval = 10;
    private Map<String, Integer> logTimestampRecorder;

    public Logger() {
        this.logTimestampRecorder = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int lastTimestamp = logTimestampRecorder.getOrDefault(message, -1);
        if (lastTimestamp >= 0 && timestamp < lastTimestamp + interval) {
            return false;
        }
        logTimestampRecorder.put(message, timestamp);
        return true;
    }
}
