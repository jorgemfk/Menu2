package com.kotlin.mvvm.ui.view.menu

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.viewpager2.widget.ViewPager2
import com.kotlin.mvvm.R
//import com.kotlin.mvvm.databinding.ExampleMenuBinding
import com.kotlin.mvvm.databinding.MenuBinding
import com.kotlin.mvvm.ui.view.PageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

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
            tab.text = when(index){
                0-> {"Center"}
                1-> {"Pharmacy"}
                2-> {"Insurance"}
                3-> {"Vision"}
                else -> { throw Resources.NotFoundException("PS not")}
            }
            tab.icon= when(index){
                0-> {resources.getDrawable(R.drawable.health_selector,null)}
                1-> {resources.getDrawable(R.drawable.pharmacy_selector,null)}
                2-> {resources.getDrawable(R.drawable.insurance_selector,null)}
                3-> {resources.getDrawable(R.drawable.vision_selector,null)}
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