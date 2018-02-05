/*
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class TestActiveMQ {
    @Test
    public void testProducer() throws JMSException {
        //1.创建connection工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://139.196.75.243:61616");
        //2.获得connection对象
        Connection connection = connectionFactory.createConnection();
        //3.开启连接
        connection.start();
        //4.获得session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.通过session获得队列queue(destitation)
        Queue queue = session.createQueue("Queue");
        //6.通过session获得producer
        MessageProducer producer = session.createProducer(queue);
        //7.通过session创建消息
        TextMessage textMessage = session.createTextMessage("this is activemq!");
        //8.producer发送消息
        producer.send(textMessage);
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void testConsumer() throws JMSException, IOException {
        //1.创建connectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://139.196.75.243:61616");
        //2.获得连接对象
        Connection connection = connectionFactory.createConnection();
        //3.开启连接
        connection.start();
        //4.获得session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.通过session获得队列
        Queue queue = session.createQueue("Queue");
        //6.通过session获得consumer
        MessageConsumer consumer = session.createConsumer(queue);
        //7.接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try{
                    TextMessage textMessage = (TextMessage)message;
                    String text = textMessage.getText();
                    //8.打印消息队列
                    System.out.println(text);
                }catch (Exception e){

                }
            }
        });
        System.in.read();
        //9.关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
*/
