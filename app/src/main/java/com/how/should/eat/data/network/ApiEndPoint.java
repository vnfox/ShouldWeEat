package com.how.should.eat.data.network;

import com.how.should.eat.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "/588d15f5100000a8072d2945";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL
            + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";



    public static final String ENDPOINT_FRUIT = BuildConfig.BASE_URL
            + "/5a1fc792310000b316c0af7b";

    public static final String ENDPOINT_VEGETABLES = BuildConfig.BASE_URL
            + "/5a1fc7f2310000d116c0af80";

    public static final String ENDPOINT_MEAT = BuildConfig.BASE_URL
            + "/5a1fc8843100002517c0af86";

    public static final String ENDPOINT_FISH = BuildConfig.BASE_URL
            + "/5a1fc8a3310000a117c0af87";

    public static final String ENDPOINT_NUT = BuildConfig.BASE_URL
            + "/5a1fc8b4310000d818c0af88";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
