package com.example.yeojeong

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yeojeong.ApplicationClass.Yeojeong
import com.example.yeojeong.Retrofit.DirectionApiInterface
import com.example.yeojeong.Retrofit.DirectionApiModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapViewActivity : AppCompatActivity(), OnMapReadyCallback {
    private val TAG="MapViewActivity"
    var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_map_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (supportFragmentManager.findFragmentById(R.id.mapViewMap) as SupportMapFragment?)!!.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0

        val directionService: DirectionApiInterface = Yeojeong.retrofit.create(DirectionApiInterface::class.java)
        val call: Call<DirectionApiModel> = directionService.getDirection(
            "https://maps.googleapis.com/maps/api/directions/json",
            "37.549363,127.081813",
            "37.565538,126.801328",
            BuildConfig.GOOGLE_MAP_API_KEY
            ,"transit"
        )
        call.enqueue(object: Callback<DirectionApiModel> {
            override fun onResponse(
                call: Call<DirectionApiModel>,
                response: Response<DirectionApiModel>
            ) {
                //경로 불러오기 성공
                Log.d(TAG,"경로 불러오기 성공")
                Log.d(TAG,"발견한 경로: "+" "+response.body()!!.routes.size+"개")

                val polyLineOptions: PolylineOptions=PolylineOptions()
                    .width(5f)
                    .color(Color.RED)

                for(i in 0..<response.body()!!.routes.get(0).legs.get(0).steps.size){
                    val polyLine=PolyUtil.decode(response.body()!!.routes.get(0).legs.get(0).steps.get(i).polyline.points)
                    polyLineOptions.addAll(polyLine)
                    /*
                    간단 경로 표시 소스
                     */
                    //polyLineOptions.add(LatLng(response.body()!!.routes.get(0).legs.get(0).steps.get(i).startLocation.lat,
                        //response.body()!!.routes.get(0).legs.get(0).steps.get(i).startLocation.lng))
                    //polyLineOptions.add(LatLng(response.body()!!.routes.get(0).legs.get(0).steps.get(i).endLocation.lat,
                        //response.body()!!.routes.get(0).legs.get(0).steps.get(i).endLocation.lng))
                }

                googleMap!!.addPolyline(polyLineOptions)

            }

            override fun onFailure(call: Call<DirectionApiModel>, t: Throwable) {
                //경로 불러오기 실패
                Log.d(TAG,"경로 불러오기 실패: "+t.message.toString())
            }
        })
    }
}