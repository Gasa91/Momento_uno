package com.example.momento_uno.Opearation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import com.example.momento_uno.Database.SQLdate;
import com.example.momento_uno.Model.NotaM;

public class OperationN{
    private String DBNAME = "momento_uno.db";
    private int VERSION = 4;
    public  Context context;
    private SQLiteDatabase  SQLiteDatabase ;
    private SQLdate helper;
    //private ArrayList<String> list;
    private NotaM model;


    public OperationN(Context context) {
        this.context = context;
        helper = new SQLdate(context, DBNAME, null, VERSION);
    }






    public void openRead(){ SQLiteDatabase  = helper.getReadableDatabase(); }

    public void openWrite(){ SQLiteDatabase  = helper.getWritableDatabase(); }

    public void Close(){ SQLiteDatabase .close(); }

    public int insert(NotaM model){
        try {
            ContentValues values = new ContentValues();
            values.put("nombre", model.getNombre());
            values.put("nota", model.getNota());
               

            openWrite();
            return (int) SQLiteDatabase.insert(DBNAME, null, values );

            }catch (Exception e){
                String TAG = "MyActivity";
                Log.i(TAG, "e " + e);
                return -1;
            }
        }

        public int delete(int id){
            try {
                String idString = String.valueOf(id);
                String sqlWhere = "id = ?";
                String[] whereArgs = new String[] {idString};

                openWrite();
                return SQLiteDatabase.delete(DBNAME, sqlWhere, whereArgs);

            }catch (Exception e){
                return -1;
            }
        }

        public int updateModel(NotaM model){
            try {
                String idString = String.valueOf(model.get_id());
                String sqlWhere = "id = ?";
                String[] whereArgs = new String[] {idString};

                ContentValues values = new ContentValues();
                values.put("nombre", model.getNombre());
                values.put("nota", model.getNota());

                openWrite();
                return SQLiteDatabase.update(DBNAME, values, sqlWhere, whereArgs);

            }catch (Exception e){
                return -1;
            }
        }

        public ArrayList<NotaM> selectAll(){
            ArrayList<NotaM> list = new ArrayList<>();
            try{
                openRead();
                Cursor cursor = SQLiteDatabase.query(DBNAME, null, null, null, null, null, null);
                if (cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        int id;
                        String nombre ,nota;
                        ContentValues values = new ContentValues();
                        id = cursor.getInt(cursor.getColumnIndex("id"));
                        nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                        nota = cursor.getString(cursor.getColumnIndex("nota"));

                        model = new NotaM(id, nombre,nota);
                        list.add(model);

                    }while (cursor.moveToNext());
                }
                return list;

            }catch (Exception e){
                return list;
            }
        }


    public ArrayList<String> selectAllString(){
            ArrayList<String> list = new ArrayList<>();
            try{
                openRead();
                Cursor cursor = SQLiteDatabase.query(DBNAME, null, null, null, null, null, null);
                if (cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        int id;
                        String nombre, nota;

                        id = cursor.getInt(cursor.getColumnIndex("id"));
                        nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                        nota = cursor.getString(cursor.getColumnIndex("nota"));


                        model = new NotaM(id, nombre, nota);
                        list.add(model.toString());

                    }while (cursor.moveToNext());
                }
                return list;

            }catch (Exception e){
                return list;
            }
        }
    }
