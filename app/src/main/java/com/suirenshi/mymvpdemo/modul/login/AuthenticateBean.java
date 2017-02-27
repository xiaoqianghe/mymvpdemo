package com.suirenshi.mymvpdemo.modul.login;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By KyLin (SRS)
 *
 * @version V1.0
 * @Description: ${TODO}
 * @author: KyLin (SRS)
 * @date: 2016/7/13 16:01
 */
public class AuthenticateBean implements Serializable {

    /**
     * authToken : eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE0NjgzOTc0ODUsInN1YiI6IjEzMTY2NjY4ODg4IiwibmJmIjoxNDY4Mzk2Mjg1LCJpc3MiOiJzei1hZ2F0aGEuY29tIiwiaWF0IjoxNDY4Mzk2Mjg1fQ.h-0A5GCevUQwLr6BEb9v9f5oEFF8xnP1eGV9BV1A9RvGI2Xt78gEWVP_kkaWpfJ5qOVuZ_SQ1FSIwutR0zbqXiyo_izQ8vBaK1Q7BT8FnqZzmJ4Zm7lm6a_55_3IWN2IAeiNvzybOBwCjda82iVqM2J2nRk36SicEP6_edyugdksKCzn7Q-4-uxgWn2IJICJzKTGBFHf-qWYSM1b5zFnFGiTCBe6PaCVPglegFvx0pFKZPQiYfB9bRqdKTCqr3-SiQLCnnKiyp0jpUGjg_v9-X_s42OG2x0S4iwMnHK0m0Eh6FhY5HYbf7CJ8d-ezQ5DjL5m-C6uTBSoT_fm4tOMjA
     * authPermission : 1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
     * role : 經理
     * userId : 12
     * authenticated : Y
     * status : 0
     * client_no : 1
     * branch_no : 1
     * reseller_no : 0
     * staff_no : 12
     */

    private String authToken;
    private String authPermission;
    private String role;
    private int userId;
    private String authenticated;
    private int status;
    private int client_no;
    private int branch_no;
    private int reseller_no;
    private int staff_no;
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthPermission() {
        return authPermission;
    }

    public void setAuthPermission(String authPermission) {
        this.authPermission = authPermission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(String authenticated) {
        this.authenticated = authenticated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getClient_no() {
        return client_no;
    }

    public void setClient_no(int client_no) {
        this.client_no = client_no;
    }

    public int getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(int branch_no) {
        this.branch_no = branch_no;
    }

    public int getReseller_no() {
        return reseller_no;
    }

    public void setReseller_no(int reseller_no) {
        this.reseller_no = reseller_no;
    }

    public int getStaff_no() {
        return staff_no;
    }

    public void setStaff_no(int staff_no) {
        this.staff_no = staff_no;
    }
}
