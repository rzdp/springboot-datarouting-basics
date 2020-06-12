package com.rzdp.staticdatasourcerouting.datasource;

public class BranchContextHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setBranchContext(String branch) {
        threadLocal.set(branch);
    }

    public static String getBranchContext() {
        return threadLocal.get();
    }

    public static void clearBranchContext() {
        threadLocal.remove();
    }
}
