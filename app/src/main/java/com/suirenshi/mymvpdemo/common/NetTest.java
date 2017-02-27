package com.suirenshi.mymvpdemo.common;

import com.bq2015.oknet.OkHttpUtils;
import com.bq2015.oknet.cache.CacheMode;
import com.bq2015.oknet.model.HttpHeaders;
import com.bq2015.oknet.utils.ApiHelper;

/**
 * @包名: com.suirenshi.mymvpdemo.common
 * @类名: NetTest
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/2/27 16:16
 * @描述 : TODO
 */

public class NetTest {

    private static final java.lang.String TAG = "Net";

    public static class NetInstance {

        //http://192.168.1.105:8002/srs-mobile/v3/auth/login



        //基础域名
        public static String URL ="http://192.168.1.105:8002/srs-mobile/";

        //        //基础域名
//        public static String URL = Constant.URL.getBaseUrl();
        //设置基础域名
        public static OkHttpUtils okHttpUtils = OkHttpUtils.getInstance().baseUrl(URL);
        //获取请求Api
        public static NetApi getApi() {
            return ApiHelper.get(NetApi.class, OkHttpUtils.getContext());
        }

        private  static HttpHeaders httpHeaders = new HttpHeaders();

        /**
         * 设置请求头
         */
        public static void setHttpHead(String key, String value) {
            httpHeaders.put(key,value);
        }
    }

    /**
     * 设置token 在登录后设置一次即可
     * @param token 字符串
     */
    public static void setToken(String token) {
        NetInstance.setHttpHead("Authorization","Bearer " + token);
        NetInstance.setHttpHead("token",token);
        NetInstance.okHttpUtils.addCommonHeaders(NetInstance.httpHeaders);
    }


    public static NetApi get() {
        NetInstance.okHttpUtils.setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST);
//        return NetInstance.getApi();
        return getWithToken();

    }

    public static NetApi getPayNetApi() {
        return NetInstance.getApi();
    }

    /**
     * 有token的请求
     * @return
     */
    public static NetApi getWithToken() {
       /* String token =  (String) SPUtils.get(LoginConstant.SP.SP_LOGIN_TOKEN, "");
        NetInstance.httpHeaders.put("Authorization",token);
        NetInstance.setHttpHead("Authorization",token);
        NetInstance.okHttpUtils.addCommonHeaders(NetInstance.httpHeaders);*/
        //  NetInstance.okHttpUtils.getCommonHeaders().put("Authorization",token);
        return NetInstance.getApi();
    }


    /**
     * 登录专用  安全性考虑  将用户名和密码放在请求头
     * @param userName
     * @param passWord
     * @return
     */
    public static NetApi get(String userName, String passWord) {
        //username: 13166668888
        NetInstance.httpHeaders.put("username", userName);
        //password: 123789
        NetInstance.httpHeaders.put("password", passWord);
        NetInstance.okHttpUtils.addCommonHeaders(NetInstance.httpHeaders);
        return NetInstance.getApi();
    }


}
