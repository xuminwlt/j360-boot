package me.j360.boot.simple.test;

import me.j360.boot.simple.J360Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import static org.junit.Assert.assertEquals;
/**
 * Created with j360-boot -> me.j360.boot.simple.test.
 * User: min_xu
 * Date: 2015/9/27
 * Time: 21:54
 * 说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = J360Configuration.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SimpleTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void testHome() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port+"/hello", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("hello", entity.getBody());
    }

    /**
     * 服务器编码设置
     * server.compression.enabled: true
     * server.compression.min-response-size: 1
     * */
    @Test
    public void testCompression() throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept-Encoding", "gzip");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<byte[]> entity = restTemplate.exchange("http://localhost:"
                + this.port+"/hello", HttpMethod.GET, requestEntity, byte[].class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        GZIPInputStream inflater = new GZIPInputStream(new ByteArrayInputStream(
                entity.getBody()));
        try {
            assertEquals("hello",
                    StreamUtils.copyToString(inflater, Charset.forName("UTF-8")));
        }
        finally {
            inflater.close();
        }
    }
}
