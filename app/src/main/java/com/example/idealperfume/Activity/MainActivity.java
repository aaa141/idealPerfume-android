package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Adapter.MagazineAdapter;
import com.example.idealperfume.Adapter.MainRankingAdapter;
import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.RankingAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.Data.MagazineData;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{

    private RelativeLayout mypick, event, setting;
    private LinearLayout ll_review, ll_perfume, ll_diffuser, ll_candle, ll_aromaoil, ll_bodylotion;
    int pressedTime = 0;
    ImageView iv_mainbackground;

    TextView tv_rankcatecory;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("향수", "디퓨저", "캔들", "아로마 오일", "바디 로션"));

    private ArrayList<MagazineData> magazineData;
    private MagazineAdapter magazineAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageView review, perfume, diffuser, candle, aromaoil, bodylotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mypick = findViewById(R.id.layout_mypickmenu);
        event = findViewById(R.id.layout_eventmenu);
        setting = findViewById(R.id.layout_settingmenu);

        mypick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyPickActivity.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        ll_review = findViewById(R.id.ll_review);
        ll_perfume = findViewById(R.id.ll_perfume);
        ll_diffuser = findViewById(R.id.ll_diffuser);
        ll_candle = findViewById(R.id.ll_candle);
        ll_aromaoil = findViewById(R.id.ll_aromaoil);
        ll_bodylotion = findViewById(R.id.ll_bodylotion);

        ll_bodylotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PI_SearchActivity.class);
                startActivity(intent);
            }
        });

        new JSONTask().execute("http://192.168.200.161:8080/mainpage/ranking");

        tv_rankcatecory = findViewById(R.id.tv_rankcategoty);

        tv_rankcatecory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(gender, "");
            }
        });


        //Rank Viewpager
        ViewPager vp = findViewById(R.id.viewpager_rank);
        MainRankingAdapter mainRankingAdapter = new MainRankingAdapter(getSupportFragmentManager());
        vp.setAdapter(mainRankingAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_ranking);
        tabLayout.setupWithViewPager(vp);

        recyclerView = findViewById(R.id.rv_idealmagagine);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        magazineData = new ArrayList<>();

        magazineAdapter = new MagazineAdapter(magazineData);
        recyclerView.setAdapter(magazineAdapter);

        magazineData.add(new MagazineData(R.drawable.ic_launcher_background, "일리윤", "illiyoon", "피부 스스로의 힘을 키워주는 리얼 시카라인 출시"));
        magazineData.add(new MagazineData(R.drawable.ic_launcher_background, "일리윤", "illiyoon", "나만의 휴식을 위한 필수 아이템"));

        //테스트 바로가기 인텐트
        RelativeLayout relativeLayout = findViewById(R.id.layout_gotest);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        if ( pressedTime == 0 ) {
            Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
            pressedTime = (int) System.currentTimeMillis();
        }
        else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if ( seconds > 2000 ) {
                Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
                pressedTime = 0 ;
            }
            else {
                super.onBackPressed();
//                finish(); // app 종료 시키기
            }
        }
    }

    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        View line = (View) view.findViewById(R.id.line_bs_title);
        titles.setText(title);

        //"xx"를 선택하세요.
        if (!title.equals("")) {
            titles.setText(title);
        } else {
            titles.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                tv_rankcatecory.setText(list.get(position));
                BottomSheet.dismiss();
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("user_id", "androidTest");
                jsonObject.accumulate("name", "yun");

                HttpURLConnection con = null;
                BufferedReader reader = null;

                try{
                    URL url = new URL(urls[0]);
                    //연결을 함
                    con = (HttpURLConnection) url.openConnection();

                    con.setRequestMethod("POST"); //POST방식으로 보냄
                    con.setRequestProperty("Cache-Control", "no-cache"); //캐시 설정
                    con.setRequestProperty("Content-Type", "application/json"); //application JSON 형식으로 전송

                    con.setRequestProperty("Accept", "text/html"); //서버에 response 데이터를 html로 받음
                    con.setDoOutput(true); //Outstream으로 post 데이터를 넘겨주겠다는 의미
                    con.setDoInput(true); //Inputstream으로 서버로부터 응답을 받겠다는 의미
                    con.connect();

                    //서버로 보내기위해서 스트림 만듬
                    OutputStream outStream = con.getOutputStream();
                    //버퍼를 생성하고 넣음
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
                    writer.write(jsonObject.toString());
                    writer.flush();
                    writer.close();//버퍼를 받아줌

                    //서버로 부터 데이터를 받음
                    InputStream stream = con.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while((line = reader.readLine()) != null){
                        buffer.append(line);
                    }

                    return buffer.toString(); //서버로 부터 받은 값을 리턴해줌 아마 OK!!가 들어올것임


                } catch (MalformedURLException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(con != null){
                        con.disconnect();
                    }
                    try {
                        if(reader != null){
                            reader.close(); //버퍼를 닫아줌
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            System.out.println("메인포스트결과 : " + result); //서버로 부터 받은 값을 출력해주는 부
        }
    }
}

