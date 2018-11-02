package cc.iszjq.demo.utiles;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    /**
     * 发送邮件的方法
     *
     * @param to   给谁发邮件
     * @param code 邮件的激活码
     */
    public static void sendMail(String to, String code) throws Exception {
        Properties properties = new Properties();
        //开启debug调试
        properties.setProperty("mail.debug", "true");
        //设置smtp邮件服务器主机
        properties.setProperty("mail.host", "smtp.qq.com");
        //发送邮件需要身份验证
        properties.setProperty("mail.smtp.auth", "true");
        //发送邮件协议
        properties.setProperty("mail.transport.protocol", "smtp");
        //开启SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(properties);

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "this@iszjq.cc", "jbsvcpyjwjvyfjae");

        //创建邮箱对象
        Message message = new MimeMessage(session);
        //2.1设置收件人
        message.setFrom(new InternetAddress("this@iszjq.cc"));
        //2.2
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //2.3设置邮件主题
        message.setSubject("来自超级无敌宇宙帅气的ZJQ的邮件");
        //2.4设置邮件正文
        message.setContent("<h1>超级无敌宇宙帅气的ZJQ的激活提示，点击下面的链接激活你的账号:</h1>" +
                "<h3><a href='http://localhost:8080/user2/active/" + code + "'>" +
                "http://localhost:8080/user2/active?code=" + code + "</a></h3>", "text/html;charset=UTF-8");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
