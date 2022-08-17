package com.kotlin.mvvm.ui.view.menu

//import com.kotlin.mvvm.databinding.ExampleMenuBinding
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kotlin.mvvm.databinding.MenuBinding
import com.kotlin.mvvm.ui.view.PageAdapter
import dagger.hilt.android.AndroidEntryPoint
import com.kotlin.mvvm.R

//import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MenuBinding
    private lateinit var labLayout : TabLayout
    private lateinit var viewPager : ViewPager2
    //private lateinit var bindmenu: ExampleMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

                //setSupportActionBar(toolbar)
        labLayout=findViewById(R.id.tab_layout)
        viewPager=findViewById(R.id.view_pager_2)
        viewPager.adapter = PageAdapter(this)
        TabLayoutMediator(labLayout, viewPager){ tab, index ->

            tab.customView =when(index){
                0-> {
                    val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.health_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Center"
                    view
                }
                1-> {
                    val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.pharmacy_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Pharmacy"
                    view}
                2-> {val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.insurance_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Insurance"
                    view}
                3-> {val view: View = layoutInflater.inflate(R.layout.menu_item, null)
                    view.findViewById<ImageView>(R.id.icon). background=resources.getDrawable(R.drawable.vision_selector,null)
                    view.findViewById<TextView>(R.id.item_title).text="Vision"
                    view}
                else -> { throw Resources.NotFoundException("PS not")}
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // bindmenu=ExampleMenuBinding.inflate(layoutInflater)
        //menuInflater.inflate(bindmenu.root)
        return true
    }
}