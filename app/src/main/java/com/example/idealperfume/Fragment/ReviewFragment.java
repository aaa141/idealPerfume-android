package com.example.idealperfume.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Adapter.ReviewAdapter;
import com.example.idealperfume.Data.ReviewData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.ThreeReviewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewFragment extends Fragment {
    ArrayList<ReviewData> mList = new ArrayList<>();
    RetrofitService retrofitService;
    ReviewAdapter reviewAdapter;
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_review, container, false);

        mRecyclerView = view.findViewById(R.id.rcv_review);
        ReviewAdapter ReviewAdapter = new ReviewAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(ReviewAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

        retrofitService.getThreeReview(1)
                .enqueue(new Callback<ArrayList<ThreeReviewModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ThreeReviewModel>> call, Response<ArrayList<ThreeReviewModel>> response) {
                        if(response.isSuccessful()){
                            ArrayList<ThreeReviewModel> threereviewList = response.body();

                            String date = threereviewList.get(0).getCreatedDate();
                            String date_format = date.substring(0, date.length()-14);
                            String date_final = date_format.replaceAll("-", ".");

                            //???????????? ????????? ?????? ?????? ?????? ??? ???????????? ???
                            ThreeReviewArray(threereviewList.get(0).getNickname(), date_final, threereviewList.get(0).getAdv(),
                                    threereviewList.get(0).getDdv(), "#" + threereviewList.get(0).getHashs(), "0", threereviewList.get(0).getHelpful(),
                                    threereviewList.get(0).getRating(),true, true, R.drawable.tmp_review3);

//                            ThreeReviewArray(threereviewList.get(1).getNickname(), threereviewList.get(1).getCreatedDate(), threereviewList.get(1).getAdv(),
//                                    threereviewList.get(1).getDdv(), threereviewList.get(1).getHashs(), "0", threereviewList.get(1).getHelpful(),
//                                    threereviewList.get(1).getRating(),false, false, R.drawable.tmp_review3);

//                            addItem(threereviewList.get(0).getNickname(), threereviewList.get(0).getCreatedDate(), threereviewList.get(0).getRating(), threereviewList.get(0).getAdv(),
//                                    threereviewList.get(0).getDdv(), threereviewList.get(0).getHelpful(), threereviewList.get(0).getHashs(), 0, );

                        }
                    }
                    @Override
                    public void onFailure(Call<ArrayList<ThreeReviewModel>> call, Throwable t) {
                        Log.d("testest",t.getMessage());
                    }
                });

//        String good = getResources().getString(R.string.testGoodReview);
//        String bad = getResources().getString(R.string.testBadReview);
//        String tag = getResources().getString(R.string.testTagReview);
//        addItem("?????????", "2020.08.07", good, bad,
//                tag, "4", "15", "5.0",true, true, R.drawable.tmp_review3);
//
//        addItem("?????????", "2020.07.17", "???????????? ????????? ???????????? :)\n????????? ???????????? ????????? ????????????!", "????????? ???????????? ?????? ???????????? ?????? ??????????????????\n ????????? ????????? ???????????? ????????????",
//                "#?????????????????? #?????? #???????????? #?????????", "1", "10", "2.5",false, true, R.drawable.tmp_review2);
//
//        addItem("?????????", "2020.07.31", "????????? ???????????? ????????? ????????????!", "?????? ?????? ????????? ???????????? ???????????? ????????????",
//                "#????????? #?????? #?????????", "0", "8", "3.5",false, false, R.drawable.tmp_review1);

    }


//    public void retrofit (int i) {
//        retrofitService.getThreeReview(i)
//                .enqueue(new Callback<ArrayList<ThreeReviewModel>>() {
//                    @Override
//                    public void onResponse(Call<ArrayList<ThreeReviewModel>> call, Response<ArrayList<ThreeReviewModel>> response) {
//                        if(response.isSuccessful()){
//                            ArrayList<ThreeReviewModel> threereviewList = response.body();
//
//                            String date = threereviewList.get(0).getCreatedDate();
//                            String date_format = date.substring(0, date.length()-14);
//                            String date_final = date_format.replaceAll("-", ".");
//
//                            ThreeReviewArray(threereviewList.get(0).getNickname(), date_final, threereviewList.get(0).getAdv(),
//                                    threereviewList.get(0).getDdv(), threereviewList.get(0).getHashs(), "0", threereviewList.get(0).getHelpful(),
//                                    threereviewList.get(0).getRating(),true, true, R.drawable.tmp_review3);
//
////                            ThreeReviewArray(threereviewList.get(1).getNickname(), threereviewList.get(1).getCreatedDate(), threereviewList.get(1).getAdv(),
////                                    threereviewList.get(1).getDdv(), threereviewList.get(1).getHashs(), "0", threereviewList.get(1).getHelpful(),
////                                    threereviewList.get(1).getRating(),false, false, R.drawable.tmp_review3);
//
////                            addItem(threereviewList.get(0).getNickname(), threereviewList.get(0).getCreatedDate(), threereviewList.get(0).getRating(), threereviewList.get(0).getAdv(),
////                                    threereviewList.get(0).getDdv(), threereviewList.get(0).getHelpful(), threereviewList.get(0).getHashs(), 0, );
//
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<ArrayList<ThreeReviewModel>> call, Throwable t) {
//                        Log.d("testest",t.getMessage());
//                    }
//                });
//    }

    private void ThreeReviewArray (String userID, String date, String good, String bad,
                                   String tag, String comment, String numberOfHeart, String numberOfStar, boolean heart, boolean bookmark, int userImage) {
        mList.add(new ReviewData(userID, date, good, bad, tag, comment, numberOfHeart, numberOfStar, heart, bookmark, userImage));
//        addItem(userID, date, good, bad, tag, comment, numberOfHeart, numberOfStar, heart, bookmark, userImage);

        // Adapter??????
        reviewAdapter = new ReviewAdapter(getContext(), mList);
        mRecyclerView.setAdapter(reviewAdapter);
    }

//    public void addItem(String userID, String date, String good, String bad,
//                        String tag, String comment, String numberOfHeart, String numberOfStar, boolean heart, boolean bookmark , int userImage) {
//        ReviewData item = new ReviewData(userID, date, good, bad, tag,
//                comment, numberOfHeart, numberOfStar, heart, bookmark , userImage);
//        mList.add(item);
//    }
}