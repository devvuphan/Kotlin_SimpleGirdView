package vuphan.android.kotlin_simplegirdview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vuphan.android.kotlin_simplegirdview.AnimalAdapter.ItemClickListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val arrString: ArrayList<AnimalEntity> = arrayListOf()
        arrString.add(AnimalEntity(0, "Ani 1","https://www.activewild.com/wp-content/uploads/2015/03/List-Of-Endangered-Animals-African-Wild-Dog.jpg"))
        arrString.add(AnimalEntity(0, "Ani 2","https://www.activewild.com/wp-content/uploads/2015/03/Amur-Leopard.jpg"))
        arrString.add(AnimalEntity(1, "Ani 3","https://www.activewild.com/wp-content/uploads/2015/02/Asian-Elephant.jpg"))
        arrString.add(AnimalEntity(2, "Ani 4","https://www.activewild.com/wp-content/uploads/2016/12/Axolotl-Facts-For-Kids.jpg"))
        arrString.add(AnimalEntity(3, "Ani 5","https://www.activewild.com/wp-content/uploads/2015/02/Black-Rhino.jpg"))
        arrString.add(AnimalEntity(4, "Ani 6","https://www.activewild.com/wp-content/uploads/2015/03/Black-footed-Ferret.jpg"))
        arrString.add(AnimalEntity(5, "Ani 7","https://www.activewild.com/wp-content/uploads/2015/02/Blue-Whale-Swimming.jpg"))
        arrString.add(AnimalEntity(6, "Ani 8","https://www.activewild.com/wp-content/uploads/2015/03/Bonobo-Endangered-Animal.jpg"))
        arrString.add(AnimalEntity(7, "Ani 9","https://www.activewild.com/wp-content/uploads/2015/02/Chimpanzee-Facts.jpg"))
        arrString.add(AnimalEntity(8, "Ani 10","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Balaenoptera_physalus_Saint-Laurent_02.jpg/1024px-Balaenoptera_physalus_Saint-Laurent_02.jpg"))
        arrString.add(AnimalEntity(9, "Ani 11","https://www.activewild.com/wp-content/uploads/2015/03/Galapagos-Penguin.jpg"))

        rvAnimals.layoutManager = GridLayoutManager(this, 2)
        rvAnimals.adapter = AnimalAdapter(this, arrString)
        (rvAnimals.adapter as AnimalAdapter).setClickListener(object : ItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, (rvAnimals.adapter as AnimalAdapter).getItem(position)!!.name, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
