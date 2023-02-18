package com.nise.favor_android.Home.Search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.nise.favor_android.Login.LoginActivity
import com.nise.favor_android.R
import com.nise.favor_android.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(KeywordFragment())
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                replaceFragment(SearchViewFragment())
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
    fun onHomeClicked(view:View) = onBackPressedDispatcher.onBackPressed()

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransacion = fragmentManager.beginTransaction()
        fragmentTransacion.replace(R.id.searchFrame,fragment)
        fragmentTransacion.commit()
    }
}