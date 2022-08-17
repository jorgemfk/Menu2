package com.kotlin.mvvm.ui.view.menu

//import com.kotlin.mvvm.databinding.ExampleMenuBinding
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kotlin.mvvm.R
import com.kotlin.mvvm.databinding.MenuBinding
import com.kotlin.mvvm.ui.view.PageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MenuBinding
    private lateinit var labLayout : TabLayout
    private lateinit var viewPager : ViewPager2
    //private lateinit var bindmenu: ExampleMenuBinding
    private val scroller by lazy { findViewById<NestedScrollView>(R.id.scroller) }
    private val linear by lazy { findViewById<LinearLayout>(R.id. lin_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

                //setSupportActionBar(toolbar)
        labLayout=findViewById(R.id.tab_layout)
        viewPager=findViewById(R.id.view_pager_2)
        viewPager.adapter = PageAdapter(this)
        val mViews = ArrayList<View>()
        TabLayoutMediator(labLayout, viewPager){ tab, index ->

            tab.customView =when(index){
                0-> {
                    val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.health_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Center"
                    mViews.add(view)
                    view
                }
                1-> {
                    val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.pharmacy_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Pharmacy"
                    mViews.add(view)
                    view}
                2-> {val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.insurance_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Insurance"
                    mViews.add(view)
                    view}
                3-> {val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.vision_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Vision"
                    mViews.add(view)
                    view}
                else -> { throw Resources.NotFoundException("PS not")}
            }
        }.attach()

        scroller.viewTreeObserver.addOnScrollChangedListener {


            GlobalScope.launch(Dispatchers.Main){
                val scrollY: Int = scroller.getScrollY() // For ScrollView
                val scrollX: Int = scroller.getScrollX() // For HorizontalScrollView

                if (scrollY>0){
                    labLayout.animate().scaleY(0.7f).scaleX(0.7f).translationY((-labLayout.height/6).toFloat()).translationX((-labLayout.width/6).toFloat())
                    mViews.forEach { i-> i.findViewById<TextView>(R.id.item_title).visibility=View.GONE }

                }
                if (scrollY==0){
                    labLayout.animate().scaleX(1f).scaleY(1f).translationY(0f).translationX(0f)
                    mViews.forEach { i-> i.findViewById<TextView>(R.id.item_title).visibility=View.VISIBLE }

                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // bindmenu=ExampleMenuBinding.inflate(layoutInflater)
        //menuInflater.inflate(bindmenu.root)
        return true
    }
}