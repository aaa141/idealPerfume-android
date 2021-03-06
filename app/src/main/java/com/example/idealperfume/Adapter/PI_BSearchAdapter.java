package com.example.idealperfume.Adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Data.Pi_BSearchData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.AddBrandPickModel;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PI_BSearchAdapter extends RecyclerView.Adapter<PI_BSearchAdapter.CustomViewHolder> {
    String brandName;

    private ArrayList<Pi_BSearchData> mList;
    Context context;

    public PI_BSearchAdapter(Context context, ArrayList<Pi_BSearchData> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public PI_BSearchAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_pi_bsearch, viewGroup, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_brand);
        GradientDrawable drawable =
                (GradientDrawable) ResourcesCompat.getDrawable(view.getResources(), R.drawable.image_rounding, null);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        PI_BSearchAdapter.CustomViewHolder viewHolder = new PI_BSearchAdapter.CustomViewHolder(view);

        return viewHolder;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView brandName;
        protected TextView slogan;
        protected ImageView brandImage;
        protected ImageView heartImage;

        public CustomViewHolder(View view) {
            super(view);
            this.brandName = (TextView) view.findViewById(R.id.tv_brandName);
            this.slogan = (TextView) view.findViewById(R.id.tv_slogan);
            this.brandImage = (ImageView) view.findViewById(R.id.iv_brand);
            this.heartImage = (ImageView) view.findViewById(R.id.iv_heart);

            heartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition() ;

                    if (!mList.get(position).isHeart() == true) {

                        //???????????? ??????
                        RetrofitService retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

                        Call<AddBrandPickModel> call = retrofitService.getAddBrandPick(2,2);

                        call.enqueue(new Callback<AddBrandPickModel>() {
                            @Override
                            public void onResponse(Call<AddBrandPickModel> call, Response<AddBrandPickModel> response) {
                                AddBrandPickModel addBrandPickModel = response.body();
                                System.out.println(addBrandPickModel);
                            }

                            @Override
                            public void onFailure(Call<AddBrandPickModel> call, Throwable t) {
                                Log.d("ssss","fail");
                            }
                        });

                        heartImage.setImageResource(R.drawable.img_heart_on);
                        mList.get(position).setHeart(true);
                    }
                    else{
                        heartImage.setImageResource(R.drawable.img_heart_off);
                        mList.get(position).setHeart(false);

                        //???????????? ??????
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PI_BSearchAdapter.CustomViewHolder holder, int position) {
        holder.brandName.setText(mList.get(position).getBrandName());
        holder.slogan.setText(mList.get(position).getSlogan());
        holder.brandImage.setImageResource(mList.get(position).getBrandImage());

        brandName = mList.get(position).getBrandName();

        if(mList.get(position).isHeart() == true){
            holder.heartImage.setImageResource(R.drawable.img_heart_on);
        }
        else{
            holder.heartImage.setImageResource(R.drawable.img_heart_off);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                //JSONObject??? ????????? key value ???????????? ?????? ???????????????.
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("uID", 1); // ?????? ????????????????
//                jsonObject.accumulate("bID", brandName); // name string
                jsonObject.accumulate("bID", 1111); //

                HttpURLConnection con = null;
                BufferedReader reader = null;

                try{
                    URL url = new URL(urls[0]);
                    //????????? ???
                    con = (HttpURLConnection) url.openConnection();

                    con.setRequestMethod("POST"); //POST???????????? ??????
                    con.setRequestProperty("Cache-Control", "no-cache"); //?????? ??????
                    con.setRequestProperty("Content-Type", "application/json"); //application JSON ???????????? ??????

                    con.setRequestProperty("Accept", "text/html"); //????????? response ???????????? html??? ??????
                    con.setDoOutput(true); //Outstream?????? post ???????????? ?????????????????? ??????
                    con.setDoInput(true); //Inputstream?????? ??????????????? ????????? ???????????? ??????
                    con.connect();

                    //????????? ?????????????????? ????????? ??????
                    OutputStream outStream = con.getOutputStream();
                    //????????? ???????????? ??????
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
                    writer.write(jsonObject.toString());
                    writer.flush();
                    writer.close();//????????? ?????????

                    //????????? ?????? ???????????? ??????
                    InputStream stream = con.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while((line = reader.readLine()) != null){
                        buffer.append(line);
                    }

                    return buffer.toString(); //????????? ?????? ?????? ?????? ????????????


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
                            reader.close(); //????????? ?????????
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
        }
    }
}