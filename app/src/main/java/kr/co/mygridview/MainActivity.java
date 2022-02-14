package kr.co.mygridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("그리드뷰 영화 포스터");

        final GridView gridView = findViewById(R.id.gridview);

        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gridAdapter);
    }
    private class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context context) {
            this.context = context;
        }

        // 영화 포스터 그림 파일의 id를 배열로 저장
        Integer [] posterID = {
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05};

        // 그리드뷰에 보여질 이미지 개수를 반환
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        // 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함함
       @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           ImageView imageView = new ImageView(context);
           imageView.setLayoutParams(new GridView.LayoutParams(200,300));
           imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
           imageView.setPadding(5,5,5,5);

           imageView.setImageResource(posterID[i]);

           final int pos = i;
           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                   AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);

                   ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                   ivPoster.setImageResource(posterID[pos]);

                   dig.setTitle("큰 포스터");
                   dig.setIcon(R.drawable.ic_launcher);
                   dig.setView(dialogView);
                   dig.setNegativeButton("닫기", null);
                   dig.show();
               }
           });

           return imageView;
        }
    }
}