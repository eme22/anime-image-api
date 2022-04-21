
Minimal Java wrapper for [waifu.pics](https://waifu.pics) and [nekos.life](https://nekos.life).  

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
    <version>0.1</version>  
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
    implementation 'com.github.eme22:anime-image-api:0.1'  
}  
```  
## Examples

### Get Image URL from WAIFU API
Get a random image from waifu endpoint in `sfw` category  
```Java  
        WaifuClient client = new WaifuClient();
        System.out.println(client.getSFWImage(Endpoints.WAIFU_SFW.WAIFU));
```

### Get Image URL from NEKO API
Get a random image from waifu endpoint
```Java  
        NekosClient client = new NekosClient();
        System.out.println(client.getImage(Endpoints.NEKO.WAIFU));
```

### Download Image from WAIFU API
```Java
try {
        WaifuClient client = new WaifuClient();

        Image image = client.downloadSFWImage(Endpoints.WAIFU_SFW.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```

### Download Image from WAIFU API
```Java
try {
        NekosClient client = new NekosClient();

        Image image = client.downloadImage(Endpoints.NEKO.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```


Available endpoints for [waifu.pics](https://waifu.pics) are [here](https://waifu.pics/docs)
