package com.example.idealperfume.Data;

public class ReviewData {
    String userID, date, good, bad, tag, comment, numberOfHeart, numberOfStar;
    boolean heart, bookmark;
    int userImage;

    public ReviewData(String userID, String date, String good, String bad,
                      String tag, String comment, String numberOfHeart, String numberOfStar, boolean heart, boolean bookmark, int userImage) {
        this.userID = userID;
        this.date = date;
        this.good = good;
        this.bad = bad;
        this.tag = tag;
        this.comment = comment;
        this.numberOfHeart = numberOfHeart;
        this.numberOfStar = numberOfStar;
        this.heart = heart;
        this.bookmark = bookmark;
        this.userImage = userImage;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNumberOfHeart() {
        return numberOfHeart;
    }

    public void setNumberOfHeart(String numberOfHeart) {
        this.numberOfHeart = numberOfHeart;
    }

    public String getNumberOfStar() {
        return numberOfStar;
    }

    public void setNumberOfStar(String numberOfStar) {
        this.numberOfStar = numberOfStar;
    }

    public boolean isHeart() {
        return heart;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
