package com.alejandro.capstone_cassandra.controller;

import com.alejandro.capstone_cassandra.entity.UserActivity;
import com.alejandro.capstone_cassandra.service.UserActivityService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/activityLogs")
public class UserActivityController {

    private final UserActivityService userActivityService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserActivity>> getAllActivityLogsByUser(@PathVariable(name = "userId") UUID userId) {
        return ResponseEntity.ok(this.userActivityService.getAllActivityLogsByUser(userId));
    }

    @GetMapping("/{timestamp}/{userId}")
    public ResponseEntity<List<UserActivity>> getAllActivityLogsByUserAndTimestamp(@PathVariable("timestamp") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime timestamp,
                                                                              @PathVariable(name = "userId") UUID userId) {
        return ResponseEntity.ok(this.userActivityService.getAllActivityLogsByByUserAndTimestamp(userId, timestamp));
    }

    @GetMapping("/recent/{userId}")
    public ResponseEntity<List<UserActivity>> getRecentActivitiesByUser(@PathVariable(name = "userId") UUID userId) {
        return ResponseEntity.ok(this.userActivityService.getRecentActivitiesByUser(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserActivity>> getRecentActivitiesByUser() {
        return ResponseEntity.ok(this.userActivityService.getAllActivityLogs());
    }

    @PostMapping("/")
    public ResponseEntity<UserActivity> createUserActivity(@RequestBody UserActivity userActivity) {
        return ResponseEntity.ok(this.userActivityService.saveUserActivity(userActivity));
    }
}
