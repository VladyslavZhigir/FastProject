package org.krjr.usersubscriptions.repository;

import org.krjr.usersubscriptions.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    Subscription findSubscriptionByServiceName(String serviceName);


    @Query("SELECT s.serviceName, COUNT(s) as count FROM Subscription s GROUP BY s.serviceName ORDER BY count DESC LIMIT 3")
    List<Subscription> findTopSubscriptions();
}
