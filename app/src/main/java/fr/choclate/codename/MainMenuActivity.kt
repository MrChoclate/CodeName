package fr.choclate.codename

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fr.choclate.codename.game.agent.AgentActivity
import kotlinx.android.synthetic.main.activity_main_menu.*


class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        playButton.setOnClickListener { onPlayClick() }
    }

    private fun onPlayClick() {
        val intent = Intent(this, AgentActivity::class.java)
        startActivity(intent)
    }
}
