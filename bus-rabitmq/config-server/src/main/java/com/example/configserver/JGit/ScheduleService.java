package com.example.configserver.JGit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.endpoint.RefreshBusEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScheduleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    LocalGitRepository localGitRepository;

    @Autowired
    RefreshBusEndpoint refreshBusEndpoint;

    private static Map<String, String> lastMap = new HashMap<>();

    /**
     * 调度待执行的任务序列
     */
    @Scheduled(fixedDelay = 10_000)
    public void scheduleTaskExecutor() {
        localGitRepository.forceRefresh();
        Map<String, String> currentMap = localGitRepository.branchList();
        if (lastMap.size() != currentMap.size()) {
            LOGGER.info("refresh from {} to {} ", lastMap, currentMap);
            lastMap = currentMap;
            refreshBusEndpoint.busRefresh();
            return;
        }
        for (String key : lastMap.keySet()) {
            if (!lastMap.getOrDefault(key, "").equals(currentMap.get(key))) {
                LOGGER.info("refresh from {} to {}", lastMap, currentMap);
                lastMap = currentMap;
                refreshBusEndpoint.busRefresh();
                return;
            }
        }
        lastMap = currentMap;
    }
}
