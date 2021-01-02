package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_NAME = "testdata.user.name";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD), TestDataReader.getTestData(TESTDATA_USER_NAME));
    }
}
