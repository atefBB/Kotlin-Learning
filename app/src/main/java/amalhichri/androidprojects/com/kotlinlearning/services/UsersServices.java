package amalhichri.androidprojects.com.kotlinlearning.services;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import amalhichri.androidprojects.com.kotlinlearning.utils.AppSingleton;

/**
 * Created by Amal on 19/11/2017.
 */

public class UsersServices {

    private static UsersServices this_ = new UsersServices();

    public static synchronized UsersServices getInstance()
    {	return this_;
    }

    public void registerUser(String id, String username, String email, String pictureUrl, Context context , final ServerCallbacks serverCallbacks){
        Map<String, String> m = new HashMap<String, String>();
        m.put("id", id);
        m.put("username", username);
        m.put("email", email);
        m.put("pictureUrl", pictureUrl);
        final JSONObject jsonBody = new JSONObject(m);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, "http://192.168.1.6/ikotlinBackEnd/web/users/register", jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,//timeout
                3,//retry
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "Register");
    }

    public void getUserById(String id, Context context, final ServerCallbacks serverCallbacks){
        final JSONObject jsonBody = new JSONObject();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, "http://192.168.1.6/ikotlinBackEnd/web/users/getUser?id="+id, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "GetUser");
    }

    public void assignBadge(String id,String badgeindic, Context context, final ServerCallbacks serverCallbacks){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, "http://192.168.1.6/IkotlinBackend/web/users/addBadge?id="+id+"&badgeindic="+badgeindic, new JSONObject(), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "AssignBadge");
    }

    public void isHasBadge(String id,String badgeindic,Context context, final ServerCallbacks serverCallbacks){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, "http://192.168.1.6/IkotlinBackend/web/users/hasBadge?id="+id+"&badgeindic="+badgeindic, new JSONObject(), new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                3,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "AssignBadge");
    }




     /*public void markLoggedUserWebService(String id, Context context , final ServerCallbacks serverCallbacks){
        final JSONObject jsonBody = new JSONObject();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, userServicesAddress + userLogin+"?id="+id, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,//timeout
                3,//retry
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "logging");
    }
   public User get_user_from_json(JSONObject json){
        //datetimeparser
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
        Calendar cal = Calendar.getInstance();

        User user = new User();
        try {
            JSONObject uj=json.getJSONObject("user");
            user.setId(uj.getString("id"));
            user.setUsername(uj.getString("username"));
            user.setEmail(uj.getString("email"));
            try {
                cal.setTime(sdf.parse(uj.getString("created")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setCreated(cal);

            try {
                cal.setTime(sdf.parse(uj.getString("lastlogged")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setLast_loggued(cal);
            user.setSkill_learner(uj.getInt("skill_learner"));
            user.setSkill_challenger(uj.getInt("skill_challenger"));
            user.setSkill_coder(uj.getInt("skill_coder"));

            user.setPictureUrl(uj.getString("picture"));
            user.setConfirmed(uj.getInt("confirmed")!=0);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

   public Boolean is_verified(final Context context){
        if(DataBaseHandler.getInstance(context).getUser().isConfirmed()) return true;
        else{
            for (UserInfo user: FirebaseAuth.getInstance().getCurrentUser().getProviderData()) {
                if (user.getProviderId().equals("facebook.com")) {
                    DataBaseHandler.getInstance(context).setUserConfirmed(true);
                    return true;
                }
            }
            if(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
                DataBaseHandler.getInstance(context).setUserConfirmed(true);
                return true;
            }
            else {
                //Toast.makeText(context, "Verifing", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(!FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()){
                            Toast.makeText(context, "Please confirm your email before commenting !", Toast.LENGTH_SHORT).show();
                            FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
                            Toast.makeText(context, "A confirmation link has been sent to your account !\nPlease refresh and try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
        return false;
    }


    public Drawable getRatingINPicture(String item){
        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        int color = generator.getColor(item);
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .width(60)  // width in px
                .height(60) // height in px
                .endConfig()
                .buildRect(item, color);
        return drawable;
    }


    public void changeProfilePicture(String id, String picture, Context context , final ServerCallbacks serverCallbacks){
        Map<String, String> m = new HashMap<String, String>();
        m.put("id", id);
        m.put("profile_picture", picture);
        final JSONObject jsonBody = new JSONObject(m);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, userServicesAddress + setProfilePic, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,//timeout
                3,//retry
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "pic");
    }

    public void changeUsername(String id, String username, Context context , final ServerCallbacks serverCallbacks){
        Map<String, String> m = new HashMap<String, String>();
        m.put("id", id);
        m.put("username", username);
        final JSONObject jsonBody = new JSONObject(m);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, userServicesAddress + setUsername, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        if (!response.has("Error")){
                            //ok
                            serverCallbacks.onSuccess(response);
                        }
                        else{
                            //wrong entries
                            serverCallbacks.onWrong(response);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //connection problem
                        serverCallbacks.onError(error);
                    }
                });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,//timeout
                3,//retry
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppSingleton.getInstance(context).addToRequestQueue(jsObjRequest, "name");
    }*/

}
