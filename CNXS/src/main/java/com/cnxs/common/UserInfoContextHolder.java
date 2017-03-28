package com.cnxs.common;

public class UserInfoContextHolder {
    
    private static final ThreadLocal<UserInfo> userInfoLocal = new InheritableThreadLocal<UserInfo>() {
        @Override
        protected UserInfo initialValue() {
            return new UserInfo();
        }
    };
    
    public static void setUserInfo(int id, String token) {
        UserInfo info = userInfoLocal.get();
        info.userId = id;
        info.jwt = token;
    }
    
    
    
    public static ThreadLocal<UserInfo> getUserinfolocal() {
        return userInfoLocal;
    }

    public static class UserInfo {
        
        private Integer userId = null;
        
        private String jwt = null;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getJwt() {
            return jwt;
        }

        public void setJwt(String jwt) {
            this.jwt = jwt;
        }

    }
}
