package com.example.word

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.word.fragment.Fragment1
import com.example.word.fragment.Fragment3
import com.example.word.fragment.Fragment4
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_page.*
import com.example.word.fragment.Fragment2
import kotlinx.android.synthetic.main.alert_popup.*
import kotlinx.android.synthetic.main.drawer_toolbar.*
import kotlin.math.log

class MainPage : AppCompatActivity()
    ,BottomNavigationView.OnNavigationItemSelectedListener{     // bottom navigation view

    // navigation drawer의 drawerLayout과 NavigationView을 이용하기 위한 변수
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    // 로그아웃 구현을 위한 변수
    var auth : FirebaseAuth?= null
    var googleSignInClient : GoogleSignInClient?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val toolbar: Toolbar = findViewById(R.id.toolbar) // toolBar를 통해 App Bar 생성
        setSupportActionBar(toolbar) // 툴바 적용
        supportActionBar?.setDisplayShowTitleEnabled(false) // 툴바에 타이틀 안보이게
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.frame_lay, Fragment1()).commit()

        logout_btn.setOnClickListener { alertShow() }
    }

    // alertDialog
    private fun alertShow() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_popup, null)
        val logoutText = view.findViewById<TextView>(R.id.alert_text)
        logoutText.text = "로그아웃 하시겠습니까?"    // 메인 텍스트

        // 버튼 생성
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("로그아웃")
            .setNegativeButton("예") { dialog, which ->
                logout()
                Toast.makeText(applicationContext,"로그아웃 되었습니다.",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("아니요", null)
            .create()
        alertDialog.setView(view)
        alertDialog.show()
    }

    // 로그아웃 구현
    private fun logout() {
        // 구글 로그아웃을 위해 로그인 세션 가져오기
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // firebaseauth를 사용하기 위한 인스턴스 get
        auth = FirebaseAuth.getInstance()

        // 구글 로그아웃 버튼 클릭 시 이벤트
        Toast.makeText(this,"로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
        FirebaseAuth.getInstance().signOut()
        googleSignInClient?.signOut()

        val logoutIntent = Intent (this, MainActivity::class.java)
        logoutIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(logoutIntent)
    }

    // bottom navigation view 클릭 이벤트
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val text = findViewById<TextView>(R.id.toolbar_text)
        when(item.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_lay, Fragment1())
                    .commitAllowingStateLoss()
                text.text = "(word장)홈"
                return true
            }
            R.id.word -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_lay, Fragment2())
                    .commitAllowingStateLoss()
                text.text = "(word장)단어"
                return true
            }
            R.id.memo -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_lay, Fragment3())
                    .commitAllowingStateLoss()
                text.text = "(word장)메모"
                return true
            }
            R.id.profile -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_lay, Fragment4())
                    .commitAllowingStateLoss()
                text.text = "(word장)프로필"
                return true
            }
        }
        return false
    }
}
