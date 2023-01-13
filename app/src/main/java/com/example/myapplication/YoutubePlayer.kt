package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.internal.t
import android.util.Log
import android.widget.Toast
import com.google.android.youtube.player.*

class YoutubePlayer : AppCompatActivity(), YouTubePlayer.OnInitializedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_player_activity_api)

        val youTubePlayerFragment =
                supportFragmentManager.findFragmentById(R.id.official_player_view) as YouTubePlayerSupportFragmentX
        youTubePlayerFragment.initialize("YOUR_API_KEY", this)
    }

    override fun onInitializationSuccess(
            provider: YouTubePlayer.Provider,
            youTubePlayer: YouTubePlayer,
            wasRestored: Boolean
    ) {
        if (!wasRestored) {
            youTubePlayer.cueVideo("7iBmZbSnI-E")
        }
    }


    override fun onInitializationFailure(
            provider: YouTubePlayer.Provider,
            youTubeInitializationResult: YouTubeInitializationResult
    ) {
        if (youTubeInitializationResult.isUserRecoverableError) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show()
        } else {
            val errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1\$s)",
                    youTubeInitializationResult.toString()
            )
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val RECOVERY_DIALOG_REQUEST = 1
    }
}