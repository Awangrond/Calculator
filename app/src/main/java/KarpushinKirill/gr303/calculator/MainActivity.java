package KarpushinKirill.gr303.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    //Переменные
    int check=0;
    float a, b, c;
    String sa, sb, sc;
    EditText ta;
    EditText tb;
    TextView tres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ta = findViewById(R.id.aText);
        tb = findViewById(R.id.bText);
        tres = findViewById(R.id.resultText);

    }


    //Ввод данных
    private void scan()
    {
    sa = ta.getText().toString();
    sb = tb.getText().toString();

    if (!sa.isEmpty())
        a = Float.parseFloat(sa);
    else
        a = 0f;

    if (!sb.isEmpty())
        b = Float.parseFloat(sb);
    else
        b = 0f;
    }

    //Вывод результата
    private void print()
    {
        sc = String.valueOf(c);
        tres.setText(sc);
    }

    //Нажатие клавиш
    public void my_btnPlus_click(View v) {check=1; math();}
    public void my_btnMinus_click(View v) {check=2; math();}
    public void my_btnDivide_click(View v) {check=3; math();}
    public void my_btnMulty_click(View v) {check=4; math();}
    public void my_btnSin_click(View v) {check=5; math();}
    public void my_btnCos_click(View v) {check=6; math();}
    public void my_btnTg_click(View v) {check=7; math();}
    public void my_btnPow_click(View v) {check=8; math();}
    public void my_btnSqr_click(View v) {check=9; math();}

    //Математика
    private void math() {
        scan();
        if (check == 1){c=a+b;}
        else if (check == 2){c=a-b;}
        else if (check == 3)
        {
            if (sb.length() != 0){
                if (Integer.parseInt(sb) == 0)
                {
                    tres.setText("Нельзя делить на ноль");
                    return;
                }
                else c=a/b;
            }
        }
        else if (check == 4){c=a*b;}
        else if (check == 5){c=(float)Math.sin(a);}
        else if (check == 6){c=(float)Math.cos(a);}
        else if (check == 7){c=(float)Math.tan(a);}
        else if (check == 8){c=(float)Math.pow(a, b);}
        else if (check == 9){c=(float)Math.sqrt(a);}
        print(); a=0; b=0;
    }
}