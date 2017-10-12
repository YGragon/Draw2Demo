package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nAller_Dong";

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.drawText(text, 50, 100, textPaint);

        /**
         * StaticLayout(CharSequence source, TextPaint paint, int width, Alignment align, float spacingmult, float spacingadd, boolean includepad)
         *
         * StaticLayout是android中处理文字换行的一个工具类，StaticLayout已经实现了文本绘制换行处理
         *
         * 参数含义：
         *      source: 需要分行的字符串
         *      paint: 画笔对象
         *      width:  layout的宽度，字符串超过自动换行
         *      align:  layout的对其方式，有ALIGN_CENTER， ALIGN_NORMAL， ALIGN_OPPOSITE 三种
         *      spacingmult:    相对行间距，相对字体大小，1.5f表示行间距为1.5倍的字体高度
         *      spacingadd:     在基础行距上添加多少间距，实际行间距等于这两者的和
         *      includepad:     是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界
         */
        StaticLayout layout = new StaticLayout(text, textPaint, 500, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        layout.draw(canvas);
    }
}
