package com.cookie.dao;

import com.cookie.dao.IFilter;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class UserFilter implements IFilter {
    private long id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
