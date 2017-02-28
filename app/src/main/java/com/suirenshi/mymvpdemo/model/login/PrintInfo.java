package com.suirenshi.mymvpdemo.model.login;

import io.realm.RealmObject;

/**
 * @包名: com.suirenshi.mymvpdemo.model.login
 * @类名: PrintInfo
 * @创建人: xiaoqianghe
 * @创建时间 : 2017/2/28 15:51
 * @描述 : TODO
 */

public class PrintInfo  extends RealmObject{

    /**
     * cuttingStyle : 1
     * printing_style_id : 1
     * style_no : 0
     * created_date : 1464157094000
     * templateStyle : 0
     * printer_no : 0
     * created_by : 12
     * client_id : 1
     * tcpipAddr : 192.168.20.120
     *
     *
     *
     *
     */

    private int cuttingStyle;
    private int printing_style_id;
    private int style_no;
    private long created_date;
    private int templateStyle;
    private int printer_no;
    private int created_by;
    private int client_id;
    private String tcpipAddr;
    private int dish_type;


    public int getPrinting_style_id() {
        return printing_style_id;
    }

    public void setPrinting_style_id(int printing_style_id) {
        this.printing_style_id = printing_style_id;
    }

    public int getCuttingStyle() {
        return cuttingStyle;
    }

    public void setCuttingStyle(int cuttingStyle) {
        this.cuttingStyle = cuttingStyle;
    }

    public int getStyle_no() {
        return style_no;
    }

    public void setStyle_no(int style_no) {
        this.style_no = style_no;
    }

    public long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }

    public int getTemplateStyle() {
        return templateStyle;
    }

    public void setTemplateStyle(int templateStyle) {
        this.templateStyle = templateStyle;
    }

    public int getPrinter_no() {
        return printer_no;
    }

    public void setPrinter_no(int printer_no) {
        this.printer_no = printer_no;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getTcpipAddr() {
        return tcpipAddr;
    }

    public void setTcpipAddr(String tcpipAddr) {
        this.tcpipAddr = tcpipAddr;
    }

    public int getDish_type() {
        return dish_type;
    }

    public void setDish_type(int dish_type) {
        this.dish_type = dish_type;
    }



}
