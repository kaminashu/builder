package www.uzmd.builder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import www.uzmd.builder.databinding.ActivitySingUpBinding

class SingUp_Activity : AppCompatActivity() {
    val db:LocalLocalDatabaseImpl by lazy {
        LocalLocalDatabaseImpl(this)
    }
    val list= mutableListOf<UserModel>()
    private lateinit var binding:ActivitySingUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivitySingUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            kirishBtn.setOnClickListener {
                if (parolEd.length()==4) {
                    if (parolEd.text.toString().equals(takroriyParol.text.toString())) {
                        var name = ismEdt.text.toString()
                        val userModel = UserModel(name = name, parol = parolEd.text.toString())
                        db.add(userModel)
                        val intent=Intent(this@SingUp_Activity,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SingUp_Activity, "Parol hatol", Toast.LENGTH_SHORT)
                            .show()
                    }
                }else {
                    Toast.makeText(
                        this@SingUp_Activity,
                        "parolga 4 ta raqam kiritish kerak",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}