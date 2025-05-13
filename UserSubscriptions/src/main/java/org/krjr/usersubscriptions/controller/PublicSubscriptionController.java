package org.krjr.usersubscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.krjr.usersubscriptions.dto.SubscriptionCountDTO;
import org.krjr.usersubscriptions.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class PublicSubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("/top")
    public ResponseEntity<List<SubscriptionCountDTO>> top() {
        List<SubscriptionCountDTO> topSubscriptions = subscriptionService.getTopSubscriptions();

        return ResponseEntity.ok(topSubscriptions);
    }
}