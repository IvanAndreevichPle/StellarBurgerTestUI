package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:BaseConfig.properties"})
public interface BaseConfig extends Config {
    @Config.Key("MAIN_URL")
    String mainURL();

    @Config.Key("LOGIN_URL")
    String loginURL();

    @Config.Key("REGISTRATION_URL")
    String registrationURL();

    @Config.Key("RESET_PASSWORD_URL")
    String resetpasswordURL();

    @Config.Key("WAIT_SECONDS_TIMEOUT")
    int waitSecondsTimeOut();

    @Config.Key("REGISTER_PATH")
    String registerPATH();

    @Config.Key("LOGIN_PATH")
    String loginPATH();

    @Config.Key("USER_PATH")
    String userPATH();
}