package cloud.aakashsharan.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This class consists of all methods needed to calculate the score for the quiz app.
 * It contains a method that displays the score.
 *
 * @author Aakash Sharan
 * @since 6/17/2017
 */

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

    /**
     * Calls another method that displays message.
     *
     * @param view onClick method associated view.
     */
    public void submitAnswers(View view) {
        setScore(0);

        scoreFromQues1();
        scoreFromQues2();
        scoreFromQues3();
        boolean notChecked4 = scoreFromQues4();
        boolean notChecked6 = scoreFromQues6();
        scoreFromQues5();

        // display score only when all the mandatory questions are answered.
        if (!notChecked4 && !notChecked6) {
            displayScore(getScore());
        }
    }

    /**
     * Sets the global field score.
     * Increment score by 1 if abstract and break checkboxes are checked.
     */
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

    /**
     * Sets the global field score.
     * Increment score by 1 if the text value matches the correct value.
     */
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

    /**
     * Sets the global field score.
     * Increment score by 1 if the text value matches the correct value.
     */
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

    /**
     * Sets the global field score.
     * Increment score by 1 if the radio button with True value is checked.
     * If nothing is checked, shows a message to the user.
     */
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
        } else {
            Toast.makeText(this, getString(R.string.question4_toast), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * Sets the global field score.
     * Increment score by 1 if string and stringbuffer checkboxes are checked.
     */
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

    /**
     * Sets the global field score.
     * Increment score by 1 if the radio button with False value is checked.
     * If nothing is checked, shows a message to the user.
     */
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
        } else {
            Toast.makeText(this, getString(R.string.question6_toast), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * Shows the total score earned by the user.
     *
     * @param score total score
     */
    public void displayScore(int score) {
        Toast.makeText(this, getString(R.string.total_score_message, score), Toast.LENGTH_SHORT).show();
    }
}
