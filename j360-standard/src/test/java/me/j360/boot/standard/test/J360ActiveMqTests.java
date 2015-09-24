
package me.j360.boot.standard.test;

import javax.jms.JMSException;

import me.j360.boot.standard.J360Configuration;
import me.j360.boot.standard.activemq.Producer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { J360Configuration.class })
public class J360ActiveMqTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private Producer producer;

	@Test
	public void sendSimpleMessage() throws InterruptedException, JMSException {
		this.producer.send("Test message");
		Thread.sleep(1000L);
		assertTrue(this.outputCapture.toString().contains("Test message"));
	}

}
