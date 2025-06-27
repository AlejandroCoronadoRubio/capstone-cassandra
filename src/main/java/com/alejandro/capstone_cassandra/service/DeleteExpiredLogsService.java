package com.alejandro.capstone_cassandra.service;

import com.alejandro.capstone_cassandra.entity.UserActivity;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeleteExpiredLogsService {

    private final UserActivityService userActivityService;

    //@Scheduled(cron = "@midnight")
    @Scheduled(cron = "0 */1 * * * *")
    public void deleteExpiredActivityLogs() {

        LocalDateTime timestamp = LocalDateTime.now().minusDays(30);

        this.userActivityService
                .getAllActivityLogs()
                .stream()
                .map(UserActivity::getUserId).collect(Collectors.toSet())
                .forEach(userId -> this.userActivityService.deleteByUserIdAndTimestampBefore(userId, timestamp));
    }
}
