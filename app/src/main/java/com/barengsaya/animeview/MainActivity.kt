package com.barengsaya.animeview

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        val articles = listOf(
            Article(
                "Naruto",
                "Naruto, mengikuti perjalanan Naruto Uzumaki, seorang ninja muda yang bercita-cita menjadi Hokage, pemimpin ...",
                R.drawable.naruto,
                "Naruto, mengikuti perjalanan Naruto Uzumaki, seorang ninja muda yang bercita-cita menjadi Hokage, pemimpin desa, meskipun dijauhi karena memiliki Rubah Berekor Sembilan di dalam dirinya.\nDia bersama teman-temannya, Sasuke Uchiha dan Sakura Haruno, menjalani berbagai misi dan menghadapi ancaman berbahaya, termasuk dari Orochimaru dan organisasi Akatsuki yang mengincar bijuu.\nSasuke, terobsesi dengan balas dendam, meninggalkan desa, sementara Naruto berlatih keras untuk membawanya kembali. \nPerang Dunia Ninja Keempat melawan Madara Uchiha dan Kaguya Otsutsuki mengancam dunia, tetapi Naruto dan Sasuke akhirnya bersatu untuk mengalahkan mereka. \nSetelah pertarungan terakhirnya dengan Sasuke, Naruto berhasil mewujudkan mimpinya menjadi Hokage dan membawa perdamaian ke dunia shinobi.\n"
            ),
            Article(
                "My Hero Academia",
                "My Hero Academia, berkisah tentang Izuku Midoriya, seorang remaja tanpa kekuatan super (quirk) di dunia di mana ...",
                R.drawable.myheroacademia,
                "My Hero Academia, berkisah tentang Izuku Midoriya, seorang remaja tanpa kekuatan super (quirk) di dunia di mana hampir semua orang memilikinya. \nMeskipun awalnya tidak memiliki kekuatan, Izuku bermimpi menjadi pahlawan seperti idolanya, All Might, pahlawan nomor satu. \nNasibnya berubah ketika All Might memilihnya sebagai penerus dan memberinya quirk bernama One For All. \nIzuku kemudian masuk ke UA High School, akademi untuk calon pahlawan, di mana ia dan teman-temannya belajar mengendalikan kekuatan mereka sambil menghadapi berbagai ancaman dari penjahat, termasuk organisasi League of Villains yang dipimpin oleh Tomura Shigaraki. \nSeiring berjalannya waktu, Izuku tumbuh menjadi pahlawan yang lebih kuat, menghadapi berbagai musuh, dan mengungkap rahasia gelap tentang asal usul quirk dan hubungan antara One For All dan All For One, penjahat terbesar di dunia."
            ),
            Article(
                "Attack on Titan",
                "Attack on Titan mengikuti cerita Eren Yeager, yang hidup di dunia di mana umat manusia berada di ambang ...",
                R.drawable.attackontitan,
                "Attack on Titan mengikuti cerita Eren Yeager, yang hidup di dunia di mana umat manusia berada di ambang kepunahan akibat serangan para Titan, makhluk raksasa pemakan manusia. \nSetelah desanya dihancurkan dan ibunya dibunuh oleh Titan, Eren bersumpah untuk memusnahkan semua Titan. \nBersama teman-temannya, Mikasa Ackerman dan Armin Arlert, Eren bergabung dengan Survey Corps, kelompok militer yang berjuang melawan para Titan. \nSeiring waktu, mereka menemukan bahwa para Titan tidak hanya ancaman eksternal, tetapi ada konspirasi lebih besar di balik asal usul Titan dan sejarah tersembunyi dari umat manusia. \nEren kemudian memperoleh kekuatan Titan dan terlibat dalam pertempuran epik, yang akhirnya memunculkan konflik lebih besar antara Pulau Paradis dan dunia luar, serta mengungkap rahasia tentang kebebasan, perang, dan takdir umat manusia."
            ),
            Article(
                "Fullmetal Alchemist: Brotherhood",
                "Fullmetal Alchemist: Brotherhood, menceritakan kisah Edward dan Alphonse ...",
                R.drawable.fullmetalalchemistbrotherhood,
                "Fullmetal Alchemist: Brotherhood, menceritakan kisah Edward dan Alphonse Elric, dua saudara alkemis yang mencoba menghidupkan kembali ibu mereka menggunakan alkimia terlarang, tetapi gagal dan mengalami konsekuensi tragis: Edward kehilangan lengan dan kaki, sementara Alphonse kehilangan seluruh tubuhnya dan jiwanya terikat pada baju zirah. \nMereka memulai perjalanan untuk mencari Batu Bertuah, artefak kuat yang dapat memulihkan tubuh mereka. \nDalam pencarian tersebut, mereka terlibat dalam konspirasi besar yang melibatkan pemerintah, rahasia gelap alkimia, dan makhluk mengerikan bernama Homunculus. \nSeiring perjalanan mereka, Edward dan Alphonse menyadari pentingnya pengorbanan dan batas moral dalam pencarian kekuatan. \nAkhirnya, mereka harus menghadapi pilihan yang menentukan nasib mereka dan dunia."
            ),
            Article(
                "Death Note",
                "Death Note berkisah tentang Light Yagami, seorang siswa jenius yang menemukan buku supernatural bernama ...",
                R.drawable.deathnote,
                "Death Note berkisah tentang Light Yagami, seorang siswa jenius yang menemukan buku supernatural bernama Death Note, yang memungkinkan pemiliknya membunuh siapa pun hanya dengan menuliskan nama mereka di dalamnya. \nLight memutuskan untuk menggunakan Death Note untuk membunuh penjahat dan menciptakan dunia yang ideal, di mana ia berkuasa sebagai dewa. \nNamun, aksinya menarik perhatian L, seorang detektif jenius yang berusaha mengungkap identitas Light dan menghentikannya. \nPertarungan psikologis antara Light dan L semakin intens, dengan intrik, manipulasi, dan strategi yang semakin rumit. \nSeiring berjalannya waktu, Light semakin terjerumus dalam ambisi dan kesombongannya, hingga akhirnya konsekuensi dari tindakannya menghancurkan hidupnya sendiri."
            ),
            Article(
                "Demon Slayer (Kimetsu no Yaiba)",
                "Demon Slayer (Kimetsu no Yaiba) mengikuti kisah Tanjiro Kamado, seorang pemuda baik ...",
                R.drawable.demonslayer,
                "Demon Slayer (Kimetsu no Yaiba) mengikuti kisah Tanjiro Kamado, seorang pemuda baik hati yang hidupnya berubah drastis ketika keluarganya dibantai oleh iblis, dan adiknya Nezuko berubah menjadi iblis. \nTanjiro bertekad mencari cara untuk menyembuhkan Nezuko dan membalas dendam pada iblis yang menghancurkan keluarganya. \nDia bergabung dengan Korps Pembasmi Iblis, organisasi yang melatih pembasmi iblis, dan menghadapi berbagai iblis kuat dalam perjalanannya. \nBersama teman-teman barunya, Zenitsu dan Inosuke, Tanjiro harus menghadapi ancaman dari Muzan Kibutsuji, raja iblis yang menciptakan semua iblis, sambil terus berusaha melindungi adiknya dan mencari jalan untuk mengakhiri teror para iblis."
            ),
            Article(
                "Steins:Gate",
                "Steins:Gate mengikuti kisah Rintarou Okabe, seorang ilmuwan eksentrik yang tanpa sengaja menemukan cara ...",
                R.drawable.steinsgate,
                "Steins:Gate mengikuti kisah Rintarou Okabe, seorang ilmuwan eksentrik yang tanpa sengaja menemukan cara untuk mengirim pesan teks ke masa lalu menggunakan microwave yang dimodifikasi. \nBersama teman-temannya, Mayuri dan Daru, Okabe bereksperimen dengan time travel ini, tetapi segera menyadari bahwa setiap perubahan kecil pada masa lalu membawa konsekuensi besar dan berbahaya di masa depan. \nSaat Okabe terjebak dalam kekacauan perjalanan waktu, ia harus berjuang untuk menyelamatkan orang-orang yang ia cintai, terutama setelah bertemu dengan ilmuwan jenius Kurisu Makise. \nCerita berkembang menjadi perjuangan emosional untuk memperbaiki masa depan yang terus berubah dan menghindari tragedi yang tampaknya tak terhindarkan."
            ),
            Article(
                "One Punch Man",
                "One Punch Man berkisah tentang Saitama, seorang pahlawan yang bisa mengalahkan musuh ...",
                R.drawable.onepunchman,
                "One Punch Man berkisah tentang Saitama, seorang pahlawan yang bisa mengalahkan musuh apa pun dengan satu pukulan. \nMeskipun memiliki kekuatan luar biasa, Saitama merasa bosan dan tidak puas karena tidak ada lawan yang mampu menantangnya. \nDia bergabung dengan Asosiasi Pahlawan untuk mencari musuh yang lebih kuat, tetapi sering kali tidak diakui meskipun kemampuannya luar biasa. \nBersama dengan muridnya, Genos, seorang cyborg, Saitama menghadapi berbagai monster dan ancaman global, sambil mencari arti sebenarnya dari menjadi seorang pahlawan. \nCerita ini dipenuhi dengan aksi epik dan humor, mengeksplorasi bagaimana seorang pahlawan super berurusan dengan kebosanan dan eksistensialisme."
            ),
            Article(
                "Neon Genesis Evangelion",
                "Neon Genesis Evangelion mengikuti kisah Shinji Ikari, seorang remaja yang dipanggil oleh organisasi NERV untuk ...",
                R.drawable.neongenesisevangelion,
                "Neon Genesis Evangelion mengikuti kisah Shinji Ikari, seorang remaja yang dipanggil oleh organisasi NERV untuk mengendalikan Evangelion, robot raksasa yang digunakan untuk melawan makhluk misterius bernama Angels yang mengancam umat manusia. \nDalam perjalanannya, Shinji berjuang dengan rasa kesepian, tekanan dari ayahnya, Gendo Ikari, yang memimpin NERV, serta konflik emosional dengan rekan-rekannya, termasuk Rei Ayanami dan Asuka Langley Soryu. \nSeiring pertarungan melawan Angels berlangsung, Shinji dan pilot lainnya mulai menghadapi pertanyaan mendalam tentang identitas, hubungan antar manusia, dan eksistensi. \nSeri ini dipenuhi dengan simbolisme psikologis dan filosofi yang rumit, menyajikan tema-tema tentang isolasi, trauma, dan pencarian makna dalam hidup."
            ),
            Article(
                "Hunter x Hunter",
                "Hunter x Hunter mengikuti petualangan Gon Freecss, seorang anak muda yang bercita-cita menjadi Hunter ...",
                R.drawable.hunterxhunter,
                "Hunter x Hunter mengikuti petualangan Gon Freecss, seorang anak muda yang bercita-cita menjadi Hunter, seorang petualang terlatih yang dapat melakukan hal-hal luar biasa seperti menemukan harta karun dan menangkap makhluk langka. \nGon ingin menemukan ayahnya, Ging Freecss, yang juga seorang Hunter. \nDalam perjalanannya, ia bertemu dengan teman-teman seperti Killua Zoldyck, seorang pembunuh berbakat dari keluarga terkenal; Kurapika, yang mencari balas dendam atas pembantaian klan; dan Leorio Paradinight, yang bercita-cita menjadi dokter. \nBersama-sama, mereka menghadapi berbagai tantangan, mulai dari ujian Hunter yang berbahaya hingga pertempuran melawan organisasi kriminal, Phantom Troupe. \nSelama perjalanan, mereka mengembangkan kemampuan unik dan menghadapi konflik internal, sambil menjelajahi dunia yang penuh dengan kekuatan, misteri, dan petualangan."
            )

        )

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ArticleAdapter(articles)

        // Tombol About
        val aboutButton: ImageButton = findViewById(R.id.icon_about)
        aboutButton.setOnClickListener { view ->
            showPopup(view)
        }
    }

    // Fungsi untuk menampilkan PopupMenu
    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.popup_menu_about, popup.menu)

        // Aksi saat item dalam PopupMenu diklik
        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.menu_about -> {
                    // Pindah ke halaman AboutActivity saat opsi About dipilih
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popup.show()
    }
}
