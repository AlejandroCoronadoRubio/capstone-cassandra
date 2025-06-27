package com.alejandro.capstone_cassandra.repository;

import com.alejandro.capstone_cassandra.entity.UserActivity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserActivityRepository extends CassandraRepository<UserActivity, UUID> {
    List<UserActivity> findAllByUserId(UUID userId);

    //@Query(value = "SELECT * FROM user_activity WHERE userId = :userId AND timestamp = :timestamp; ")
    List<UserActivity> findAllByUserIdAndTimestamp(UUID userId, LocalDateTime timestamp);
    List<UserActivity> findAllByUserIdAndTimestampAfter(UUID userId, LocalDateTime timestamp);
    void deleteByUserIdAndTimestampBefore(UUID userId, LocalDateTime timestamp);
}