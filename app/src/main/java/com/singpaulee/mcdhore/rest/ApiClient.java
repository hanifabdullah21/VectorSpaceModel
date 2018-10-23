package com.singpaulee.mcdhore.rest;

import com.singpaulee.mcdhore.Model.KataDasarModel;
import com.singpaulee.mcdhore.Model.ResponseList;
import com.singpaulee.mcdhore.Model.StopWordModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASUS on 30/12/2017.
 */

public interface ApiClient {

//	@GET ("macros/echo?user_content_key=FKW-e_qbtDGriKQ9YbIfbaY2NSySUDYxI7qbYiiVGoeV3NyFTlhDzRvpPV_pxDsKBNb-8XPKXr_QawdSs76rjbfa_TpHKkwqOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1ZsYSbt7G4nMhEEDL32U4DxjO7V7yvmJPXJTBuCiTGh3rUPjpYM_V0PJJG7TIaKp2AMOvUL6dlKapUkOCsuFVgBJ6D5RwT-yf4-fdUSM1U1mnFmwzK-4Yjn5f10iED5uZE7I76JIznZ0AyZC76TdmE&lib=MbpKbbfePtAVndrs259dhPT7ROjQYJ8yx")
	@GET ("https://script.google.com/macros/s/AKfycbzFLlaUagsKVz9PgbNo26BLc_c7AjbMnLFNc7W3K_DPTau-xSA/exec?tabelName=twitter")
	Call<ResponseList> list();

//	@GET("getStopword.php")
    @GET ("https://script.google.com/macros/s/AKfycbzFLlaUagsKVz9PgbNo26BLc_c7AjbMnLFNc7W3K_DPTau-xSA/exec?tabelName=stopword")
	Call<ResponseList> stopword();

	@GET("getKatadasar.php")
	Call<ArrayList<KataDasarModel>> katadasar();
}