package com.ch.common.handle;

import com.ch.user.domain.Registry;

/**
 * @author Chen on 2019-02-08-1:17
 */
public class UserHandle {
    private final static ThreadLocal<Registry> requestHolder = new ThreadLocal<>();
    public static void add(Registry registry) {
        requestHolder.set(registry);
    }

    public static Registry getUser() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
