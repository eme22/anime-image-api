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

    private Logger log;
    AnimeImageClient client;

    @BeforeAll
    public void setup(){
        log = LogManager.getLogger(EndpointsTest.class);
        client = new AnimeImageClient();
    }

    @Test
    public void waifuSFWTest() {

        Arrays.stream(Endpoints.WAIFU_SFW.values()).forEach(value -> {


            String image = null;
            image = client.getWaifuEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            log.info( "Image: " + image);


        });

    }

    @Test
    public void waifuNSFWTest() {

        Arrays.stream(Endpoints.WAIFU_NSFW.values()).forEach( value -> {
            String image;
            image = client.getWaifuEndPoint(value);
            //Assertions.assertNotNull(image, "Imagen Nula");

            log.info("Image: " + image);

        });

    }


    @Test
    public void hmSFWTest() {

        Arrays.stream(Endpoints.HM_SFW.values()).forEach( value -> {
            String image;
            image = client.getHMEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            log.info("Image: " + image);

        });

    }

    @Test
    public void hmNSFWTest() {

        Arrays.stream(Endpoints.HM_NSFW.values()).forEach( value -> {
            String image;
            image = client.getHMEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            log.info("Image: " + image);

        });

    }

    @Test
    public void nekosTest() {

        Arrays.stream(Endpoints.NEKO.values()).forEach( value -> {
            String image;
            image = client.getNekosEndPoint(value);

            //Assertions.assertNotNull(image, "Imagen Nula");
            log.info("Image: " + image);

        });

    }

}
