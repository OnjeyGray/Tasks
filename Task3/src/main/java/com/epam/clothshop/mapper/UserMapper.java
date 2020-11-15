package com.epam.clothshop.mapper;

import com.epam.clothshop.model.User;
import com.epam.clothshop.security.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Mapper
@NoArgsConstructor
public abstract class UserMapper {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class UserToSave {
        String username;
        String firstName;
        String lastName;
        String email;
        String password;
        Role role;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class UserLite {
        Long id;
        String username;
        String firstName;
        String lastName;
        String email;
        String password;
        Role role;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class UserFull {
        Long id;
        String username;
        String firstName;
        String lastName;
        String email;
        String password;
        Role role;
        List<OrderMapper.OrderLite> orders = new ArrayList<>();
    }

    public abstract UserToSave mapToSave(User user);

    public abstract User mapToSave(UserToSave userToSave);

    public abstract UserLite mapLite(User user);

    public abstract User mapLite(UserLite userLite);

    public abstract UserFull mapFull(User user);

    public abstract User mapFull(UserFull userFull);
}
