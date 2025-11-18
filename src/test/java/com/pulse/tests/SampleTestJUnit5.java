package com.pulse.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pulse.dao.TestDAO;

public class SampleTestJUnit5 {

    @Test
    void testDatabaseConnection() {
        TestDAO testDAO = new TestDAO();
        String version = testDAO.testDatabase();
        assertTrue(version.contains("PostgreSQL"));
    }
}
