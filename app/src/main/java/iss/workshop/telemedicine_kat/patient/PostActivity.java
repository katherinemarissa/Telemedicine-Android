//package iss.workshop.telemedicine_kat.patient;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.List;
//
//import iss.workshop.telemedicine_kat.R;
//import iss.workshop.telemedicine_kat.Remote.Service.MethodCallAPI;
//import iss.workshop.telemedicine_kat.model.Post;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class PostActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_consultation_history);
//
//        TextView textViewResult = findViewById(R.id.test);
//
//        //execute get request, which is an instance of Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/") //base url that you will append relative url to
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        //after creating retrofit instance, we can now create jsonplaceholderapi service using retrofit
//        MethodCallAPI jsonPlaceHolderAPI = retrofit.create(MethodCallAPI.class);
//
//        //use Call object to execute network request; use jsonplaceholderapi to call getPosts() method
//        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();
//
//        //use enqueue to execute call method on background thread (this is a method that retrofit provides)
//        call.enqueue(new Callback<List<Post>>() {
//
//            //when we get a response back from server (does not mean response is successful; may be error 404 response i.e. data you want is not found)
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                //if response is not successful, show response code and return
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code : " + response.code());
//                    return;
//                }
//
//                //if response is successful
//                List<Post> posts = response.body();
//
//                //display in textview
//                for (Post post : posts) {
//                    String content = "";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "User ID: " + post.getUserId() + "\n";
//                    content += "Title: " + post.getTitle() + "\n";
//                    content += "Text: " + post.getText() + "\n\n"; //after this, next object starts
//
//                    textViewResult.append(content);
//                }
//            }
//
//            //if something goes wrong with communication with server (e.g. typo in base url / json returned does not fit object you are parsing it into)
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });
//
//    }
//}
