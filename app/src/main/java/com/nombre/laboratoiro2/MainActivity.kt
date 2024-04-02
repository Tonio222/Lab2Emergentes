package com.nombre.laboratoiro2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(),ContadorListener {
    var fra1:BlankFragment1?=null
    var fra2:BlankFragment2?=null
    var fra3:BlankFragment3?=null
    var button:Button?=null
    var button2:Button?=null
    var button3:Button?=null
      var cont=0
    override fun incrementar() {
       cont++
    }

    override fun getValorActual(): Int {
    return cont
    }

    override fun reducir() {
        if(cont>0)cont--
        else cont=0
    }

    override fun resetar() {
        cont=0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val infla=menuInflater
        infla.inflate(R.menu.menutoolbar,menu)
        val searchItem = menu?.findItem(R.id.BuscarItem)
        val sv = searchItem?.actionView as? SearchView

        sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {

                val activity = sv.context as? MainActivity

                    Toast.makeText(activity, newText, Toast.LENGTH_SHORT).show()

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                val activity = sv.context as? MainActivity

                    Toast.makeText(activity, "Buscar: $query", Toast.LENGTH_SHORT).show()

                return true
            }
        })

        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemGuardar -> {
                Toast.makeText(this@MainActivity, "Hizo clic en guardar", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.itemajustes -> {
                Toast.makeText(this@MainActivity, "Hizo clic en ajustes", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    val toolbar=findViewById<Toolbar>(R.id.includeToolbar)
        setSupportActionBar(toolbar)



        fra1= BlankFragment1()
          fra1?.addContadorListener(this)
           fra2= BlankFragment2()
        fra2?.addContadorListener(this)
           fra3= BlankFragment3()
        fra3?.addContadorListener(this)
           button=findViewById(R.id.button)
           button2=findViewById(R.id.button2)
           button3=findViewById(R.id.button3)
           button?.setOnClickListener({
               Toast.makeText(this, "Abriendo Frag 1",Toast.LENGTH_SHORT).show()
               val transaction=getSupportFragmentManager().beginTransaction()
               transaction.replace(R.id.frameContenedor,fra1!!)
               transaction.commit()
           })
           button2?.setOnClickListener({
               Toast.makeText(this, "Abriendo Frag 2",Toast.LENGTH_SHORT).show()
               val transaction=getSupportFragmentManager().beginTransaction()
               transaction.replace(R.id.frameContenedor,fra2!!)
               transaction.commit()
           })
        button3?.setOnClickListener({
            Toast.makeText(this, "Abriendo Frag 3",Toast.LENGTH_SHORT).show()
            val transaction=getSupportFragmentManager().beginTransaction()
            transaction.replace(R.id.frameContenedor,fra3!!)
            transaction.commit()
        })
       }

}