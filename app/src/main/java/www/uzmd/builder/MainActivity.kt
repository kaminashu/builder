package www.uzmd.builder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.uzmd.builder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val db: LocalLocalDatabaseImpl by lazy {
        LocalLocalDatabaseImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = db.allList()
        if (list.isEmpty()) {
            val intent = Intent(this@MainActivity, SingUp_Activity::class.java)
            startActivity(intent)
        }

    }
}