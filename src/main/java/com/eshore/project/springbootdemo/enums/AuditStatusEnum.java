package com.eshore.project.springbootdemo.enums;

public enum AuditStatusEnum {

		YBF("YBF","已拜访"),

	    WBF("WBF","未拜访"),

		WDJ("WDJ","未登记"),

		YDJ("YDJ","已登记"),
	
	  	WSH("WSH","未审核"),
	  	
	  	SHTG("SHTG","审核通过"),
	  	
	  	SHBTG("SHBTG","审核不通过"),

		YCH("YCH","已撤回"),

		SHZ("SHZ","审核中");
	  	
	
	private String code;
	private String name;
	
	private AuditStatusEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getNameByCode(String code){
		AuditStatusEnum auditStatusEnum = AuditStatusEnum.valueOf(code);
		String strName="";
		if(auditStatusEnum!=null)
			strName = auditStatusEnum.name;
		return strName;
	}
}

