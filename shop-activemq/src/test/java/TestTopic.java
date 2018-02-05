/*
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class TestTopic {
    @Test
    public void testTopic() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://139.196.75.243:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("myfirsttopic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("this is topic");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }



    @Test
    public void testConsumer() throws JMSException, IOException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://139.196.75.243:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("myfirsttopic");
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try{
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println(text);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        System.in.read();//等待键盘输入
        consumer.close();
        session.close();
        connection.close();
    }
}
*/
