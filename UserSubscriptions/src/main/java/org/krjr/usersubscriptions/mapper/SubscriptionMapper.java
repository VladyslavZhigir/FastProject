package org.krjr.usersubscriptions.mapper;

import org.krjr.usersubscriptions.dto.SubscriptionDTO;
import org.krjr.usersubscriptions.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    @Mapping(source = "serviceName", target = "serviceName")
    SubscriptionDTO toDTO(Subscription subscription);

    @Mapping(source = "serviceName", target = "serviceName")
    Subscription fromDTO(SubscriptionDTO subscriptionDTO);
}
