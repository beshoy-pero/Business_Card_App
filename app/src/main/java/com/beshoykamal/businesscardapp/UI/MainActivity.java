package com.beshoykamal.businesscardapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beshoykamal.businesscardapp.Adapter.CardAdapter;
import com.beshoykamal.businesscardapp.Adapter.CardAdapterContacts;
import com.beshoykamal.businesscardapp.Adapter.InfoAdapter;
import com.beshoykamal.businesscardapp.Adapter.OnItemClick;
import com.beshoykamal.businesscardapp.Adapter.SlidePagrAdapter;
import com.beshoykamal.businesscardapp.Adapter.VideoAdapter;
import com.beshoykamal.businesscardapp.Pojo.Slide;
import com.beshoykamal.businesscardapp.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.rbddevs.splashy.Splashy;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    ViewPager slidPager;
    RecyclerView moviesRV,inforec,rcVideo,rcContacts;
    List<Slide> lastslide;
    Timer time;
    Vector<Slide> youtubeV = new Vector<>();
    TextView complet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidPager = findViewById(R.id.slider_pager);
        moviesRV = findViewById(R.id.recycler);
        inforec = findViewById(R.id.infoRC);
        rcVideo = findViewById(R.id.rcVideo);
        rcContacts = findViewById(R.id.rcContacts);
        complet = findViewById(R.id.complet);



        new Splashy(this)  // For JAVA : new Splashy(this)
                .setLogo(R.drawable.manger)
                .setTitle("WELCOME\n")
//                .setTitleColor("#00BCD4")
                .show();
        YoYo.with(Techniques.Shake).duration(1500).repeat(50).playOn(findViewById(R.id.text_home7));

        methodViewPhotoAbove();
        arraycardview();
        arrayInfoView();
        methodYouTube();
        arraycardviewContact();
    }

    private void methodViewPhotoAbove() {
        lastslide = new ArrayList<>();
        lastslide.add(new Slide(R.drawable.person,      "Company Name ", "يمكنك وضع صورة شخصية واسمك"));
        lastslide.add(new Slide(R.drawable.service,     "Name Services", "يمكنك وضع صورة للخدمات التي تقدمها "));
        lastslide.add(new Slide(R.drawable.social,      "Team Work",     "صورة لفريق العمل "));
        lastslide.add(new Slide(R.drawable.storea,      "Outside Store", "وضع صور لمتجرك او شركتك من الخارج"));
        lastslide.add(new Slide(R.drawable.storeb  ,    "Outside Store", "وضع صور لمتجرك او شركتك من الخارج"));
        lastslide.add(new Slide(R.drawable.storecolothes, "Inside Store","وضع صور لمتجرك ومنتجاتك من الداخل"));
        lastslide.add(new Slide(R.drawable.stored,      "Inside Store",  "وضع صور لمتجرك من الداخل"));
        lastslide.add(new Slide(R.drawable.storee,      "Inside Store",  "وضع صور لمتجرك ومنتجاتك من الداخل"));
        lastslide.add(new Slide(R.drawable.grocery,     "Inside Store",  "وضع صور لمتجرك ومنتجاتك من الداخل"));
        lastslide.add(new Slide(R.drawable.storeh,      "Inside Store",  "وضع صور لمتجرك ومنتجاتك من الداخل"));
        lastslide.add(new Slide(R.drawable.devices,     "Inside Store",  "وضع صور لمتجرك ومنتجاتك من الداخل"));
        lastslide.add(new Slide(R.drawable.companyrate, "Diagram",       " انفوجراف للشركة"));
        lastslide.add(new Slide(R.drawable.aroundworld, "Contact With The world", "تطبيقك يصل الي كل العالم"));
        SlidePagrAdapter adapter = new SlidePagrAdapter(this, lastslide);
        slidPager.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (this == null)
                    return;
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (slidPager.getCurrentItem() < lastslide.size() - 1)
                            slidPager.setCurrentItem(slidPager.getCurrentItem() + 1);
                        else
                            slidPager.setCurrentItem(0);
                    }
                });
            }
        }, 3000, 5000);

    }

    private void arraycardview() {
        List<Slide> last=new ArrayList<>();
        last.add(new Slide(R.drawable.draw,"خدمات التصميم","التصميمات هي الواجهة المرئية للشركات والأعمال بشكل عام، فمثلًا شعار موقعك أو شركتك أمر يستحق إنفاق بعض الدولارات، هدا كله بجانب خدمات التصميم بشكل عام مثل تصميم صور غلاف لصفحات شركتك على الفيسبوك أو تعديل صورة لنشرها على صفحات أعمالك على الشبكات الإجتماعية او حتى في التدوينات التي ستكون على مدونة شركتك، الجزء المرئي لشركتك يشكل جزء كبير من إنطباع زبائنك، وهو أمرٌ في غاية الأهمية بلا شَك."));
        last.add(new Slide(R.drawable.mopile,"برمجة تطبيقات الجوال","برمجوا لك تطبيقًا بسيطًا لعملك بتكلفة بسيطة مع تركيز الإمكانيات التي تطلُبها أنت ومُراعاة تناسُب ما تطلبه وقدرات التطبيق بشكل عام مع السعر المناسب"));
        last.add(new Slide(R.drawable.ads,"التسوق والاعلان","العديد من أصحاب المواقع يعرضون بيع مساحة إعلانية أو روابط نصية إعلانية ترويجية على مواقعهم، وهو ما سيزيد زيارات موقعك وبالتالي وصول خدمات ومُنتجات شركتك لعدد أكبر من المٌستخدمين، أيضًا يُمكنك شراء خدمات التسويق أو إدارة الحملات الإعلانية من شخص مُختص "));
        last.add(new Slide(R.drawable.data,"خدمات ادخال البيانات","إذا كنت تحتاج لأصحاب السرعة والدقة في الكتابة لمساعدتك على تفريغ ملفات الوورد أو الإكسل، أو إدخال بعض البيانات والمعلومات الروتينية اليومية البسيطة في قواعد بياناتك أو على موقعك وتحتاج لمن يتولى هذا عنك وينجزه في وقت أسرع، فهذه الخدمات خيارك الأنسب."));
        last.add(new Slide(R.drawable.plan,"التخطيط","قبل أن تبدأ شركتك ستحتاج أن تضع خطة تشمل خطوات مُعينة توصلك لهدف مُعيّن، وحتى لو كانت شركتك موجودة بالفِعل فستحتاج خطة للنهوض  بها أو لزيادة العملاء وتوسعة النشاط وتنمية الشركة، وحتى على المُستوي الشخصي فالعديد منا يحتاج إلى من يضع له خطة عملية"));


        CardAdapter cardAdapter = new CardAdapter(this,last);
        moviesRV.setAdapter(cardAdapter);
        moviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }
    private void arrayInfoView() {
        List<Slide> inflist = new ArrayList<>();
        inflist.add(new Slide(R.drawable.hand, "عند استقبال الضيوف في المنزل، التحية تكون على بُعد متر من خلال: التلويح باليد أو الإيماءة أو الإنحناء"));
        inflist.add(new Slide(R.drawable.hanfia, "أطلب من المتواجدين في المنزل جميعا غسل أيديهم بما فيهم الضيوف"));
        inflist.add(new Slide(R.drawable.monzef, "التنظيف المستمر للأسطح والاشياء خاصة التي يتم لمسها كثيرًا"));
        inflist.add(new Slide(R.drawable.man, "إذا شعر شخص من المتواجدين أنه ليس بخير (خاصة وإن كانت أعراضه إيجابية لفيروس كورونا المستجد) أحذرا من مشاركة الأماكن معًا"));
        inflist.add(new Slide(R.drawable.kmama, "إذا أُصبت بأعراض فيروس كورونا المستجد تواصل مع جهة الرعاية الصحية المختصة تليفونيًا قبل الذهاب"));
        inflist.add(new Slide(R.drawable.medecin, "ضع خطة تحضيرية لك في حالة تفشي الفيروس في مجتمعك"));
        inflist.add(new Slide(R.drawable.bus, "في حال خروجك من المنزل، حاول الالتزام بكافة التعليمات الإرشادية كما لو كنت في المنزل"));
        inflist.add(new Slide(R.drawable.kmama, "لا تستخدم الكمامة إلا إذا كنت مصاباً بأعراض تنفسية (السعال والعطس)، أو يُشتبه بإصابتك بعدوى مرض كوفيد-19 المصحوبة بأعراض خفيفة، أو كنت تقدم الرعاية إلى شخص يشتبه بإصابته بهذه العدوى"));
        inflist.add(new Slide(R.drawable.i, "تتمثل السبل الأكثر فعّالية لحماية نفسك والآخرين من مرض كوفيد-19 في المواظبة على تنظيف اليدين، وتغطية الفم عند السعال بثني المرفق أو بمنديل ورقي، والابتعاد مسافة لا تقل عن متر واحد (3 أقدام) عن الأشخاص الذين يسعلون أو يعطسون."));

        inflist.add(new Slide(R.drawable.i, "أبق على إطلاع دائم بالمستجدات عن الفيروس من المصادر الموثوقة"));
        InfoAdapter infoAdapter = new InfoAdapter(this, inflist);
        inforec.setAdapter(infoAdapter);
        inforec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void methodYouTube() {

//        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/OxzpTTIwnww\" frameborder=\"0\" allowfullscreen></iframe"));
//        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qpfTGpKg5YE\" frameborder=\"0\" allowfullscreen></iframe"));
//        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mhSkDHnXMyQ\" frameborder=\"0\" allowfullscreen></iframe"));
//        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/QevuTcwZKqM\" frameborder=\"0\" allowfullscreen></iframe"));
//        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cpTTmuRBn-c\" frameborder=\"0\" allowfullscreen></iframe"));
        youtubeV.add(new Slide("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LIqQNG_q2us\" frameborder=\"0\" allowfullscreen></iframe"));
        VideoAdapter cardAdapter = new VideoAdapter(this, youtubeV);
        rcVideo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcVideo.setAdapter(cardAdapter);
    }

    private void arraycardviewContact() {
        List<Slide> lasts=new ArrayList<>();
        lasts.add(new Slide(R.drawable.manger,"Area Manager","phone/ 01030000000"));
        lasts.add(new Slide(R.drawable.e,"Sales Manager","phone/ 01285307783"));
        lasts.add(new Slide(R.drawable.employee,"Director Manager","phone/ 01093364710"));


        CardAdapterContacts cardAdapter = new CardAdapterContacts(this,lasts,this);
        rcContacts.setAdapter(cardAdapter);
        rcContacts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        rcContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void maps(View view) {
        YoYo.with(Techniques.ZoomIn).duration(1000).repeat(0).playOn(findViewById(R.id.map));
        Intent in=new Intent(Intent.ACTION_VIEW,Uri.parse("geo: 30.1116976,31.3125198?z=13"));
        startActivity(in);
    }

    public void facebook(View view) {
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        YoYo.with(Techniques.Wave).duration(200).repeat(1).playOn(findViewById(R.id.facebook));
        startActivity(in);
    }
    public void instagram(View view) {
        YoYo.with(Techniques.SlideInLeft).duration(1000).repeat(0).playOn(findViewById(R.id.instagram));
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
        startActivity(in);
    }

    @Override
    public void onItemClick(Slide item) {
        String descrip=item.getDescrip();
        int pric = Integer.parseInt(descrip.replaceAll("[\\D]", ""));

        Toast.makeText(this, ""+pric, Toast.LENGTH_SHORT).show();
        Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+20"+pric));
        startActivity(in);
    }

    public void aboutWord(View view) {
        complet.setVisibility(View.VISIBLE);
    }
}