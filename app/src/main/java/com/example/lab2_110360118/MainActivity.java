package com.example.lab2_110360118;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton btn_paper, btn_stone, btn_cut;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //連接xml的元件
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        btn_cut = findViewById(R.id.btn_cut);
        btn_paper = findViewById(R.id.btn_paper);
        btn_stone = findViewById(R.id.btn_stone);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {

            if (ed_name.length() < 1) {      //判斷字串是否為空白，強制玩家輸入玩家姓名
                tv_text.setText("請輸入玩家姓名");
            } else {

                //顯示玩家姓名、出拳
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if (btn_cut.isChecked()) {
                    tv_mmora.setText("我方出拳\n剪刀");
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭");
                } else {
                    tv_mmora.setText("我方出拳\n布");
                }

                //產生亂數
                int computer_random = (int) (Math.random() * 3);

                //顯示電腦出拳
                if (computer_random == 0) {
                    tv_cmora.setText("電腦出拳\n剪刀");
                } else if (computer_random == 1) {
                    tv_cmora.setText("電腦出拳\n石頭");
                } else {
                    tv_cmora.setText("電腦出拳\n布");
                }

                //判斷勝負
                if ((btn_cut.isChecked() && computer_random == 2) || (btn_stone.isChecked() && computer_random == 0) || (btn_paper.isChecked() && computer_random == 1)) {
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜您獲勝了!!!");
                } else if ((btn_cut.isChecked() && computer_random == 1) || (btn_stone.isChecked() && computer_random == 2) || (btn_paper.isChecked() && computer_random == 0)) {
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜，電腦獲勝了!");
                } else {
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平局，請再試一次!");
                }
            }
        });
    }
}