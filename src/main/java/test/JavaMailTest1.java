package test;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class JavaMailTest1 {
	
    public static void main(String[] args) throws MessagingException, GeneralSecurityException { 
    	Properties props = new Properties();
    	// ����debug����
    	props.setProperty("mail.debug", "true");
    	// ���ͷ�������Ҫ�����֤
    	props.setProperty("mail.smtp.auth", "true");
    	// �����ʼ�������������
    	props.setProperty("mail.host", "smtp.qq.com");
    	// �����ʼ�Э������
    	props.setProperty("mail.transport.protocol", "smtp");
    	MailSSLSocketFactory sf = new MailSSLSocketFactory();
    	sf.setTrustAllHosts(true);
    	props.put("mail.smtp.ssl.enable", "true");
    	props.put("mail.smtp.ssl.socketFactory", sf);
    	Session session = Session.getInstance(props);
    	//�ʼ����ݲ���
    	Message msg = new MimeMessage(session);
    	msg.setSubject("����");
    	StringBuilder builder = new StringBuilder();
    	builder.append("java �ʼ�����");
    	builder.append("\n  <span style=\"color: red;\">һȺ����</span>");
    	builder.append("\n time�� "+new Date() );
    	msg.setText(builder.toString());
    	//�ʼ�������
    	msg.setFrom(new InternetAddress("405192400@qq.com"));
    	//�����ʼ�
    	Transport transport = session.getTransport();
    	transport.connect("smtp.qq.com", "405192400@qq.com", "ssynybmxxckobgdd");
    	//�����ռ���
    	transport.sendMessage(msg, new Address[] { new InternetAddress("405192400@qq.com") });
    	transport.close();
    } 

}
