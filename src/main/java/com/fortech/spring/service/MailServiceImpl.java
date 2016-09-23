package com.fortech.spring.service;

import com.fortech.spring.model.ProductOrder;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    Configuration freeMarkerConfiguration;

    @Override
    public void sendEmail(Object object) {

        ProductOrder order = (ProductOrder)object;

        MimeMessagePreparator preparator = getMessagePreparator(order);

        try {
            mailSender.send(preparator);
            System.out.println("Message has been sent.............................");
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order){

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("PieMatrix Account Confirmation");
                helper.setFrom("support@piematrix.com");
                helper.setTo(order.getCustomerInfo().getCustomerEmail());

                Map<String, Object> model = new HashMap<String, Object>();
                model.put("order", order);

                String text = geFreeMarkerTemplateContent(model);//Use Freemarker or Velocity
                System.out.println("Template content: "+text);

                // the true flag indicates the need of a multipart message
                helper.setText(text, true);

                // add resource images in templates.
                //helper.addAttachment("order-"+order.getInvoiceId()+".pdf", new ClassPathResource("filename.pdf"));
                helper.addInline("piematrix-logo", new ClassPathResource("piematrix-logo.png"));
                helper.addInline("did-you-know", new ClassPathResource("light-bulb.png"));
                helper.addInline("newsletter", new ClassPathResource("newsletter.png"));
                helper.addInline("faq", new ClassPathResource("faq.png"));
            }
        };
        return preparator;
    }

    public String geFreeMarkerTemplateContent(Map<String, Object> model){
        StringBuffer content = new StringBuffer();
        try{
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
                    freeMarkerConfiguration.getTemplate("fm_mailTemplate.txt"),model));
            return content.toString();
        }catch(Exception e){
            System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
        }
        return "";
    }
}
