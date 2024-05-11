package com.ken.myfancypdfinvoices.model;

import java.util.UUID;

public class UserService {

    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();

        User user = new User(id, randomName);
        return user;
    }
}
