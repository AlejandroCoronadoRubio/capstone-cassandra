package com.alejandro.capstone_cassandra.service;

import com.alejandro.capstone_cassandra.entity.UserActivity;
import com.alejandro.capstone_cassandra.repository.UserActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserActivityService {

    private final UserActivityRepository userActivityRepository;

    public List<UserActivity> getAllActivityLogsByUser(UUID userId) {
        return this.userActivityRepository.findAllByUserId(userId);
    }

    public List<UserActivity> getAllActivityLogsByByUserAndTimestamp(UUID userId, LocalDateTime timestamp) {
        return this.userActivityRepository.findAllByUserIdAndTimestamp(userId, timestamp);
    }

    public List<UserActivity> getRecentActivitiesByUser(UUID userId) {
        LocalDateTime timestamp = LocalDateTime.now().minusDays(7);
        return this.userActivityRepository.findAllByUserIdAndTimestampAfter(userId, timestamp);
    }

    public List<UserActivity> getAllActivityLogs() {
        return this.userActivityRepository.findAll();
    }

    public void deleteByUserIdAndTimestampBefore(UUID userId, LocalDateTime timestamp) {
        this.userActivityRepository.deleteByUserIdAndTimestampBefore(userId, timestamp);
    }

    public UserActivity saveUserActivity(UserActivity userActivity) {
        return this.userActivityRepository.save(userActivity);
    }
}
