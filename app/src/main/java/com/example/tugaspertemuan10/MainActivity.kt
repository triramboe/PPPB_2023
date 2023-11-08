package com.example.tugaspertemuan10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapterFruits = FruitsAdapter (generateFruits()){
                fruits ->
            Toast.makeText(this@MainActivity, "You clicked on ${fruits.name}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, FruitsDetail::class.java)
            intent.putExtra("det_fruits", fruits)
            startActivity(intent)
        }

        with(binding){
            rvStudent.apply {
                adapter = adapterFruits
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruits(): List<Fruits> {
        return listOf(
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            Fruits(
                name = "Durian", binomialName = "Durio zibethinus", genus = "Durio", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Durio_Zibethinus_Van_Nooten.jpg/375px-Durio_Zibethinus_Van_Nooten.jpg", deskripsi = "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah \"raja dari segala buah\" (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagiannya kurang menyukai dengan aromanya.\n" +
                        "\n" +
                        "Tumbuhan dengan nama durian bukanlah spesies tunggal tetapi sekelompok tumbuhan dari genus Durio.[1] Namun, yang dimaksud dengan durian (tanpa imbuhan apa-apa) biasanya adalah Durio zibethinus. Jenis-jenis durian lain yang dapat dimakan dan kadang kala ditemukan di pasar tempatan di Asia Tenggara di antaranya adalah lai (D. kutejensis), kerantungan (D. oxleyanus), durian kura-kura atau kekura (D. graveolens), serta lahung (D. dulcis). Untuk selanjutnya, uraian di bawah ini mengacu kepada Durio zibethinus."),
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            Fruits(
                name = "Durian", binomialName = "Durio zibethinus", genus = "Durio", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Durio_Zibethinus_Van_Nooten.jpg/375px-Durio_Zibethinus_Van_Nooten.jpg", deskripsi = "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah \"raja dari segala buah\" (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagiannya kurang menyukai dengan aromanya.\n" +
                        "\n" +
                        "Tumbuhan dengan nama durian bukanlah spesies tunggal tetapi sekelompok tumbuhan dari genus Durio.[1] Namun, yang dimaksud dengan durian (tanpa imbuhan apa-apa) biasanya adalah Durio zibethinus. Jenis-jenis durian lain yang dapat dimakan dan kadang kala ditemukan di pasar tempatan di Asia Tenggara di antaranya adalah lai (D. kutejensis), kerantungan (D. oxleyanus), durian kura-kura atau kekura (D. graveolens), serta lahung (D. dulcis). Untuk selanjutnya, uraian di bawah ini mengacu kepada Durio zibethinus."),
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            Fruits(
                name = "Durian", binomialName = "Durio zibethinus", genus = "Durio", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Durio_Zibethinus_Van_Nooten.jpg/375px-Durio_Zibethinus_Van_Nooten.jpg", deskripsi = "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah \"raja dari segala buah\" (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagiannya kurang menyukai dengan aromanya.\n" +
                        "\n" +
                        "Tumbuhan dengan nama durian bukanlah spesies tunggal tetapi sekelompok tumbuhan dari genus Durio.[1] Namun, yang dimaksud dengan durian (tanpa imbuhan apa-apa) biasanya adalah Durio zibethinus. Jenis-jenis durian lain yang dapat dimakan dan kadang kala ditemukan di pasar tempatan di Asia Tenggara di antaranya adalah lai (D. kutejensis), kerantungan (D. oxleyanus), durian kura-kura atau kekura (D. graveolens), serta lahung (D. dulcis). Untuk selanjutnya, uraian di bawah ini mengacu kepada Durio zibethinus."),
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            Fruits(
                name = "Durian", binomialName = "Durio zibethinus", genus = "Durio", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/Durio_Zibethinus_Van_Nooten.jpg/375px-Durio_Zibethinus_Van_Nooten.jpg", deskripsi = "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah \"raja dari segala buah\" (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagiannya kurang menyukai dengan aromanya.\n" +
                        "\n" +
                        "Tumbuhan dengan nama durian bukanlah spesies tunggal tetapi sekelompok tumbuhan dari genus Durio.[1] Namun, yang dimaksud dengan durian (tanpa imbuhan apa-apa) biasanya adalah Durio zibethinus. Jenis-jenis durian lain yang dapat dimakan dan kadang kala ditemukan di pasar tempatan di Asia Tenggara di antaranya adalah lai (D. kutejensis), kerantungan (D. oxleyanus), durian kura-kura atau kekura (D. graveolens), serta lahung (D. dulcis). Untuk selanjutnya, uraian di bawah ini mengacu kepada Durio zibethinus."),
            Fruits(
                name = "Apel", binomialName = "Malus domestica", genus = "Malus", imgFruits = "https://infobuah.com/wp-content/uploads/2018/11/Buah-Apel.jpg", deskripsi = "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan siap dimakan, tetapi bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya. Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budi daya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar). Kebanyakan apel bagus dimakan mentah (tidak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel."),
            Fruits(
                name = "Jeruk bali", binomialName = "Citrus grandis", genus = "Citrus", imgFruits = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Pomelo_fruit.jpg/375px-Pomelo_fruit.jpg", deskripsi = "Jeruk bali, jeruk besar, atau pomelo (bahasa Inggris: pomelo, ilmiah: Citrus grandis, C. maxima) merupakan tanaman jeruk yang menghasilkan buah terbesar. Nama \"pomelo\" disarankan oleh Kementerian Pertanian karena jeruk ini tidak ada kaitannya dengan Provinsi Bali. Bobot buah jeruk bali bisa mencapai 1–2 kg. Daging buahnya berbulir dengan warna merah-oranye dan rasa yang cenderung terasa manis bercampur asam dan sedikit getir.\n" +
                        "\n" +
                        "Jeruk merupakan jenis tanaman yang mampu beradaptasi dengan baik pada daerah kering dan relatif tahan penyakit, terutama CVPD yang pernah menghancurkan pertanaman jeruk di Indonesia."),
            )
    }
}



