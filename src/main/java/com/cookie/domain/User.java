package com.cookie.domain;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Alexander Kuidin on 029 29.10.17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User implements Serializable {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
