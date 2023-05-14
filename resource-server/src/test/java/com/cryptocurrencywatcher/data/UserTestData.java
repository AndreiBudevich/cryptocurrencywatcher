package com.cryptocurrencywatcher.data;


import com.cryptocurrencywatcher.MatcherFactory;
import com.cryptocurrencywatcher.model.User;

public class UserTestData {
    public static final int USER_ID_3 = 3;

    public static final MatcherFactory.Matcher<User> USER_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(User.class, "registrationTime");

    public static User getNew() {
        return new User(USER_ID_3, "VASILUCHEK ALEKSANDR");
    }
}