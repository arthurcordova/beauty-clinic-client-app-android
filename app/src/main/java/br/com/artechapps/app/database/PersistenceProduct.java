package br.com.artechapps.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistence Promotion Data
 *
 * Created by acstapassoli on 13/05/2016.
 */
public class PersistenceProduct extends RepositoryProduct {

    private final Persistence persistence;

    public PersistenceProduct(Context context) {
        super(context);
        persistence = new Persistence(db, TABLE_NAME, COLUMNS);
    }

//    public boolean existRigister(String whereClause, String[] whereArgs) {
//        boolean exist = true;
//        Cursor cursor = null;
//        try {
//            cursor = persistence.find(whereClause, whereArgs);
//            if (cursor == null || !cursor.moveToFirst()) {
//                exist = false;
//            }
//        } finally {
//            if (cursor != null ) {
//                cursor.close();
//            }
//        }
//        return exist;
//    }
//
//    public void insert(List<NotificationsModel> notificationsModels) {
//        List<ContentValues> contentValues = new ArrayList<>();
//        for(NotificationsModel notificationsModel : notificationsModels) {
//            if (!existRigister("_id=?", new String[]{String.valueOf(notificationsModel.getId())})) {
//                contentValues.add(getContentValues(notificationsModel));
//            }
//        }
//        if (contentValues.size() > 0) {
//            persistence.insert(contentValues);
//        }
//    }
//
//    public void insert(NotificationsModel notificationsModel) {
//        if (!existRigister("_id=?",new String[]{String.valueOf(notificationsModel.getId())})) {
//            persistence.insert(getContentValues(notificationsModel));
//        }
//    }
//
//    public void update(List<NotificationsModel> notificationsModels) {
//        for (NotificationsModel notificationsModel : notificationsModels) {
//            getDataBase().update(TABLE_NAME, getContentValues(notificationsModel),"id=?", new String[]{String.valueOf(notificationsModel.getId())});
//        }
//    }
//
//
//    private List<ContentValues> getContentValues(List<NotificationsModel> notificationsModels) {
//        List<ContentValues> contentValues = new ArrayList<>();
//        for (NotificationsModel notificationsModel : notificationsModels) {
//            contentValues.add(getContentValues(notificationsModel));
//        }
//        return  contentValues;
//    }
//
//    private ContentValues getContentValues(NotificationsModel notificationsModel) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("_id", notificationsModel.getId());
//        contentValues.put("noti_type", notificationsModel.getType());
//        contentValues.put("noti_doctor", notificationsModel.getDoctorResponsible());
//        contentValues.put("noti_macro", notificationsModel.getMacros());
//        contentValues.put("noti_date_update", notificationsModel.getDateUpdate());
//        contentValues.put("noti_date_visualization", notificationsModel.getDateVisualization());
//        contentValues.put("noti_date_record", notificationsModel.getRecordDate());
//        contentValues.put("noti_pending", notificationsModel.getPending());
//        return  contentValues;
//    }
//
//    public List<NotificationsModel> getRegisters(String whereClause, String[] whereArgs, String orderBy) {
//        List<NotificationsModel> notificationsModels = new ArrayList<>();
//        Cursor cursor = null;
//        cursor = persistence.find(whereClause, whereArgs, orderBy);
//
//        if (cursor != null){
//            if (cursor.moveToFirst()) {
//                do {
//                    NotificationsModel notificationsModel =
//                            new NotificationsModel(cursor.getInt(cursor.getColumnIndex("_id")),
//                                    cursor.getString(cursor.getColumnIndex("noti_type")),
//                                    cursor.getString(cursor.getColumnIndex("noti_doctor")),
//                                    cursor.getString(cursor.getColumnIndex("noti_macro")),
//                                    cursor.getString(cursor.getColumnIndex("noti_date_update")),
//                                    cursor.getString(cursor.getColumnIndex("noti_date_visualization")),
//                                    cursor.getString(cursor.getColumnIndex("noti_date_record")),
//                                    cursor.getString(cursor.getColumnIndex("noti_pending")),
//                                    cursor.getBlob(cursor.getColumnIndex("noti_image_patiente")));
//
//                    notificationsModels.add(notificationsModel);
//                } while (cursor.moveToNext());
//            }
//            cursor.close();
//        }
//        return notificationsModels;
//    }

    public SQLiteDatabase getDataBase(){
        return persistence.getDataBase();
    }
}