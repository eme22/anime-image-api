import com.eme22.imageapi.AnimeImageClient;
import com.eme22.imageapi.util.Endpoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EndpointsTest {

    AnimeImageClient client;

    @BeforeAll
    public void setup(){
        client = new AnimeImageClient();
    }

    @Test
    public void waifuSFWTest() {

        long start = System.currentTimeMillis();

        String image = client.getWaifuEndPoint(Endpoints.WAIFU_SFW.WAIFU);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.WAIFU_SFW.values()).forEach(value -> {


            String image = null;
            image = client.getWaifuEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            System.out.println( "Image: " + image);


        });

         */

    }

    @Test
    public void waifuNSFWTest() {

        long start = System.currentTimeMillis();

        String image = client.getImage(Endpoints.WAIFU_NSFW.WAIFU);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.WAIFU_NSFW.values()).forEach( value -> {
            String image;
            image = client.getWaifuEndPoint(value);
            //Assertions.assertNotNull(image, "Imagen Nula");

            System.out.println("Image: " + image);

        });
        */
    }


    @Test
    public void hmSFWTest() {

        long start = System.currentTimeMillis();

        String image = client.getImage(Endpoints.HM_SFW.HUG);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.HM_SFW.values()).forEach( value -> {
            String image;
            image = client.getHMEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            System.out.println("Image: " + image);

        });
        */

    }

    @Test
    public void hmNSFWTest() {

        long start = System.currentTimeMillis();

        String image = client.getImage(Endpoints.HM_NSFW.ANAL);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.HM_NSFW.values()).forEach( value -> {
            String image;
            image = client.getHMEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            System.out.println("Image: " + image);

        });

         */

    }

    @Test
    public void nekosTest() {

        long start = System.currentTimeMillis();

        String image = client.getImage(Endpoints.NEKO.HUG);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.NEKO.values()).forEach( value -> {
            String image;
            image = client.getNekosEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            System.out.println("Image: " + image);

        });
        */

    }

    @Test
    public void kawaiiTest() {

        long start = System.currentTimeMillis();

        String image = client.getImage(Endpoints.KAWAII_SFW.KISS);

        long end = System.currentTimeMillis();

        System.out.println("Image: " + image);

        System.out.println("Time: " + (end-start) + "ms");

        /*
        Arrays.stream(Endpoints.KAWAII_SFW.values()).forEach( value -> {
            String image;
            image = client.getKawaiiEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            System.out.println("Image: " + image);

        });
        */

    }

}
