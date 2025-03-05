package com.xkx.book.activity.borrow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xkx.book.R;
import com.xkx.book.adapter.BorrowAdapter;
import com.xkx.book.database.BookDBHelper;
import com.xkx.book.database.BorrowDBHelper;
import com.xkx.book.enity.Book;
import com.xkx.book.enity.Borrow;
import com.xkx.book.util.ToastUtil;

import java.util.List;

public class ViewBorrowActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lv_view_borrow;
    private String userId, bookId, bookName;
    private BorrowDBHelper mHelper;
    private BookDBHelper nHelper;
    private BorrowAdapter borrowAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_borrow);

        lv_view_borrow = findViewById(R.id.lv_view_borrow);
        lv_view_borrow.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //获取数据库帮助器的实例
        mHelper = BorrowDBHelper.getInstance(this);
        nHelper = BookDBHelper.getInstance(this);
        //打开数据库帮助器的读写连接
        mHelper.openWriteLink();
        mHelper.openReadLink();
        nHelper.openWriteLink();
        nHelper.openReadLink();

        List<Borrow> borrows = mHelper.queryAll();
        for (Borrow borrow : borrows) {
            Log.e("ning", borrow.toString());
        }
        borrowAdapter = new BorrowAdapter(borrows, ViewBorrowActivity.this);
        lv_view_borrow.setAdapter(borrowAdapter);

        lv_view_borrow.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Borrow borrow = (Borrow) adapterView.getItemAtPosition(position);
        userId = borrow.getBorrowId();
        bookId = borrow.getBorrowBookId();
        bookName = borrow.getBorrowBookName();


        Log.e("ning", borrow.toString());
        Log.e("ning", bookId);
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewBorrowActivity.this);
        builder.setTitle("是否删除该借阅记录？");
        // 确认
        builder.setPositiveButton("确认", (dialog, whichButton) -> {
            // 获取图书数量
            int booknum = 0;
            String bookTags  = null;
            String bookIntroduction = null;
            String bookLocation = null;
            List<Book> books = nHelper.queryById(bookId);
            for (Book b : books) { // 实际上应该只有第一个，这个sb原本写的啥玩意
                booknum = b.bookNumber;
                bookTags = b.getBookTags();
                bookIntroduction = b.getBookIntroduction();
                bookLocation = b.getBookLocation();
            }
            // 更新图书信息
            Book returnbook = new Book(bookId, bookName, booknum + 1,bookTags,bookIntroduction,bookLocation);
            // 删除借阅信息
            if (nHelper.update(returnbook) > 0 && mHelper.deleteByid(userId, bookId) > 0)
                ToastUtil.show(this, "删除成功");
            onStart();
        });
        // 取消
        builder.setNegativeButton("取消", (dialog, whichButton) -> dialog.dismiss());
        builder.show();
    }
}