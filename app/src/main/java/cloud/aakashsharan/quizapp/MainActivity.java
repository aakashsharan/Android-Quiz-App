package cloud.aakashsharan.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        setScore(0);

        scoreFromQues1();
        scoreFromQues2();
        scoreFromQues3();
        boolean notChecked4 = scoreFromQues4();
        boolean notChecked6 = scoreFromQues6();
        scoreFromQues5();
        String scoreMessage = "Your total score is " + getScore();
        if(!notChecked4 && !notChecked6){
            displayScore(scoreMessage);
        }
    }

    public void scoreFromQues1() {
        int score = getScore();
        CheckBox abstractBox = (CheckBox) findViewById(R.id.check_abstract);
        CheckBox breakBox = (CheckBox) findViewById(R.id.check_break);
        CheckBox var8Box = (CheckBox) findViewById(R.id.check_var8);

        boolean isAbstract = abstractBox.isChecked();
        boolean isBreak = breakBox.isChecked();
        boolean isVar = var8Box.isChecked();

        if (isAbstract && isBreak && !isVar) {
            score += 1;
            setScore(score);
        }
    }

    public void scoreFromQues2() {
        int score = getScore();
        EditText jdkText = (EditText) findViewById(R.id.jdk_edit_text);
        String jdkValue = jdkText.getText().toString();
        String correctText = getString(R.string.jdk);

        if (jdkValue.equalsIgnoreCase(correctText)) {
            score += 1;
            setScore(score);
        }
    }

    public void scoreFromQues3() {
        int score = getScore();
        EditText objtext = (EditText) findViewById(R.id.this_edit_text);
        String thisValue = objtext.getText().toString();
        String correctText1 = getString(R.string.object_1);
        String correctText2 = getString(R.string.object_2);

        if (thisValue.equalsIgnoreCase(correctText1) || thisValue.equalsIgnoreCase(correctText2)) {
            score += 1;
            setScore(score);
        }
    }

    public boolean scoreFromQues4() {
        int score = getScore();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group1);
        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        if (rb != null) {
            String rbValue = rb.getText().toString();
            String correctValue = getString(R.string.true_);
            if (rbValue.equalsIgnoreCase(correctValue)) {
                score += 1;
                setScore(score);
            }
            return false;
        }
        else{
            Toast.makeText(this, "Please answer Question#4", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public boolean scoreFromQues6() {
        int score = getScore();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group2);
        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        if (rb != null) {
            String rbValue = rb.getText().toString();
            String correctValue = getString(R.string.false_);
            if (rbValue.equalsIgnoreCase(correctValue)) {
                score += 1;
                setScore(score);
            }
            return false;
        }
        else{
            Toast.makeText(this, "Please answer Question#6", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void scoreFromQues5() {
        int score = getScore();
        CheckBox stringBox = (CheckBox) findViewById(R.id.check_string);
        CheckBox stringBufferBox = (CheckBox) findViewById(R.id.check_stringbuffer);

        boolean isString = stringBox.isChecked();
        boolean isStringBuffer = stringBufferBox.isChecked();

        if (isString && isStringBuffer) {
            score += 1;
            setScore(score);
        }
    }

    private void displayScore(String message) {
        TextView scoreView = (TextView) findViewById(R.id.score_view);
        scoreView.setText(message);
    }
}
