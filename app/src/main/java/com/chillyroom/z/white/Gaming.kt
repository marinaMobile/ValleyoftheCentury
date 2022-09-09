package com.chillyroom.z.white

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chillyroom.z.R

class Gaming : AppCompatActivity() {
    private lateinit var adapter: BoardAdapter
    private  lateinit var rvBoard: RecyclerView
    private lateinit var  tvNumPairs: TextView
    private lateinit var clRoot: ConstraintLayout
    private lateinit var game: Gamer
    private var boardSize: BoardSize = BoardSize.EASY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaming)
        clRoot = findViewById(R.id.constLayRoot)
        rvBoard = findViewById(R.id.rvBoard)
        tvNumPairs = findViewById(R.id.tvNumPairs)
        setUpBoard()

    }

    private fun setUpBoard() {
        when(boardSize){
            BoardSize.EASY->{
                tvNumPairs.text = "Pairs: 0 / 6"
            }
        }

        game = Gamer(boardSize)

        adapter =  BoardAdapter(this, boardSize, game.cards, object : BoardAdapter.CardClickListener{
            override fun onCardClicked(position: Int) {
                updateGameWithFlip(position)
            }

        })
        rvBoard.adapter = adapter
        rvBoard.setHasFixedSize(true);
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.getWidth())

    }

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    private fun updateGameWithFlip(position: Int) {

        if(game.flipperCard(position)){

            tvNumPairs.text = "Pairs: ${game.numPairsFound} / ${boardSize.getNumPairs()}"
            if(game.winGame()){
                startActivity(Intent(this, Finally::class.java))
                finish()
            }
        }

        adapter.notifyDataSetChanged()

    }
}