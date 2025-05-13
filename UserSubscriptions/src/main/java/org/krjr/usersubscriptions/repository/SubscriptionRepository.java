package org.krjr.usersubscriptions.repository;

import org.krjr.usersubscriptions.dto.SubscriptionCountDTO;
import org.krjr.usersubscriptions.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    Subscription findSubscriptionByServiceName(String serviceName);


    @Query(value = """ 
SELECT s.service_name, COUNT(s.id) as count FROM subscriptions s GROUP BY s.service_name ORDER BY count DESC LIMIT 3
""", nativeQuery = true)
    List<SubscriptionCountDTO> findTopSubscriptions();
}
