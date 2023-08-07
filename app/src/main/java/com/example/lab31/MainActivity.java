package com.example.lab31;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvBaiHat;
    private BaiHatAdapter itemAdapter;
    private List<BaiHat> mListItem;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvBaiHat = findViewById(R.id.rcvBaiHat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvBaiHat.setLayoutManager(linearLayoutManager);

        itemAdapter = new BaiHatAdapter();
        mListItem = getmListItem();
        itemAdapter.setData(mListItem);
        rcvBaiHat.setAdapter(itemAdapter);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<BaiHat> lstBaiHat = new ArrayList<>();
                lstBaiHat.add(new BaiHat("img5","12345","Cham Het","Tien Tien"));
                itemAdapter.notifyDataSetChanged();
            }
        });

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvBaiHat.addItemDecoration(itemDecoration);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mListItem.remove(position);
                itemAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(rcvBaiHat);
    }

    private List<BaiHat> getmListItem(){
        List<BaiHat> lstBaiHat = new ArrayList<>();
        lstBaiHat.add(new BaiHat("img","02934","Yeu nhu ngay yeu cuoi","Tien Dung"));
        lstBaiHat.add(new BaiHat("img2","45345","Mua ta da yeu","Huong Giang"));
        lstBaiHat.add(new BaiHat("img5","23123","Yeu Xa","Vu Cat Tuong"));
        lstBaiHat.add(new BaiHat("img2","65342","Vi Sao Phai Khoc","Tien Dung"));
        lstBaiHat.add(new BaiHat("img5","12345","Cham Het","Tien Tien"));
        return lstBaiHat;
    }
}
