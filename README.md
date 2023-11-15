
Minimal Java wrapper for [waifu.pics](https://waifu.pics), [nekos.life](https://nekos.life), [hmtai](https://hmtai.hatsunia.cfd) and custom services.

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
    <version>0.9.1</version>  
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
    implementation 'com.github.eme22:anime-image-api:0.9.1'  
}  
```  
## Examples

### Get Image URL from WAIFU API
Get a random image from waifu endpoint in `sfw` category

```Java  
        AnimeImageClient client = new AnimeImageClient();
        return client.getWaifuEndPoint(Endpoints.WAIFU_SFW.WAIFU);
```

### Get Image URL from NEKO API
Get a random image from neko endpoint
```Java  
        AnimeImageClient client = new AnimeImageClient();
        return client.getNekosEndPoint(Endpoints.NEKO.WAIFU);
```

### Get Image URL from HMTAI API
Get a random image from hmtai endpoint
```Java  
        AnimeImageClient client = new AnimeImageClient();
        return client.getHMEndPoint(Endpoints.HM_SFW.NEKO);
```
### Download Image from WAIFU API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadWaifuImage(Endpoints.WAIFU_SFW.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```

### Download Image from NEKOS API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadNekosImage(Endpoints.NEKO.WAIFU);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```
### Download Image from HMTAI API
```Java
try {
        AnimeImageClient client = new AnimeImageClient();

        Image image = client.downloadHMImage(Endpoints.HM_SFW.NEKO);

        OutputStream os = new FileOutputStream(image.filename);
        os.write(image.buffer);
        os.close();
        } catch (Exception ignored) {}
```

### Register Custom Endpoint
Register a random image endpoint with custom url and json path

```Java
        AnimeImageClient AnimeImageClient = new AnimeImageClient();

        Endpoint endpoint = new Endpoint();
        endpoint.setName("custom");
        endpoint.setBaseUrl("http://localhost:8080/api/v1/image?type=%s&category=%s");
        endpoint.setResponseJsonPath("$.data.url");
        endpoint.setResponseJsonPathRegex(true);

        Category category = new Category();

        category.setName("waifu");
        category.setNsfw(false);
        category.setPaths(Arrays.asList("sfw","waifu"));
        endpoint.setCategories(Collections.singleton(category));

        AnimeImageClient.registerEndPoint(endpoint);
```

### Get Image from Custom Endpoint
Get a random image from custom endpoint in `waifu` category

```Java
        AnimeImageClient client = new AnimeImageClient();
        return client.getImage("custom", "waifu");
```
