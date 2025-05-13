package org.krjr.usersubscriptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SubscriptionDTO {
    private Long id;

    private String serviceName;

    private LocalDateTime createdAt;
}
