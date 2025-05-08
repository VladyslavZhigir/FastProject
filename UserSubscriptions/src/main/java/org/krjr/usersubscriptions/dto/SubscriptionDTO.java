package org.krjr.usersubscriptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    private String serviceName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdAt;
}
