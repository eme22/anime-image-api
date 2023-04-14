import com.eme22.anime.AnimeImageClient;
import com.eme22.anime.Endpoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EndpointsTest {

    private static final Logger log = LogManager.getLogger(EndpointsTest.class);
    AnimeImageClient client;
    
    @BeforeAll
    public void setup(){
        client = new AnimeImageClient();
    }

    @Test
    public void waifuSFWTest() {

        Arrays.stream(Endpoints.WAIFU_SFW.values()).forEach( value -> {


            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info( "Image: " + image);


        });

    }

    @Test
    public void waifuNSFWTest() {

        Arrays.stream(Endpoints.WAIFU_NSFW.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
                });

    }


    @Test
    public void hmSFWTest() {

        Arrays.stream(Endpoints.HM_SFW.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
                });

    }

    @Test
    public void hmNSFWTest() {

        Arrays.stream(Endpoints.HM_NSFW.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
                });

    }

    @Test
    public void kawaiiSFWTest() {

        Arrays.stream(Endpoints.KAWAII_SFW.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
        });

    }

    @Test
    public void kawaiiNSFWTest() {

        Arrays.stream(Endpoints.KAWAII_NSFW.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
                });

    }

    @Test
    public void nekosTest() {

        Arrays.stream(Endpoints.NEKO.values()).forEach( value ->             {
            String image = null;
            try {
                image = client.getImage(value);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertNotNull(image, "Imagen Nula");
                    log.info("Image: " + image);
                });

    }

}
