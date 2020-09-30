package jp.te4a.spring.boot.dca.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="Tests")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestBean {
	
	@Id
	@GeneratedValue
	private Integer id ;
	@Column(nullable = false)
	private String classroom;
	private String subject;
	private String teacher;
	/*
	<tr><td>教室名:</td><td><input type="text" name="title" /></td></tr>
    <tr><td>科目名：</td><td><input type="text" name="writter" /></td></tr>
    <tr><td>担当講師名：</td><td><input type="text" name="publisher" /></td></tr>
     <tr><td>日付：</td><td><input type="text" name="price" /></td></tr>
	 */
}