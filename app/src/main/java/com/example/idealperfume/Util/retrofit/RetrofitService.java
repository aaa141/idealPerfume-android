package com.example.idealperfume.Util.retrofit;

import com.example.idealperfume.Common;
import com.example.idealperfume.model.AddBrandPickModel;
import com.example.idealperfume.model.FolderModel;
import com.example.idealperfume.model.GenderCompositionModel;
import com.example.idealperfume.model.LoginModel;
import com.example.idealperfume.model.MaterialModel;
import com.example.idealperfume.model.ProductModel;
import com.example.idealperfume.model.QnAModel;
import com.example.idealperfume.model.RegisterModel;
import com.example.idealperfume.model.ThreeReviewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @FormUrlEncoded
    @POST(Common.RegisterURL)
    Call<RegisterModel> getRegisterCheck(@Field("userID") int userID,
                                         @Field("password") String password,
                                         @Field("loginBy") String loginBy,
                                         @Field("nickName") String nickName,
                                         @Field("userName") String userName,
                                         @Field("uPicture") String uPicture,
                                         @Field("gender") String gender,
                                         @Field("job") String job,
                                         @Field("age") int age,
                                         @Field("point") int point,
                                         @Field("agreement") int agreement,
                                         @Field("phone") int phone,
                                         @Field("certification") int certification);

    @FormUrlEncoded
    @POST(Common.LoginURL)
    Call<LoginModel> getLoginCheck(@Field("userID") int userID,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST(Common.QnAURL)
    Call<QnAModel> getQnACheck(@Field("uID") int uID,
                               @Field("type") String type,
                               @Field("detail") String detail,
                               @Field("email") String email);

    @FormUrlEncoded
    @POST(Common.FolderURL)
    Call<FolderModel> getFolderCheck(@Field("uID") int uID,
                                     @Field("fName") String fName,
                                     @Field("infID") int infID);

    @FormUrlEncoded
    @POST(Common.AddBrandPick)
    Call<AddBrandPickModel> getAddBrandPick(@Field("uID") int uID,
                                        @Field("bID") int bID);

    /* 인자로 데이터 객체가 아니라 줄줄이 보낼 시
        Post로 보낼 경우 Field로 보내야함(@Query X) + FormUrlEncoded필요 */


    @GET(Common.ProductURL)
        /// pdetail/product
    Call<ProductModel> getProductInfo(@Query("pID") int pID);
    // pdetail/product?pID=1 이런식으로 보내짐.

    @GET(Common.GenderURL)
    Call<ArrayList<GenderCompositionModel>> getGenderComposition(@Query("pID") int pID);

    @GET(Common.MaterialURL)
    Call<ArrayList<MaterialModel>> getMaterial(@Query("pID") int pID);

    @GET(Common.ThreeReviewURL)
    Call<ArrayList<ThreeReviewModel>> getThreeReview(@Query("pID") int pID);
}