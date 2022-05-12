
Minimal Java wrapper for [waifu.pics](https://waifu.pics), [nekos.life](https://nekos.life), [hmtai](https://hmtai.herokuapp.com) and my own service: [kawaii] (https://kawaii.up.railway.app)

## Add to project  
For Maven  
```xml  
<repositories>  
    <repository>  
        <id>jitpack.io</id>  
        <url>https://jitpack.io</url>  
    </repository>  
</repositories>  
```  
```xml  
<dependency>  
    <groupId>com.github.eme22</groupId>  
    <artifactId>anime-image-api</artifactId>  
    <version>0.4</version>  
</dependency>  
```  
  
For Gradle  
```groovy  
allprojects {
    repositories {  
        maven { url 'https://jitpack.io' }  
    }
}
```  
```groovy  
dependencies {  
    implementation 'com.github.eme22:anime-image-api:0.4'  
}  
```  
## Examples

### Get Image URL from WAIFU API
Get a random image from waifu endpoint in `sfw` category  
```Java  
        AnimeImageClient client = new AnimeImageClient();
        System.out.println(client.getImage(Endpoints.WAIFU_SFW.WAIFU));
```

### Get Image URL from NEKO API
Get a random image from neko endpoint
```Java  
        AnimeImageClient client = new AnimeImageClient();
        System.out.println(client.getImage(Endpoints.NEKO.WAIFU));
```

### Get Image URL from HMTAI API
Get a random image from hmtai endpoint
```Java  
        AnimeImageClient client = new AnimeImageClient();
        System.out.println(client.getImage(Endpoints.HM_SFW.NEKO));
```

### Get Image URL from KAWAII API
Get a random image from kawaii endpoint
```Java  
        AnimeImageClient client = new AnimeImageClient();
        System.out.println(client.getImage(Endpoints.KAWAII_SFW.WAIFU));
```

### Download Image from WAIFU API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadImage(Endpoints.WAIFU_SFW.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```

### Download Image from NEKOS API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadImage(Endpoints.NEKO.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```
### Download Image from HMTAI API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadImage(Endpoints.HM_SFW.NEKO);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```
### Download Image from KAWAII API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadImage(Endpoints.KAWAII_SFW.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```