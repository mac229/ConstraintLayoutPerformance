package com.maciejkozlowski.constraintlayoutperformance

import android.support.annotation.LayoutRes
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.system.measureNanoTime

@RunWith(AndroidJUnit4::class)
class LayoutTest {

    private val layoutInflater by lazy { LayoutInflater.from(getInstrumentation().targetContext) }

    @Test
    fun test_item1() {
        Log.i(TAG, "item 1")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.item1_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.item1_linear)}")
    }

    @Test
    fun test_item2() {
        Log.i(TAG, "item 2")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.item2_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.item2_linear)}")
        Log.i(TAG, "$FRAME ${measureTime(R.layout.item2_frame)}")
    }

    @Test
    fun test_item3() {
        Log.i(TAG, "item 3")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.item3_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.item3_linear)}")
        Log.i(TAG, "$RELATIVE ${measureTime(R.layout.item3_relative)}")
    }

    @Test
    fun test_item4() {
        Log.i(TAG, "item 4")
        Log.i(TAG, "$CONSTRAINT ${measureTime(R.layout.item4_constraint)}")
        Log.i(TAG, "$LINEAR ${measureTime(R.layout.item4_linear)}")
    }

    private fun measureTime(@LayoutRes layoutRes: Int): Long {
        return measureTimeInNano(layoutRes) / REPEATS
    }

    private fun measureTimeInNano(@LayoutRes layoutRes: Int) = measureNanoTime {
        for (i in 0 until REPEATS) {
            layoutInflater.inflate(layoutRes, null).apply {
                layoutParams = ViewGroup.LayoutParams(0, 0)
                measure(View.MeasureSpec.makeMeasureSpec(1000, View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
                layout(0, 0, measuredWidth, measuredHeight)
            }
        }
    }

    companion object {
        private const val TAG = "###test"

        private const val REPEATS = 1_000

        private const val LINEAR = "linear:\t\t"
        private const val FRAME = "frame:\t\t\t"
        private const val RELATIVE = "relative:\t\t"
        private const val CONSTRAINT = "constraint:\t"
    }
}
