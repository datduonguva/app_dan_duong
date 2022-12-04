package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.util.Log.w
import java.util.logging.Logger

class PlayNameSound (val indices: List<Int>, val context: Context): Thread(){

    public override fun run(){
        val soundMap = mapOf(
            0 to R.raw.nguoi,
            1 to R.raw.xe_dap,
            2 to R.raw.xe_o_to,
            3 to R.raw.xe_may,
            5 to R.raw.xe_buyt,
            6 to R.raw.tau_hoa,
            7 to R.raw.xe_tai,
            9 to R.raw.den_giao_thong,
            16 to R.raw.dong_vat_meo,
            17 to R.raw.dong_vat_cho,
            20 to R.raw.dong_vat_bo
        )

        val players = indices.map {it -> MediaPlayer.create(context, soundMap.get(it)!!)}

        for (player in players){
            player.start()
            Thread.sleep(200)
            while(player.isPlaying){
                Thread.sleep(50)
            }
            Log.w("Tengoi", "chuan bi goi Stop")

            player.stop()

            Log.w("Tengoi", "Chuan bi goi release")
            player.release()

            Log.w("Tengoi", "Xong")
        }
    }


}