package org.krjr.usersubscriptions.mapper;

import org.krjr.usersubscriptions.dto.UserDTO;
import org.krjr.usersubscriptions.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SubscriptionMapper.class})
public interface UserMapper {
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "subscriptions", target = "subscriptions")
    UserDTO toDto(User user);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "subscriptions", target = "subscriptions")
    User fromDto(UserDTO userDTO);

}
