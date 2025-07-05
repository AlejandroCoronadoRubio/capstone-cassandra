package com.alejandro.capstone_cassandra.repository;

import com.alejandro.capstone_cassandra.entity.UserActivity;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserActivityRepository extends CassandraRepository<UserActivity, UUID> {
    //@Query(value = "SELECT * FROM user_activity WHERE userId = :userId AND timestamp = :timestamp; ")
    @Consistency(DefaultConsistencyLevel.LOCAL_ONE)
    List<UserActivity> findAllByUserId(UUID userId);
    @Consistency(DefaultConsistencyLevel.LOCAL_ONE)
    List<UserActivity> findAllByUserIdAndTimestamp(UUID userId, LocalDateTime timestamp);
    @Consistency(DefaultConsistencyLevel.LOCAL_ONE)
    List<UserActivity> findAllByUserIdAndTimestampAfter(UUID userId, LocalDateTime timestamp);
    @Consistency(DefaultConsistencyLevel.ALL)
    void deleteByUserIdAndTimestampBefore(UUID userId, LocalDateTime timestamp);
}