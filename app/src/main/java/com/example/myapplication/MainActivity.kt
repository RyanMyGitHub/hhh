package com.example.myapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.GestureDetector
import android.view.GestureDetector.OnDoubleTapListener
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity() : AppCompatActivity(),
    GestureDetector.OnGestureListener{
    lateinit var txv: TextView
    lateinit var gDetector: GestureDetector
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv = findViewById(R.id.txv)
        txv.setTextColor(Color.parseColor("#eeee00"))
        txv.setBackgroundColor(Color.BLUE)
        txv.setTypeface(
            Typeface.createFromAsset(assets,
                "font/HanyiSentySong.ttf"))
        txv.getBackground().setAlpha(0) //0~255透明度值
        gDetector = GestureDetector(this, this)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {

        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        txv.text = "向左或向右滑!"

        return true
    }

    override fun onShowPress(p0: MotionEvent) {
        txv.text = "修但幾累..."
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        txv.text = "修但幾累..."

        return true
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float,
                          distanceY: Float): Boolean {

        if (distanceY >= 0){

            txv.text = "興趣:騎車、看小說、漫畫、動漫、逛街、電影\n\n"

        }

        else{

            txv.text = "個性:隨和、樂觀\n有興趣的話來交朋友吧!"

        }

        return true

    }

    override fun onLongPress(p0: MotionEvent) {
        txv.text = "你好!!按著?"
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float,
                         velocityY: Float): Boolean {

        if (e1.x <= e2.x){

            txv.text = "FB：吳致葦\nIG：ryan0613_\nE-mail：b0970126289@gmail.com"

            count++

            if(count>3){count=0}

        }

        else{

            txv.text = "此程式僅用於靜宜大學行動應用軟體開發"

            count--

            if(count<0){count=3}

        }

        var res:Int = getResources().getIdentifier("pu" + count.toString(),

            "drawable", getPackageName())

        findViewById<LinearLayout>(R.id.bg).setBackgroundResource(res)

        return true

    }
}