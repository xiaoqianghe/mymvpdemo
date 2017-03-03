package com.suirenshi.mymvpdemo.dbsql;

/**
 *
 * Created by huan on 2016/7/27.
 */

public class PrintingStyleSQL  {
//    /**
//     *
//     *
//     * @param realm
//     * @return
//     */
//    public static List<PrintStyleInfo.PrintingStyleEntity> findAll(final Realm realm) {
//        RealmQuery<PrintStyleInfo.PrintingStyleEntity> query = realm.where(PrintStyleInfo.PrintingStyleEntity.class);
//        RealmResults<PrintStyleInfo.PrintingStyleEntity> result = query.findAll();
//        return result;
//    }
//
//    /**
//     *
//     *
//     * @param realm
//     * @return
//     */
//    public static PrintStyleInfo.PrintingStyleEntity findByNo(final Realm realm, int no) {
//        RealmQuery<PrintStyleInfo.PrintingStyleEntity> query = realm.where(PrintStyleInfo.PrintingStyleEntity.class);
//        PrintStyleInfo.PrintingStyleEntity result = query.equalTo("dish_type", no).findFirst();
//        return result;
//    }
//
//    /**
//     *
//     *
//     * @param realm
//     * @return
//     */
//    public static PrintStyleInfo.PrintingStyleEntity findFirst(final Realm realm) {
//        PrintStyleInfo.PrintingStyleEntity printingStyle = realm.where(PrintStyleInfo.PrintingStyleEntity.class).findFirst();
//        return printingStyle;
//    }
//
//
//    /**
//     @param realm
//     * @param data
//     */
//    public static void save(final Realm realm, final List<PrintStyleInfo.PrintingStyleEntity> data) {
//        RealmQuery<PrintStyleInfo.PrintingStyleEntity> query = realm.where(PrintStyleInfo.PrintingStyleEntity.class);
//        final RealmResults<PrintStyleInfo.PrintingStyleEntity> result = query.findAll();
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                result.deleteAllFromRealm();
//            }
//        });
//        //
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm bgRealm) {
////                List<PrintStyleInfo.PrintingStyleEntity> listData = dishesFit(data);
//                bgRealm.copyToRealm(data);
//
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                //LogUtil.edb("PrintingStyleSQL", "onSuccess");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//               // LogUtil.edb("PrintingStyleSQL", "OnError" + error.getMessage());
//            }
//        });
//
//    }
//
////    /**
////     *
////     *
////     * @param data
////     * @return
////     */
////    public static List<PrintStyleInfo.PrintingStyleEntity> dishesFit(final PrintStyleInfo.PrintingStyleEntity data) {
////        if (null == data)
////            return null;
////        List<PrintStyleInfo.PrintingStyleEntity> listData = new ArrayList<>();
////        PrintStyleInfo.PrintingStyleEntity bean;
////
////        List<PrintingStyle.PrintingStyleBean> ipList = data.getPrintingStyle();
////        for (int i= 0;i<ipList.size();i++){
////            PrintingStyle.PrintingStyleBean entity = ipList.get(i);
////            if (!"0.0.0.0".equals(entity.getTcpipAddr())) {
////                bean = new DBPrintingStyle();
////                bean.setPrinting_style_id(entity.getPrinting_style_id());
////                bean.setPrinter_no(entity.getPrinter_no());
////                bean.setStyle_no(entity.getStyle_no());
////                bean.setCuttingStyle(entity.getCuttingStyle());
////                bean.setTemplateStyle(entity.getTemplateStyle());
////                bean.setClient_id(entity.getClient_id());
////                bean.setBranch_no(entity.getBranch_no());
////                bean.setCreated_date(entity.getCreated_date());
////                bean.setCreated_by(entity.getCreated_by());
////                bean.setTcpipAddr(entity.getTcpipAddr());
////                if (i!=0){
////                    bean.setDish_type(entity.getDish_type());
////                }
////                listData.add(bean);
////            }
////        }
////        for (PrintingStyle.PrintingStyleBean entity : data.getPrintingStyle()) {
////
////        }
////        return listData;
////
////    }
}
