package org.krjr.usersubscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.krjr.usersubscriptions.dto.SubscriptionDTO;
import org.krjr.usersubscriptions.entity.Subscription;
import org.krjr.usersubscriptions.mapper.SubscriptionMapper;
import org.krjr.usersubscriptions.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;

    @PostMapping
    public ResponseEntity<SubscriptionDTO> add(@PathVariable Long userId, @RequestBody SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionMapper.fromDTO(subscriptionDTO);
        Subscription addedSubscription = subscriptionService.addSubscription(userId, subscription);
        return ResponseEntity.ok(subscriptionMapper.toDTO(addedSubscription));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> get(@PathVariable Long userId) {
        List<Subscription> subscriptions = subscriptionService.getUserSubscriptions(userId);

        List<SubscriptionDTO> subscriptionDTOs = subscriptions.stream()
                .map(subscriptionMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(subscriptionDTOs);
    }

    @DeleteMapping("/{subId}")
    public ResponseEntity<Void> remove(@PathVariable Long subId) {
        subscriptionService.removeSubscription(subId);
        return ResponseEntity.noContent().build();
    }
}