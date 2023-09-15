package generators;

import com.github.javafaker.Faker;
import models.User;

public class UserGenerator {

    public static User createDefault() {
        Faker faker = new Faker();
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(6, 10),
                faker.name().lastName()
        );
    }

    public static User createWithoutEmail() {
        User user = createDefault();
        user.setEmail(null);
        return user;
    }

    public static User createWithoutPassword() {
        User user = createDefault();
        user.setPassword(null);
        return user;
    }

    public static User createWithoutName() {
        User user = createDefault();
        user.setName(null);
        return user;
    }
}