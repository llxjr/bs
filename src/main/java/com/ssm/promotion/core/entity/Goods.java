package com.ssm.promotion.core.entity;

import java.math.BigInteger;

import com.ssm.promotion.core.entity.base.BaseEntity;

public class Goods  extends BaseEntity{
	
	private int id;
	private  int category_id;
	private int course_id;
	private String goods_name;
	private String goods_no;
	private Double goods_price;
	private BigInteger goods_valid_duration;
	private  int is_not_entity;
	private  int is_blank;
	private  int is_del;
	private String  describe;
	private String goods_img;
	private String detail;
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}
	public BigInteger getGoods_valid_duration() {
		return goods_valid_duration;
	}
	public void setGoods_valid_duration(BigInteger goods_valid_duration) {
		this.goods_valid_duration = goods_valid_duration;
	}
	public int getIs_not_entity() {
		return is_not_entity;
	}
	public void setIs_not_entity(int is_not_entity) {
		this.is_not_entity = is_not_entity;
	}
	public int getIs_blank() {
		return is_blank;
	}
	public void setIs_blank(int is_blank) {
		this.is_blank = is_blank;
	}
	public int getIs_del() {
		return is_del;
	}
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getGoods_img() {
		return goods_img; 
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
