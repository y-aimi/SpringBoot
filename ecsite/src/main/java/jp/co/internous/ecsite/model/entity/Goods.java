package jp.co.internous.ecsite.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@EntityでDBのテーブルと紐づける
@Entity
//@Tableで正しいテーブル名を定義
@Table(name="goods")
public class Goods {
	
	//@IdはPRIMARY KEYのものに必ずつける
	@Id
	//@Columnを付けMappingさせるカラム名を指定
	@Column(name="id")
	//@PRIMARY KEYを生成している
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="price")
	private long price;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price=price;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt=updatedAt;
	}
	
}
