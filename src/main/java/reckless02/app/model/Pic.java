package reckless02.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reckless01")
public class Pic {
	//define fields
	//define constructor
	//define getter/setter
	//define to string
//	@Entity的Bean是告訴Spring這是數據模型層的宣告
//	@Table name: Table的name對映到資料庫中的資料表名稱
//	@Column name: 對應到Table的欄位中的欄位名稱
//	@Id : 是此資料表的Primary Key
//	@GeneratedValue : 告訴此Column的生成方式 ,如果設定成GenerationType.AUTO讓容器
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	
	//by hibernate
	public Pic() {}

	public Pic(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", name=" + name + "]";
	}
}
