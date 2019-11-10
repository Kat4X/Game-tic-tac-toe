package com.fox.gametictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var player1: ArrayList<Int> = ArrayList()
    var player2: ArrayList<Int> = ArrayList()
    var currentPlayer = player1
    var win = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cell_1.setOnClickListener(this)
        cell_2.setOnClickListener(this)
        cell_3.setOnClickListener(this)
        cell_4.setOnClickListener(this)
        cell_5.setOnClickListener(this)
        cell_6.setOnClickListener(this)
        cell_7.setOnClickListener(this)
        cell_8.setOnClickListener(this)
        cell_9.setOnClickListener(this)
        game_remake_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val button = v as Button
        when (v.id) {
            R.id.cell_1 -> gamePoint(1, button)
            R.id.cell_2 -> gamePoint(2, button)
            R.id.cell_3 -> gamePoint(3, button)
            R.id.cell_4 -> gamePoint(4, button)
            R.id.cell_5 -> gamePoint(5, button)
            R.id.cell_6 -> gamePoint(6, button)
            R.id.cell_7 -> gamePoint(7, button)
            R.id.cell_8 -> gamePoint(8, button)
            R.id.cell_9 -> gamePoint(9, button)
            R.id.game_remake_button -> startActivity(intent)
        }
    }

    private fun gamePoint(cellId: Int, button: Button) {
        if (currentPlayer == player1) {
            player1.add(cellId)
            button.text = "X"
            isWin(player1, 1)
            currentPlayer = player2
            for (item in player1) {
                println("Player: ALEX item: $item")
            }
        } else {
            player2.add(cellId)
            button.text = "O"
            isWin(player2, 2)
            currentPlayer = player1
            for (item in player2) {
                println("Player: ALICA item: $item")
            }
        }
        button.isClickable = false
    }

    private fun isWin(player: ArrayList<Int>, whoWin: Int) {
        if (player.contains(1) &&
            player.contains(2) &&
            player.contains(3)
        ) {
            win = true
        }

        if (player.contains(4) &&
            player.contains(5) &&
            player.contains(6)
        ) {
            win = true
        }
        if (player.contains(7) &&
            player.contains(8) &&
            player.contains(9)
        ) {
            win = true
        }
        if (player.contains(1) &&
            player.contains(5) &&
            player.contains(9)
        ) {
            win = true
        }
        if (player.contains(3) &&
            player.contains(5) &&
            player.contains(7)
        ) {
            win = true
        }
        if (player.contains(1) &&
            player.contains(4) &&
            player.contains(7)
        ) {
            win = true
        }
        if (player.contains(2) &&
            player.contains(5) &&
            player.contains(8)
        ) {
            win = true
        }

        if (player.contains(3) &&
            player.contains(6) &&
            player.contains(9)
        ) {
            win = true
        }

        if (win) {
            if (whoWin == 1){
                println("Alex is WIN!")
                Toast.makeText(this, "Alex Win!", Toast.LENGTH_SHORT).show()
                player.clear()
            }
            if (whoWin == 2){
                println("Ara is WIN!!!!")
                Toast.makeText(this, "Ara Win!", Toast.LENGTH_SHORT).show()
                player.clear()
            }
        }
    }
}
