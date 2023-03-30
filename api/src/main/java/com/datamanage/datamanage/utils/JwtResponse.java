package com.datamanage.datamanage.utils;

import java.io.Serializable;

/**
 * @author 贾佳
 * @date 2023/3/29 20:56
 */

// JwtResponse.java
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
