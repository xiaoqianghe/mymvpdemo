package com.suirenshi.mymvpdemo.biz;

import java.util.ArrayList;

/**
 * @包名: com.suirenshi.mymvpdemo.biz
 * @类名: RequestBiziml
 * @创建人: xiaoqianghe
 * @创建时间 : 2016/10/13 13:51
 * @描述 : TODO  获取数据的逻辑
 */

public class RequestBiziml implements RequestBiz{


    @Override
    public void requestData(final OnRequestListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(2000);
                    ArrayList<String> data=new ArrayList<String>();
                    for(int i=1;i<8;i++){
                        data.add("==========RequestBiziml"+i);
                    }
                    if(null!=listener){
                        listener.onSuccess(data);

                    }

                }catch(Exception e){
                    e.printStackTrace();
                   // listener.onFailed();

                }
            }
        }).start();
    }
}
