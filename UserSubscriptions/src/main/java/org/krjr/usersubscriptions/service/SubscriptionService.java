package org.krjr.usersubscriptions.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.krjr.usersubscriptions.dto.SubscriptionDTO;
import org.krjr.usersubscriptions.entity.Subscription;
import org.krjr.usersubscriptions.entity.User;
import org.krjr.usersubscriptions.repository.SubscriptionRepository;
import org.krjr.usersubscriptions.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Transactional
    public Subscription addSubscription(Long userId, Subscription sub) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        log.info("Adding subscription for User : {}", user.getEmail());
        sub.setUser(user);
        sub.setCreatedAt(LocalDateTime.now());
        return subscriptionRepository.save(sub);
    }

    public List<Subscription> getUserSubscriptions(Long userId) {
        log.info("Getting subscriptions for userId: {}", userId);
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
        if (subscriptions.isEmpty() || subscriptions == null) {
            throw new RuntimeException("No subscriptions found for user with ID: {}" + userId);
        }
        log.info("Found {} subscriptions for user with ID", subscriptions.size());
        return subscriptions;
    }

    public Subscription getSubscription(String serviceName) {
        return subscriptionRepository.findSubscriptionByServiceName(serviceName);
    }

    public void removeSubscription(Long subId) {
        //если нам не принципиально выводить название подписки которую мы удаляем то вызов метода findSubscriptionById можно убрать
        //так же мы можем удалять подписку не по ID а по имени сервиса подписку на который хотим удалить (зависит от бизнес требований)
        subscriptionRepository.deleteById(subId);
        log.info("Removed subscription for user with ID {}", subId);
    }
//Не успел реализовать для реализации этого метода нужно переделывать таблицы в БД
//    public List<Subscription> getTopSubscriptions() {
//        return subscriptionRepository.findTop3();
//    }
}
