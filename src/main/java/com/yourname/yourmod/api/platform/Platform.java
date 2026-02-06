package core.api.platform;

public interface Platform {

    PlatformDataGen dataGen();

    static Platform get() {
        return PlatformLoader.INSTANCE;
    }
}