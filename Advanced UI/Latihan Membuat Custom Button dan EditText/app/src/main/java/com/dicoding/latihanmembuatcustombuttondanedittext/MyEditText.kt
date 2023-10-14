package com.dicoding.latihanmembuatcustombuttondanedittext

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

class MyEditText : AppCompatEditText, View.OnTouchListener {
    private lateinit var ClearImageButton: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Masukkan nama Anda"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun init() {
        ClearImageButton =
            ContextCompat.getDrawable(context, R.drawable.baseline_close_24) as Drawable
        setOnTouchListener(this)
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty())showClearButton() else hideClearButton()
            }

            override fun afterTextChanged(s: Editable?) {
                //
            }

        })

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        if (compoundDrawables[2] != null) {
            val clearButtonStart: Float
            val clearButtonEnd: Float
            var isClearButtonClicked = false

            if (layoutDirection == View.LAYOUT_DIRECTION_LTR) {
                clearButtonEnd = (ClearImageButton.intrinsicWidth + paddingStart).toFloat()
                if (event != null) {
                    when {
                        event.x < clearButtonEnd -> isClearButtonClicked = true
                    }
                }
            } else {
                clearButtonStart = (width - paddingEnd - ClearImageButton.intrinsicWidth).toFloat()

                if (event != null) {
                    when {
                        event.x > clearButtonStart -> isClearButtonClicked = true
                    }
                }
            }
            if (isClearButtonClicked) {
                if (event != null) {
                    when (event.action) {
                        MotionEvent.ACTION_DOWN -> {
                            ClearImageButton = ContextCompat.getDrawable(
                                context,
                                R.drawable.baseline_close_24
                            ) as Drawable
                            showClearButton()
                            return true
                        }

                        MotionEvent.ACTION_UP -> {
                            ClearImageButton = ContextCompat.getDrawable(
                                context,
                                R.drawable.baseline_close_24
                            ) as Drawable
                            when {
                                text != null -> text?.clear()
                            }
                            hideClearButton()
                            return true
                        }

                        else -> return false
                    }
                }
            } else return false

        }

        return false
    }

    //     kode untuk aksi ketika tombol clear diklik
    private fun showClearButton() {
        setButtonDrawable(endOfTheText = ClearImageButton)
    }

    private fun setButtonDrawable(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )

    }

    private fun hideClearButton() {
        setButtonDrawable()
    }
}