package org.krjr.usersubscriptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

//Lombok аннотации работали нестабильно поэтому вместо них геттеры и сеттеры созданы вручную
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
