package com.khang.example.document_agent;

import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "document-agent")
@Push
public class DocumentAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentAgentApplication.class, args);
	}

}
