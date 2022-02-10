package com.b12game.recyclerviewcustomadapterwithheaderandfooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b12game.recyclerviewcustomadapterwithheaderandfooter.adapter.CustomAdapter
import com.b12game.recyclerviewcustomadapterwithheaderandfooter.model.Member

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        val member = prepareMemberList()
        refreshAdapter(member)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView!!.adapter = adapter
    }

    fun prepareMemberList(): ArrayList<Member> {
        val member = ArrayList<Member>()
        member.add(Member("", "", false))

        for (i in 0..30){
            if(i == 1 || i == 5 || i == 10 || i == 15 || i == 25){
                member.add(Member("Javlonbek"+i,"Sobirov"+i,false))
            }else
                member.add(Member("Jonny"+i,"Rosy"+i,true))
        }
       member.add(Member("","",false))
            return member
    }


}



