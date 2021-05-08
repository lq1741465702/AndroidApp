package com.example.liuqiangapp.chapter03;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;

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
            if (firstNum.equals("")&& v.getId() != R.id.btn_minus){// 缺少第一个操作数
                Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }else if(firstNum.equals("")&& v.getId() == R.id.btn_minus){
                firstNum = "-0";
                return true;
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
        if (!verify(v)){
            Log.d(TAG, "onClick: 校验失败！");
            return;
            }
        String inputText;
        if (v.getId() == R.id.ib_sqrt){//如果点击了开根号
            inputText = "√";
        }else {//除了开根号之外的其他按钮
            inputText = ((TextView)v).getText().toString();
        }
        Log.d(TAG, "onClick: 合法化校验成功，点击了："+inputText);
        if (v.getId() == R.id.btn_clear){//点击了清空按钮
            clear();
        }else if(v.getId() == R.id.btn_cancle){ //点击了取消按钮
            if (operator.equals("")){//无运算符，则表示逐位取消第一个操作数
                if (firstNum.length()==1){
                    firstNum= "0";
                }else if(firstNum.length()>1) {
                    firstNum=firstNum.substring(0,firstNum.length()-1);
                }
                refreshText(firstNum);
            }else { //有运算符，则表示逐位取消第二个操作符
                if(secondNum.length()==1){
                    secondNum = "";
                }else if(secondNum.length()>1){
                    secondNum = secondNum.substring(0,secondNum.length()-1);
                }
                refreshText(showText.substring(secondNum.length()-1));
            }
        }else if(v.getId() == R.id.btn_plus || v.getId() == R.id.btn_minus || v.getId() == R.id.btn_multiply || v.getId() == R.id.btn_divide){//点了加减乘除
            operator = inputText;
            refreshText(showText+operator);
        }else if(v.getId() == R.id.btn_equal){ //点了等于号
            double calcuator_result = caculateFour();//加减乘除
            refreshOperate(String.valueOf(calcuator_result));
            refreshText(showText+"="+result);
        }else if(v.getId() == R.id.ib_sqrt){//点了开根号
            double calcuator_result = Math.sqrt(Double.parseDouble(firstNum));//开根号运算
            refreshOperate(String.valueOf(calcuator_result));
            refreshText(showText+"√="+result);
        }else if(v.getId() == R.id.btn_reciprocal){//点击了求倒数运算
            double calcuator_result = 1.0/Double.parseDouble(firstNum);//倒数运算
            refreshOperate(String.valueOf(calcuator_result));
            refreshText(showText+"/="+result);
        }else{//点击了其他，数字或者符号
            if(result.length()>1 &&operator.equals("")){//上次结果已经出来了
                clear();
            }
            if(operator.equals("")){//无运算符，则继续拼接第一个数字
                firstNum=firstNum+inputText;
            }else{
                secondNum = secondNum + inputText;
            }
            if (showText.equals("0")&& ! inputText.equals(".")){//整数前面不能有0
                refreshText(inputText);
            }else {
                refreshText(showText + inputText);
            }
        }

    }

    // 刷新计算结果
    private void refreshOperate(String new_result){
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }

    // 刷新文本显示
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }

    // 加减乘除四则运算，返回计算结果
    private double caculateFour() {
        double calcuator_result = 0;
        if (operator.equals("+")){
            calcuator_result = Double.parseDouble(firstNum)+Double.parseDouble(secondNum);
        }else if(operator.equals("-")){
            calcuator_result = Double.parseDouble(firstNum)-Double.parseDouble(secondNum);
        }else if(operator.equals("×")){
            calcuator_result = Double.parseDouble(firstNum)*Double.parseDouble(secondNum);
        }else if(operator.equals("÷")){
            calcuator_result = Double.parseDouble(firstNum)/Double.parseDouble(secondNum);
        }
        Log.d(TAG, "calcuator_result=: "+calcuator_result);
        Log.d(TAG, "caculateFour: first_Num= "+firstNum+"  Second_Num="+secondNum+"  operator="+operator);
        return calcuator_result;
    }

    private void clear(){
        refreshOperate("");
        refreshText("");
    }
}