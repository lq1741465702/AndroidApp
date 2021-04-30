package com.example.liuqiangapp.Unit3;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CalculatorActivity";
    private TextView tv_result; // 声明一个文本视图对象
    private String operator = ""; // 运算符
    private String firstNum = ""; // 第一个操作数
    private String secondNum = ""; // 第二个操作数
    private String result = ""; // 当前的计算结果
    private String showText = ""; // 显示的文本内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tv_result = findViewById(R.id.cal_result);
        initButtonListener();
    }


    private void initButtonListener() {
        findViewById(R.id.btn_cancle).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.ib_sqrt).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
    }

    private boolean verify(View v) {
        if (v.getId() == R.id.btn_cancle) {// 点击了取消按钮
            if (operator.equals("") && (firstNum.equals("") || firstNum.equals("0"))) {// 无运算符，则表示逐位取消第一个操作数
                Toast.makeText(getApplicationContext(), "没有可以取消的数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!operator.equals("") && secondNum.equals("")) {// 有运算符，则表示逐位取消第二个操作数
                Toast.makeText(getApplicationContext(), "没有可以取消的数字", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (v.getId() == R.id.btn_equal) {//点了等于按钮
            if (operator.equals("")) {//无运算符
                Toast.makeText(getApplicationContext(), "非法输入，无运算符", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (firstNum.equals("") || secondNum.equals("")) {//无数字符
                Toast.makeText(getApplicationContext(), "无正确数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if ((operator.equals("÷") && Double.parseDouble(firstNum) == 0)) {//被除数为0
                Toast.makeText(getApplicationContext(), "被除数不能为0", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if(v.getId()==R.id.btn_plus || v.getId()==R.id.btn_divide || v.getId()==R.id.btn_minus|| v.getId()==R.id.btn_multiply){//点了加减乘除
            if (firstNum.equals("")){// 缺少第一个操作数
                Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!operator.equals("")){// 已有运算符
                Toast.makeText(this, "已有运算符", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else if (v.getId() == R.id.ib_sqrt) { // 点击了开根号按钮
            if (firstNum.equals("")) { // 缺少底数
                Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (Double.parseDouble(firstNum) < 0) { // 不能对负数开平方
                Toast.makeText(this, "开根号的数值不能小于零", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (v.getId() == R.id.btn_reciprocal) { // 点击了求倒数按钮
            if (firstNum.equals("")) { // 缺少底数
                Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (Double.parseDouble(firstNum) == 0) { // 不能对零求倒数
                Toast.makeText(this, "不能对零求倒数", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (v.getId() == R.id.btn_dot) { // 点击了小数点
            if (operator.equals("") && firstNum.contains(".")) { // 无运算符，则检查第一个操作数是否已有小数点
                Toast.makeText(this, "一个数字不能有两个小数点", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!operator.equals("") && secondNum.contains(".")) { // 有运算符，则检查第二个操作数是否已有小数点
                Toast.makeText(this, "一个数字不能有两个小数点", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}