package Utilities;

import org.testng.annotations.DataProvider;

public class SecretsDataProvider {
    @DataProvider(name = "secretData")
    public Object[][] getSecretData() {

        String username = System.getenv("TEST_USERNAME");
        String password = System.getenv("TEST_PASSWORD");

        if (username == null || password == null || username.isEmpty()) {
            throw new RuntimeException("❌ Secrets not found in CI");
        }

        System.out.println("Using GitHub Secrets");

        return new Object[][]{
                {username, password}
        };
    }
}
