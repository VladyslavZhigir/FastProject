package org.krjr.usersubscriptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<SubscriptionDTO> subscriptions;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SubscriptionDTO> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionDTO> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
