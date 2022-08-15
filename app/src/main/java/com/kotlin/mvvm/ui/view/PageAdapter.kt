package com.kotlin.mvvm.ui.view

import android.content.res.Resources
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kotlin.mvvm.ui.view.menu.FragmentFirst
import com.kotlin.mvvm.ui.view.menu.FragmentInsurance
import com.kotlin.mvvm.ui.view.menu.FragmentSecond
import com.kotlin.mvvm.ui.view.menu.FragmentVision

class PageAdapter( fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount()=4;

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0->{FragmentFirst()}
            1->{FragmentSecond()}
            2->{FragmentInsurance()}
            3->{FragmentVision()}
            else -> { throw Resources.NotFoundException("PS not")}
        }
    }

}