package com.zc.student_dev.Util;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID(String prefix ){
		String id=UUID.randomUUID().toString().replace("-","");
        return prefix+"-"+id;
    }
}
