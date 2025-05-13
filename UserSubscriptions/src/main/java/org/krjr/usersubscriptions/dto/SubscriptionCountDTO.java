package org.krjr.usersubscriptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionCountDTO {
    private String serviceName;
    private Long count;
}
