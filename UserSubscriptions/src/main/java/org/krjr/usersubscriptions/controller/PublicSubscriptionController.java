package org.krjr.usersubscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.krjr.usersubscriptions.mapper.SubscriptionMapper;
import org.krjr.usersubscriptions.service.SubscriptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class PublicSubscriptionController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;


//    @GetMapping("/top")
//    public ResponseEntity<List<SubscriptionDTO>> top() {
//        List<Subscription> topSubscriptions = subscriptionService.getTopSubscriptions();
//        List<SubscriptionDTO> topSubscriptionsDTO = topSubscriptions.stream()
//                .map(subscriptionMapper::toDTO)
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(topSubscriptionsDTO);
//    }
}