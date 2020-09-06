package com.example.idealperfume.Util.retrofit;

import com.example.idealperfume.Common;
import com.example.idealperfume.model.GenderCompositionModel;
import com.example.idealperfume.model.LoginModel;
import com.example.idealperfume.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @FormUrlEncoded
    @POST(Common.LoginURL)
    Call<LoginModel> getLoginCheck(@Field("userID") int userID,
                             @Field("password") String password);



    /* 인자로 데이터 객체가 아니라 줄줄이 보낼 시
        Post로 보낼 경우 Field로 보내야함(@Query X) + FormUrlEncoded필요 */


    @GET(Common.ProductURL) /// pdetail/product
    Call<ProductModel> getProductInfo(@Query("pID") int pID);
                                     // pdetail/product?pID=1 이런식으로 보내짐.

    @GET(Common.GenderURL)
    Call<ArrayList<GenderCompositionModel>> getGenderComposition(@Query("pID") int pID);

}