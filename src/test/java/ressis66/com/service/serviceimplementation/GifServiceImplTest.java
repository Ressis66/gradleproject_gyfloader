package ressis66.com.service.serviceimplementation;

import ressis66.com.service.serviceimplementation.GifServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import ressis66.com.client.implementation.OpenGifClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("morozov.ru")
public class GifServiceImplTest {

    @Autowired
    private GifServiceImpl gifService;
    @MockBean
    private OpenGifClient gifClient;

    @Test
    public void whenPositiveChanges() {
        ResponseEntity<Map> testEntity = new ResponseEntity<>(new HashMap(), HttpStatus.OK);
        Mockito.when(gifClient.getRandomGif(anyString(), anyString()))
                .thenReturn(testEntity);
        ResponseEntity<Map> result = gifService.getGif("control_test_word");
        assertEquals("control_test_word", result.getBody().get("compareResult"));
    }

}