# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

## Git
 
git clone https://github.com/hamitmizrak/techcareer_2025_backend_1.git

git init
git add .
git commit -m "spring init"
git push -u master

git status
git log

git pull
git pull origin master

```
---

## Permalink

    http://localhost:4444
    http://localhost:4444/h2-console
    http://localhost:4444/swagger-ui/index.html
    http://localhost:4444/actuator/health
```
---

## Version
 
git -v
mvn -v
java --version
javac --version
docker version
docker-compose version
```
---

## Git Init
 
git init
git add .
git commit -m "spring boot init"
git remote add origin URL
git push -u origin master

git clone https://github.com/hamitmizrak/
```
---

## Git Codes

git status
git logs

# WSL 2 docker üzerinden çalışmıyorsa bu adımları yapınız ?
Step-1) Windows => services=> Docker çalıştır

Step-2) Docker Desktop => Settings => Use the WSL 2 based engine
Use the WSL 2 based engine


# Dikkat: power shell Yönetici modda açmalasını
Step-3)
# wsl çalışan dağıtımlarını bak
wsl --list --verbose

wsl --status
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
wsl --list --online
wsl --install -d Ubuntu-22.04
VEYA
wsl --install -d Ubuntu-24.04
VEYA
wsl --install -d Ubuntu

# wsl Güncelle
wsl --update

# Register
wsl --unregister docker-desktop
wsl --unregister docker-desktop-data

# WSL2 Ağ bağlantı Durumuna (Ağ bağlantıları sıfırlamak)
netsh winsock reset
netsh int ip  reset




#
Bu hata, sisteminizde WSL üzerinde kurulu bir dağıtım olmadığını ve varsayılan bir dağıtım yapılandırılamadığını gösteriyor. Bu durumu çözmek için aşağıdaki adımları takip edebilirsiniz:

---


Bu hata, belirtilen WSL dağıtımının mevcut olmadığını ifade ediyor. "docker-desktop" adında bir dağıtımın sisteminizde bulunmadığını gösteriyor. Bu tür bir hatayı çözmek için aşağıdaki adımları takip edebilirsiniz:

---

### **Adım 1: Mevcut WSL Dağıtımlarını Listele**
Öncelikle, sistemde hangi WSL dağıtımlarının mevcut olduğunu kontrol edin:
```bash
wsl --list --all
```
Bu komut, sisteminizde kayıtlı tüm WSL dağıtımlarını gösterecektir.

- Eğer `docker-desktop` listede yoksa, bu hatayı almanız doğaldır çünkü böyle bir dağıtım kayıtlı değildir.
- Eğer `docker-desktop` veya `docker-desktop-data` varsa, işlemi tekrar deneyebilirsiniz.

---

### **Adım 2: Docker Desktop Uygulamasını Kontrol Et**
Docker Desktop uygulamasını kullanıyorsanız:
1. Docker Desktop'ın yüklü olduğundan ve düzgün çalıştığından emin olun.
2. Docker Desktop yeniden yüklenmiş veya kaldırılmışsa, WSL'deki dağıtımları güncelleyerek tekrar deneyin.

---

### **Adım 3: `docker-desktop` Dağıtımını Yeniden Oluşturma**
Eğer Docker Desktop kurulu değilse, yeniden kurmayı deneyin:
1. [Docker Desktop](https://www.docker.com/products/docker-desktop/) uygulamasını indirip kurun.
2. Kurulum sırasında Docker Desktop, `docker-desktop` ve `docker-desktop-data` adlı WSL dağıtımlarını otomatik olarak oluşturacaktır.

---

### **Adım 4: `wslconfig` ile Varsayılan Dağıtımları Kontrol Et**
Varsayılan WSL yapılandırmalarını kontrol edin:
```bash
wslconfig /list
```
Bu komut, WSL ile ilişkili varsayılan dağıtımları gösterecektir. `docker-desktop` burada görünmüyorsa, Docker Desktop'ı tekrar yüklemeniz gerekebilir.

---

### **Adım 5: WSL Hizmetlerini Sıfırlama**
WSL hizmetlerini sıfırlamak, hatalı bir durumun çözülmesine yardımcı olabilir:
1. WSL'yi durdurun:
   ```bash
   wsl --shutdown
   ```
2. WSL'yi yeniden başlatın:
   ```bash
   wsl
   ```

---

### **Adım 6: Sorunu Çözemezseniz**
Eğer hala aynı hatayı alıyorsanız:
1. WSL2 bileşenlerinin doğru kurulduğundan emin olun:
   ```bash
   wsl --update
   ```
2. Sisteminizde Docker Desktop’ın yeniden yüklenmesini deneyin.

---

Bu adımlar sonucunda hatanın çözülmesi gerekir. Eğer sorun devam ederse, mevcut yapılandırmalar hakkında daha fazla bilgi sağlayabilirsiniz. 😊

#
### **Adım 1: WSL Dağıtımlarını Görüntüle**
Kullanılabilir dağıtımları görmek için şu komutu çalıştırın:
```bash
wsl --list --online
```
Bu komut, sisteminize yüklenebilecek WSL dağıtımlarını listeleyecektir.

---

### **Adım 2: Yeni Bir Dağıtım Yükleyin**
Örneğin, Ubuntu dağıtımını yüklemek için aşağıdaki komutu çalıştırabilirsiniz:
```bash
wsl --install -d Ubuntu
```

Eğer belirli bir dağıtımı yüklemek istiyorsanız, `--list --online` komutuyla listelenen dağıtım adını kullanabilirsiniz. Örnek:
```bash
wsl --install -d <DistroName>
```

---

### **Adım 3: Microsoft Store Üzerinden Dağıtım Yükleme**
Alternatif olarak, dağıtımları Microsoft Store üzerinden yükleyebilirsiniz:
1. [Microsoft Store](https://aka.ms/wslstore) adresine gidin.
2. İstediğiniz Linux dağıtımını seçip yükleyin (ör. Ubuntu, Debian, Fedora).

---

### **Adım 4: WSL Versiyonunu Güncelleyin**
WSL'nin güncel olduğundan emin olun:
```bash
wsl --update
```

---

### **Adım 5: Varsayılan Dağıtımı Ayarlayın**
Dağıtımı yükledikten sonra varsayılan olarak ayarlayın:
```bash
wsl --set-default <DistroName>
```

Örneğin:
```bash
wsl --set-default Ubuntu
```

---

### **Adım 6: Dağıtımın Çalıştığından Emin Olun**
Yüklediğiniz dağıtımı başlatmak için:
```bash
wsl
```
Eğer birden fazla dağıtım yüklüyseniz, belirli bir dağıtımı başlatmak için:
```bash
wsl -d <DistroName>
```

---

### **Adım 7: WSL Hizmetlerini Sıfırlayın**
WSL'nin düzgün çalıştığından emin olmak için sıfırlama işlemi yapabilirsiniz:
1. WSL'yi kapatın:
   ```bash
   wsl --shutdown
   ```
2. Tekrar başlatın:
   ```bash
   wsl
   ```

---

Bu adımlar sonucunda WSL'yi ve bir Linux dağıtımını başarılı bir şekilde yüklemiş ve kullanıma hazır hale getirmiş olmanız gerekir. Eğer hala sorun yaşarsanız, daha fazla bilgi sağlayabilirsiniz! 😊