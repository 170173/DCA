package jp.te4a.spring.boot.dca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassBean {
	//教室id、教室名、定員数
	@Id
	private String c_id;
	private String c_name;
	private Integer capacity;
}
