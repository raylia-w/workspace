package DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class PaymentDTO {
	
   private String imp_uid;   
   private String merchant_uid;
   private BigDecimal amount;
   private int pay_amount;
   private String pay_method;
   private String pg;
   private String apply_num;
   private String buyer_name;
   private String buy_tel;
   private Date paid_at;
   private String status;
   private String res_id;
   private String s_name;

   public String getS_name() {
	   return s_name;
   }
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getRes_id() {
		return res_id;
	}
   public void setRes_id(String res_id) {
	   this.res_id = res_id;
   }
   public String getStatus() {
	   return status;
   }
   public void setStatus(String status) {
	   this.status = status;
   }
   public String getImp_uid() {
	   return imp_uid;
   }
   public void setImp_uid(String imp_uid) {
      this.imp_uid = imp_uid;
   }
   public String getMerchant_uid() {
      return merchant_uid;
   }
   public void setMerchant_uid(String merchant_uid) {
      this.merchant_uid = merchant_uid;
   }
   public BigDecimal getAmount() {
      return amount;
   }
   public void setAmount(BigDecimal amount) {
      this.amount = amount;
   }
   public int getPay_amount() {
      return pay_amount;
   }
   public void setPay_amount(int pay_amount) {
      this.pay_amount = pay_amount;
   }
   public String getPay_method() {
      return pay_method;
   }
   public void setPay_method(String pay_method) {
      this.pay_method = pay_method;
   }
   public String getPg() {
      return pg;
   }
   public void setPg(String pg) {
      this.pg = pg;
   }
   public String getApply_num() {
      return apply_num;
   }
   public void setApply_num(String apply_num) {
      this.apply_num = apply_num;
   }
   public String getBuyer_name() {
      return buyer_name;
   }
   public void setBuyer_name(String buyer_name) {
      this.buyer_name = buyer_name;
   }
   public String getBuy_tel() {
      return buy_tel;
   }
   public void setBuy_tel(String buy_tel) {
      this.buy_tel = buy_tel;
   }
   public Date getPaid_at() {
      return paid_at;
   }
   public void setPaid_at(Date paid_at) {
      this.paid_at = paid_at;
   }

}