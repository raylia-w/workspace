package mvc.DTO;

import lombok.Data;

@Data
public class Payment {
	
	private int payment_no;
	
	private String imp_uid;
	
	private String merchant_uid;
	
	private int amount;
	
	private String pay_method;
	
	private String pg;
	
	private String apply_num;
	
	private String buyer_name;
	
	private String buyer_tel;
	
	private String paid_at;
	
	private String status;
	
	private String res_id;
	
	private String company_name;
	
	private int meeting_no;
	
	private int u_no;
	
}
