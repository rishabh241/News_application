package com.example.myapplication;

import static java.sql.Types.TIMESTAMP;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DetailAct extends AppCompatActivity {

    NewsHeadlines headlines;
    ProgressDialog dialog;
    TextView txt_title, txt_auth,txt_time,txt_desc,txt_content;
    ImageView img;
//    CharSequence ago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt_title=findViewById(R.id.text_detail_title);
        txt_auth=findViewById(R.id.text_detail_author);
        txt_time=findViewById(R.id.text_detail_time);
        txt_desc=findViewById(R.id.text_detail_desc);
        txt_content=findViewById(R.id.text_detail_content);
        img=findViewById(R.id.image_detail_news);

        dialog =new ProgressDialog(this);
        dialog.setTitle("Fetching");
        dialog.show();

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("Data");

        String time= (headlines.getPublishedAt());

        txt_title.setText(headlines.getTitle());
        txt_auth.setText(headlines.getAuthor());

//        String timestamp=new
        txt_time.setText(time);
        txt_desc.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(img);
        dialog.hide();
    }
}