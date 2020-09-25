package jp.te4a.spring.boot.dca.form;

import lombok.AllArgsConstructor; 
import lombok.Data; import lombok.NoArgsConstructor; 
@Data
@NoArgsConstructor
public class TestForm{ 
	
	private Integer id ;
	private String classroom;
	private String subject;
	private String teacher;
	
}