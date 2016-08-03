package dys.testaudiorecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dys.testaudiorecord.audio.AudioFileFunc;
import dys.testaudiorecord.audio.AudioRecordFunc;

public class MainActivity extends AppCompatActivity {

    private Button btn_record, btn_stop, btn_play;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTextView = (TextView)findViewById(R.id.textView);
        btn_record = (Button) findViewById(R.id.btn_record_wav);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_play = (Button) findViewById(R.id.btn_play_wav);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record();
                mTextView.setText("正在录制");
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                mTextView.setText("录制完成");
            }
        });
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(AudioFileFunc.getWavFilePath());
            }
        });
    }

    private void record() {
        AudioRecordFunc.getInstance().startRecordAndFile();
    }

    private void stop() {
        AudioRecordFunc.getInstance().stopRecordAndFile();
    }

    private void play(String path) {
        AudioRecordFunc.getInstance().playRecord(path);
    }
}
