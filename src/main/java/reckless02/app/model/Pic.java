package reckless02.app.model;

import java.util.Arrays;

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
	@Column(name="content")
	private byte [] content;
	@Column(name="profileName")
	private String profileName;
	@Column(name="whatSize")
	private long whatSize;
	
	//by hibernate
	public Pic() {}

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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public long getWhatSize() {
		return whatSize;
	}

	public void setWhatSize(long whatSize) {
		this.whatSize = whatSize;
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", name=" + name + 
				", content=" + Arrays.toString(content) + 
				", profileName="+ profileName + ", whatSize=" + whatSize + "]";
	}

}
