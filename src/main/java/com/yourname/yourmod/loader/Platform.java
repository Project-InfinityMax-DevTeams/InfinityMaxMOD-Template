public final class Platform {

    private static LoaderExpectPlatform INSTANCE;

    private Platform() {}

    public static void set(LoaderExpectPlatform platform) {
        INSTANCE = platform;
    }

    public static LoaderExpectPlatform get() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Platform not initialized");
        }
        return INSTANCE;
    }
}
