package jp.te4a.spring.boot.dca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {
	//生徒id、生徒名
	@Id
	private String s_id;
	private String s_name;
}
