/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package edu.mum.emailservice;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import edu.mum.domain.Item;
import edu.mum.domain.Order;

@Service("emailService")
public class EmailService {

     private static final String ESHOPPING = "templates/images/eshopping.jpg";
     private static final String ESHOPPING2 = "templates/images/ny.jpg";
     private static final String PROMOTION = "templates/images/promotion.jpg";
    
     private static final String JPG_MIME = "image/jpg";
     private static final String DOCX_MIME = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

  @Autowired
    private JavaMailSender mailSender;
 
  @Autowired
    private SpringTemplateEngine templateEngine;
    
    /* 
     * Send HTML mail (
     */
    public void sendOrderReceivedMail(
            final String recipientName, final String recipientEmail, final String [] ccrecipientEmail,  Order order,Item item, String documentName,final Locale locale) 
            throws MessagingException {
    	
		 
		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,"UTF-8");
        message.setSubject("Order Details");
 
        
        message.setTo(recipientEmail);
        if(ccrecipientEmail!=null)
        {
        message.setCc(ccrecipientEmail);
        }

        
       
        
        String htmlContent="";
		// Prepare the evaluation context
		final Context thymeContext = new Context(locale);
		thymeContext.setVariable("name", recipientName);
		
		if (order != null) {
			thymeContext.setVariable("order", order);
			// Create the HTML body using Thymeleaf
			htmlContent = this.templateEngine.process("emailOrder", thymeContext);
			
		} 
		else if (item != null) 
		{
			thymeContext.setVariable("item", item);
			htmlContent = this.templateEngine.process("emailPromotion", thymeContext);
			
			message.setSubject(recipientName);
		}
		message.setText(htmlContent, true /* isHtml */);
		message.addInline("promotion", new ClassPathResource(PROMOTION), JPG_MIME);
		message.addInline("eshopping2", new ClassPathResource(ESHOPPING2), JPG_MIME);
        message.addInline("eshopping", new ClassPathResource(ESHOPPING), JPG_MIME);
        
        
       
        

        String documentLocation = "templates/images/" + documentName ;
         message.addAttachment(documentName, new ClassPathResource(documentLocation));
 

        this.mailSender.send(mimeMessage);

    }

 
}
