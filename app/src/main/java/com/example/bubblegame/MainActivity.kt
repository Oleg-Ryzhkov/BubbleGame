package com.example.bubblegame


import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.animate


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Schet = findViewById<TextView>(R.id.Schet)
        Schet.alpha = 0.0f

        val bubble = findViewById<View>(R.id.Bubble)
        bubble.alpha = 0.0f
        val textView = findViewById<TextView>(R.id.Timer)
        textView.alpha = 0.0f

        val textView2 = findViewById<TextView>(R.id.SchetNum)
        textView2.alpha = 0.0f

    }

    fun OnClick(View: View) {

        val Button = findViewById<Button>(R.id.button)
        Button.alpha = 0.0f
        animate(Button).translationX(1000.toFloat())

        val Timer = findViewById<TextView>(R.id.Timer)
        Timer.alpha = 1.0f

        val bubble = findViewById<View>(R.id.Bubble)
        bubble.alpha = 1.0f

        val Schet = findViewById<TextView>(R.id.Schet)
        Schet.alpha = 1.0f

        val Result = findViewById<TextView>(R.id.Result)

        val SchetNum = findViewById<TextView>(R.id.SchetNum)
        SchetNum.alpha = 1.0f

        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                Timer.setText("Времени осталось " + millisUntilFinished / 1000)
            }

            override fun onFinish() {

                Result.setText("Результат:")

                Schet.alpha = 0.0f
                bubble.alpha = 0.0f
                Timer.alpha = 0.0f
                animate(bubble).translationY(800.toFloat())
                animate(SchetNum).translationY(835.toFloat())
                animate(SchetNum).translationX(320.toFloat())
            }
        }.start()


    }

    fun onClickTest(v: View) {

        val a: Array<Int> = arrayOf(-300, -200, -100, 0, 100, 200, 300, 400)

        val b: Array<Int> = arrayOf(-300, -200, -100, 0, 100, 200, 300, 400, 500, 600, 700, 800)
        a.shuffle()
        b.shuffle()


        val bubble = findViewById<View>(R.id.Bubble)


        animate(bubble).translationX(a[0].toFloat())
        animate(bubble).translationY(b[0].toFloat())

        val SchetNum = findViewById<TextView>(R.id.SchetNum)
        val currentText = SchetNum.text.toString()
        val currentNumber = currentText.toInt()
        SchetNum.text = currentNumber.plus(1).toString()


        bubble.alpha = 0.0f
        bubble.animate().apply {
            interpolator = LinearInterpolator()
            duration = 0
            alpha(1f)
            startDelay = 0
            start()


        }

    }
}








