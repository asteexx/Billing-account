package com.netcracker.gorbunov.fapi.security;

public class SecurityJwtConstants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 3*60*60;
    public static final String SIGNING_KEY = "key2341Ln";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
}
