package com.example.idealperfume.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.ProductInfoActivity;
import com.example.idealperfume.Activity.ReviewActivity;
import com.example.idealperfume.Data.ReviewData;
import com.example.idealperfume.Fragment.ReviewFragment;
import com.example.idealperfume.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.CustomViewHolder> {

    private ArrayList<ReviewData> mList;
    Context context;

    public ReviewAdapter(Context context, ArrayList<ReviewData> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public ReviewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_3review, viewGroup, false);

        //이미지 둥글게
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_userImage);
        GradientDrawable drawable =
                (GradientDrawable) ResourcesCompat.getDrawable(view.getResources(), R.drawable.image_rounding, null);
        imageView.setBackground(drawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setClipToOutline(true);


        //신고버튼
        TextView tv_report = (TextView) view.findViewById(R.id.tv_report);
        tv_report.setPaintFlags(tv_report.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        CustomViewHolder viewHolder = new CustomViewHolder(view);


        //줄 글 클릭시 더보기
        final TextView bad = (TextView) view.findViewById(R.id.tv_bad);
        final TextView good = (TextView) view.findViewById(R.id.tv_good);
        final TextView tag = (TextView) view.findViewById(R.id.tv_tag);
        final TextView tv_more = (TextView) view.findViewById(R.id.tv_more);
        LinearLayout tx_review = (LinearLayout) view.findViewById(R.id.tx_review);
        tx_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof ReviewActivity) {
                    good.setMaxLines(Integer.MAX_VALUE);
                    bad.setMaxLines(Integer.MAX_VALUE);
                    tag.setMaxLines(Integer.MAX_VALUE);
                    tv_more.setVisibility(View.INVISIBLE);
                }
                else if(context instanceof ProductInfoActivity){
                    context.startActivity(new Intent(context, ReviewActivity.class));
                }
            }
        });
        return viewHolder;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView userName;
        protected TextView tag;
        protected TextView bad;
        protected TextView date;
        protected TextView good;
        protected TextView comment;
        protected TextView numberOfHeart;
        protected TextView tv_more;
        protected RatingBar numberOfStar;
        protected ImageView userImage;
        protected ImageView bookmarkImage;
        protected ImageView heartImage;

        public CustomViewHolder(View view) {
            super(view);
            this.userName = (TextView) view.findViewById(R.id.tv_userName);
            this.comment = (TextView) view.findViewById(R.id.tv_comment);
            this.bad = (TextView) view.findViewById(R.id.tv_bad);
            this.good = (TextView) view.findViewById(R.id.tv_good);
            this.tag = (TextView) view.findViewById(R.id.tv_tag);
            this.tv_more = (TextView) view.findViewById(R.id.tv_more);
            this.date = (TextView) view.findViewById(R.id.tv_date);
            this.numberOfHeart = (TextView) view.findViewById(R.id.tv_numberOfHeart);
            this.numberOfStar = (RatingBar) view.findViewById(R.id.rb_ProductRating);
            this.bookmarkImage = (ImageView) view.findViewById(R.id.iv_bookmark);
            this.userImage = (ImageView) view.findViewById(R.id.iv_userImage);
            this.heartImage = (ImageView) view.findViewById(R.id.iv_heart);

            //하트 클릭
            heartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (!mList.get(position).isHeart() == true) {
                        heartImage.setImageResource(R.drawable.img_heart_on);
                        mList.get(position).setHeart(true);
                        String tmp = mList.get(position).getNumberOfHeart();
                        int temp = Integer.parseInt(tmp);
                        temp++;
                        mList.get(position).setNumberOfHeart(temp+"");
                        numberOfHeart.setText(mList.get(position).getNumberOfHeart() + "명에게 도움이 되었어요!");
                        numberOfHeart.setTextColor(context.getResources().getColor(R.color.green6D));
                    } else {
                        heartImage.setImageResource(R.drawable.img_heart_off);
                        mList.get(position).setHeart(false);
                        String tmp = mList.get(position).getNumberOfHeart();
                        int temp = Integer.parseInt(tmp);
                        temp--;
                        mList.get(position).setNumberOfHeart(temp+"");
                        numberOfHeart.setText(mList.get(position).getNumberOfHeart() + "명에게 도움이 되었어요!");
                        numberOfHeart.setTextColor(context.getResources().getColor(R.color.grayC4));
                    }
                }
            });

            //북마크 클릭
            bookmarkImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (!mList.get(position).isBookmark() == true) {
                        bookmarkImage.setImageResource(R.drawable.img_heart_on);
                        mList.get(position).setBookmark(true);

                    } else {
                        bookmarkImage.setImageResource(R.drawable.img_heart_off);
                        mList.get(position).setBookmark(false);
                    }
                }
            });


            //더보기 클릭시 전체 글 나오도록
            tv_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(context instanceof ReviewActivity) {
                        good.setMaxLines(Integer.MAX_VALUE);
                        bad.setMaxLines(Integer.MAX_VALUE);
                        tag.setMaxLines(Integer.MAX_VALUE);
                        tv_more.setVisibility(View.INVISIBLE);
                    }
                    else if(context instanceof ProductInfoActivity){
                        context.startActivity(new Intent(context, ReviewActivity.class));
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewAdapter.CustomViewHolder holder, int position) {
        holder.userName.setText(mList.get(position).getUserID());
        holder.comment.setText("댓글 " + mList.get(position).getComment());
        holder.numberOfHeart.setText(mList.get(position).getNumberOfHeart() + "명에게 도움이 되었어요!");
        holder.numberOfStar.setRating(Float.valueOf(mList.get(position).getNumberOfStar()));
        holder.bad.setText(mList.get(position).getBad());
        holder.good.setText(mList.get(position).getGood());
        holder.tag.setText(mList.get(position).getTag());
        holder.date.setText(mList.get(position).getDate() + " 수정됨");
        holder.userImage.setImageResource(mList.get(position).getUserImage());
        if (mList.get(position).isHeart() == true) {
            holder.heartImage.setImageResource(R.drawable.img_heart_on);
            holder.numberOfHeart.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            holder.heartImage.setImageResource(R.drawable.img_heart_off);
        }
        if (mList.get(position).isBookmark() == true) {
            holder.bookmarkImage.setImageResource(R.drawable.img_heart_on);
        } else {
            holder.bookmarkImage.setImageResource(R.drawable.img_heart_off);
        }

        makeMore(holder); //리뷰 2줄 이상시 더보기 표시

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    //리뷰 2줄 이상시 더보기 표시
    public void makeMore(@NonNull final ReviewAdapter.CustomViewHolder holder){
        holder.good.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = holder.good.getLineCount();
                if (lineCount > 2) {
                    holder.tv_more.setVisibility(View.VISIBLE);
                    holder.good.setMaxLines(2);
                }
            }
        });

        holder.bad.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = holder.bad.getLineCount();
                if (lineCount > 2) {
                    holder.tv_more.setVisibility(View.VISIBLE);
                    holder.bad.setMaxLines(2);
                }
            }
        });

        holder.tag.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = holder.tag.getLineCount();
                if (lineCount > 2) {
                    holder.tv_more.setVisibility(View.VISIBLE);
                    holder.tag.setMaxLines(2);
                }
            }
        });
    }
}
