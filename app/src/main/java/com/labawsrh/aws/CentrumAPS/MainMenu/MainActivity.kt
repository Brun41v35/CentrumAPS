package com.haerul.swipeviewpager

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.labawsrh.aws.CentrumAPS.R

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: ViewPager
    internal lateinit var adapter: Adapter
    internal lateinit var models: MutableList<Model>
    internal var colors: Array<Int>? = null
    internal var argbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models = ArrayList()
        models.add(Model(R.drawable.cartao, "Adicionar Cartão", "Adicione o cartão para organizarmos os seus gastos"))
        models.add(Model(R.drawable.buy, "Compras", "Aqui você irá visualizar todos os seus gastos"))
        models.add(Model(R.drawable.aa, "Metas", "Coloque aqui todas suas metas. Vamos ajudar você!!!"))

        adapter = Adapter(models, this)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        viewPager.setPadding(130, 0, 130, 0)

        val colors_temp = arrayOf(resources.getColor(R.color.color1), resources.getColor(R.color.color2), resources.getColor(R.color.color3))

        colors = colors_temp

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                if (position < adapter.count - 1 && position < colors!!.size - 1) {
                    viewPager.setBackgroundColor(
                            argbEvaluator.evaluate(
                                    positionOffset,
                                    colors!![position],
                                    colors!![position + 1]) as Int
                    )
                } else {
                    viewPager.setBackgroundColor(colors!![colors!!.size - 1])
                }
            }
            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}
