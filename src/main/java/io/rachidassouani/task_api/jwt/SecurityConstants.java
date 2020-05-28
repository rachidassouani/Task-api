package io.rachidassouani.task_api.jwt;

public class SecurityConstants {

    public static final String SECRET = "your_secret :)";
    public static final long EXPIRATION_TIME = 864_000_000; // 10days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
