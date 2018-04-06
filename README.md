# Matris Kütüphanesi

**matris** kütüphanesi, temel ve ileri seviye matris işlemlerini gerçekleştirmek üzere [IZU](http://www.izu.edu.tr) iprocess grubu tarafından oluşturulmuştur.


## Kütüphane Paket Yapısı
**matris** kütüphanesi temel olarak aşağıdaki paketleri barındırmaktadır;

* *tr.edu.izu.iprocess.matris* : Temel matris (soyut, jenerik) sınıfını barındıran paket.
* *tr.edu.izu.iprocess.matris.exception* : İstisnaları barındıran paket.
* *tr.edu.izu.iprocess.matris.impl* : matris paketi altında tanımlanmış soyut soyut sınıf/sınıfların implementasyonlarını barındıran paket.
* *tr.edu.izu.iprocess.matris.io* : Dosya sistemi operasyonları (okuma/yazma) icin oluşturulmuş arayüzleri (interface) barındıran paket.
* *tr.edu.izu.iprocess.matris.operation* : Matris operasyonları için oluşturulmuş soyut sınıfları ve arayüzleri (interface) barındıran paket.

## Ön Koşullar
*matris* kütüphanesini geliştirmek veya başka bir projede kullanmak üzere paketlemek için aşağıdaki yazılımların kurulu olması gerekmektedir;

Yazılım      | Versiyon
------------ | -------------
[JDK](http://openjdk.java.net/install)	     | 7 ve/veya yukarısı
[Apache Maven](https://maven.apache.org/) | 3.3.x veya yukarısı
[Git SCM](https://git-scm.com/) | 2.x veya yukarısı


## Geliştirme Süreci
**matris** kütüphanesine katkıda bulunurken (fork ve IDE üzerine import işlemi gerçekleştirildikten sonra) dikkat edilmesi gereken konular;

* Katkıda bulunulmak istenen [konu (issue)](https://github.com/iprocess-izu/matris/issues) seçilmelidir. Konular (issue) içerisinde yer almayan geliştirmeler için önce [konu (issue)](https://github.com/iprocess-izu/matris/issues) girilip daha sonra geliştirme işlemleri yapılmalıdır.
* Seçilen konu ile ilgili olarak kodlama aşaması ve testler birlikte yazılmalıdır. Kütüphaneye ait test paketleri ve sınıfları *src/test/java* klasoru altında bulunmaktadır.
* Değişken (yerel, genel), sınıf, metod isimlendirmelerininin net, anlaşılır ve ingilizce olmalıdır.
* Kodlama düzeni (coding convention) olarak [Google Java Guide](https://google.github.io/styleguide/javaguide.html) esas alınmalıdır.
* Geliştirme işlemi için yapılacak öneriler ilk maddede belirtildiği gibi [konu (issue)](https://github.com/iprocess-izu/matris/issues) şeklinde yapılmalıdır.



## Lisans
* (Apache-2.0) **matris** kütüphanesi "Apache License" 2.0 lisansi ile lisanslıdır. Katkılar aynı lisans altında yapılmalıdır.


