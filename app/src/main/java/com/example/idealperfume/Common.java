package com.example.idealperfume;

public class Common {

    //*실제 device
    public static final String BASE_SERVER_URL = "http://192.168.0.98:8080";
    //*에뮬레이터
    //public static final String BASE_SERVER_URL = "http://10.0.2.15:8080";

    public static final String SearchUserURL = "/users/search"; //유저검색
    public static final String RegisterURL = "/users/register"; //회원가입
    public static final String LoginURL = "/users/login"; //로그인

    public static final String ProductURL = "/pdetail/product"; //상품정보
    public static final String MaterialURL = "/pdetail/material"; //원료정보
    public static final String GenderURL = "/pdetail/gender"; // 성별분포
    //

}
