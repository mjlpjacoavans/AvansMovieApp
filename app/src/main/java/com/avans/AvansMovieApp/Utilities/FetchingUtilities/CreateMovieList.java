package com.avans.AvansMovieApp.Utilities.FetchingUtilities;

import com.avans.AvansMovieApp.Model.GlobalVariables;
import com.avans.AvansMovieApp.Utilities.NeworkUtilities.HTTPRequestable;
import com.avans.AvansMovieApp.Utilities.NeworkUtilities.MakeHTTPPOSTRequest;

public class CreateMovieList implements HTTPRequestable {
    private String TAG = this.getClass().getSimpleName();

    private String API_ENDPOINT = "/authentication/token/new";
    private String HTTP_GET_PARAMETERS = "?api_key=" + GlobalVariables.API_KEY_V3;

    public void initialiseCreateMovieList(String postdata){
        MakeHTTPPOSTRequest makeReq = new MakeHTTPPOSTRequest(CreateMovieList.this);
        makeReq.execute(GlobalVariables.V3_BASE_URL + API_ENDPOINT + HTTP_GET_PARAMETERS,postdata);
    }

    @Override
    public void ProcessHTTPResponseBody(String HTTPGETResponse) {

    }
}
