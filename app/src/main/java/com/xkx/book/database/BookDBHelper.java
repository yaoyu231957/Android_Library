package com.xkx.book.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xkx.book.enity.Book;
import com.xkx.book.enity.User;

import java.util.ArrayList;
import java.util.List;

public class BookDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "book.db";
    private static final String TABLE_NAME = "book_info";
    private static final int DB_VERSION = 1;
    private static BookDBHelper mHelper = null;
    private SQLiteDatabase mRDB = null;
    private SQLiteDatabase mWDB = null;


    private BookDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //利用单例模式获取数据库帮助器的唯一实例
    public static BookDBHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new BookDBHelper(context);
        }
        return mHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建图书信息表
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                "book_id varchar(30)PRIMARY KEY," +
                "book_name varchar(30)," +
                "book_number int," +
                "book_tags varchar(50)," +
                "book_introduction varchar(200)," +
                "book_Location varchar(50)" +
                ")";
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923277','数据结构与算法',15,'科学与技术','经典计算机教材','2层-210室-101书架-1001')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923278','三体',20,'文学与艺术&社会科学','著名科幻小说','1层-101室-102书架-1101')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923279','哈利·波特与魔法石',12,'文学与艺术&社会科学','青少年文学经典','1层-102室-103书架-1102')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923280','Java编程思想',5,'科学与技术','系统阐述Java编程','3层-305室-101书架-1201')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923281','Linux内核设计思想',8,'科学与技术','深入理解Linux内核','3层-306室-102书架-1301')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923282','人类简史',10,'文学与艺术&社会科学','对人类历史的深刻反思','1层-103室-104书架-1103')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923283','小王子',25,'文学与艺术','深邃的儿童文学作品','2层-201室-105书架-1501')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923284','原则',4,'社会科学','成功企业家的思维方式','3层-307室-106书架-1601')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923285','圣经',30,'文学与艺术&社会科学','宗教经典','2层-202室-107书架-1701')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923286','围城',11,'文学与艺术','钱钟书的经典之作','1层-104室-108书架-1801')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923287','时间简史',7,'科学与技术','关于物理学和宇宙的书籍','3层-308室-109书架-1901')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923288','巨人的陨落',20,'文学与艺术&社会科学','描绘一战后的历史','2层-203室-110书架-2001')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923289','穷爸爸富爸爸',9,'社会科学','个人理财的经典书籍','1层-105室-111书架-2101')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923290','1984',14,'文学与艺术','关于极权主义的反乌托邦小说','1层-106室-112书架-2201')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923291','习近平谈治国理政',6,'社会科学','关于中国当代政治哲学的书','3层-309室-113书架-2301')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923292','人类群星闪耀时',18,'文学与艺术','历史上的重要时刻','1层-107室-114书架-2401')");
//        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923293','长恨歌',22,'文学与艺术','白居易的诗作','2层-204室-115书架-2501')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923294','未来简史',16,'社会科学','对未来的深刻思考','3层-310室-116书架-2601')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923296','营养之道',12,'生活与健康','关于饮食与营养的指南','1层-108室-118书架-2801')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923297','如何有效管理情绪',10,'生活与健康','帮助读者管理情绪的实用指南','3层-311室-119书架-2901')");
        db.execSQL("insert into " + TABLE_NAME + "(book_id,book_name,book_number,book_tags,book_introduction,book_Location) Values('14923298','正念的奇迹',15,'生活与健康','关于正念的思考与练习','2层-206室-120书架-3001')");
        //好像21条
    }

    //打开数据库的读连接
    public SQLiteDatabase openReadLink() {
        if (mRDB == null || !mRDB.isOpen()) {
            mRDB = mHelper.getReadableDatabase();
        }
        return mRDB;
    }

    //打开数据库的写连接
    public SQLiteDatabase openWriteLink() {
        if (mWDB == null || !mWDB.isOpen()) {
            mWDB = mHelper.getWritableDatabase();
        }
        return mWDB;
    }

    //关闭数据库连接
    public void closeLink() {
        if (mRDB != null && mRDB.isOpen()) {
            mRDB.close();
            mRDB = null;
        }
        if (mWDB != null && mWDB.isOpen()) {
            mWDB.close();
            mWDB = null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //添加用户
    public long insert(Book book) {
        ContentValues values = new ContentValues();
        values.put("book_id", book.bookId);
        values.put("book_name", book.bookName);
        values.put("book_number", book.bookNumber);
        values.put("book_tags", book.bookTags);
        values.put("book_introduction", book.bookIntroduction);
        values.put("book_location", book.bookLocation);

        //执行插入记录动作，该语句返回插入记录的行号
        //如果第三个参数values 为null或者元素个数为0，由于insert()方法必须添加一条除了主键之外其它字段
        //
        //
        //如果第三个参数values 不为null并且元素的个数大于0，可以把第二个参数设置为null
        return mWDB.insert(TABLE_NAME, null, values);
    }

    //  删除书籍
    public long deleteById(String bookid) {
        //删除所有
//        return mWDB.delete(TABLE_NAME, "1=1", null);
        //按id删除
        return mWDB.delete(TABLE_NAME, "book_id=?", new String[]{bookid});
    }

    // 修改用户
    public long update(Book book) {
        ContentValues values = new ContentValues();
        values.put("book_id", book.bookId);
        values.put("book_name", book.bookName);
        values.put("book_number", book.bookNumber);
        values.put("book_tags", book.bookTags);
        values.put("book_introduction", book.bookIntroduction);
        values.put("book_location", book.bookLocation);
        return mWDB.update(TABLE_NAME, values, "book_id=?", new String[]{book.bookId});
    }

    //查询所有
    public List<Book> queryAll() {
        List<Book> list = new ArrayList<>();
        //执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = mRDB.query(TABLE_NAME, null, null, null, null, null, null);
        //循环游标，取出游标所指的每条记录
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.bookId = cursor.getString(0);
            book.bookName = cursor.getString(1);
            book.bookNumber = cursor.getInt(2);
            book.bookTags = cursor.getString(3);
            book.bookIntroduction = cursor.getString(4);
            book.bookLocation = cursor.getString(5);

            list.add(book);
        }

        return list;
    }

    //按id 查询
    public List<Book> queryById(String bookid) {
        List<Book> list = new ArrayList<>();
        //执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = mRDB.query(TABLE_NAME, null, "book_id=?", new String[]{bookid}, null, null, null);
        //循环游标，取出游标所指的每条记录
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.bookId = cursor.getString(0);
            book.bookName = cursor.getString(1);
            book.bookNumber = cursor.getInt(2);
            book.bookTags = cursor.getString(3);
            book.bookIntroduction = cursor.getString(4);
            book.bookLocation = cursor.getString(5);
            list.add(book);
        }
        return list;
    }

    //按书名 查询
    public List<Book> queryByName(String bookname) {
        List<Book> list = new ArrayList<>();
        //执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = mRDB.query(TABLE_NAME, null, "book_name=?", new String[]{bookname}, null, null, null);
        //循环游标，取出游标所指的每条记录
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.bookId = cursor.getString(0);
            book.bookName = cursor.getString(1);
            book.bookNumber = cursor.getInt(2);
            book.bookTags = cursor.getString(3);
            book.bookIntroduction = cursor.getString(4);
            book.bookLocation = cursor.getString(5);
            list.add(book);
        }
        return list;
    }
    
}
