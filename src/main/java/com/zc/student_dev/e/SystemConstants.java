package com.zc.student_dev.e;

import lombok.Getter;

public class SystemConstants {

	@Getter
	public enum RoleEnum {
		SYSTEM_ADMIN(1,"system:admin"),
		COMPANY_ADMIN(2,"company:admin"),
		DEPARTMENT_ADMIN(3,"department:admin"),
		ORDINARY_USER(4,"ordinary:user"),
		;
		/** 角色id */
		private Integer id;
		/** 角色code */
		private String code;

		RoleEnum(Integer id, String code) {
			this.id = id;
			this.code = code;
		}

		public static RoleEnum roleEnumOf(Integer index){
			for(RoleEnum roleEnum:values()){
				if(roleEnum.getId() == index){
					return roleEnum;
				}
			}
			return null;
		}
	}

	@Getter
	public enum AppDomainEnum {
		PRIVATE(1,"私有"),
		PUBLIC(2,"公开");
		/** 状态 */
		private Integer status;
		/** 说明 */
		private String msg;

		AppDomainEnum(Integer status, String msg) {
			this.status = status;
			this.msg = msg;
		}

		public static AppDomainEnum appDomainEnumOf(Integer index){
			for(AppDomainEnum appDomainEnum:values()){
				if(appDomainEnum.getStatus() == index){
					return appDomainEnum;
				}
			}
			return null;
		}
	}

	@Getter
	public enum RoleTypeEnum {
		SYSTEM_ADMIN(1,"系统级"),
		COMPANY_ADMIN(2,"公司级"),
		DEPARTMENT_ADMIN(3,"部门级"),
		ORDINARY_USER(4,"用户级"),
		;
		/** 角色类型 */
		private Integer id;
		/** 角色类型描述 */
		private String code;

		RoleTypeEnum(Integer id, String code) {
			this.id = id;
			this.code = code;
		}

		public static RoleTypeEnum roleEnumOf(Integer index){
			for(RoleTypeEnum roleTypeEnum:values()){
				if(roleTypeEnum.getId() == index){
					return roleTypeEnum;
				}
			}
			return null;
		}
	}
}
