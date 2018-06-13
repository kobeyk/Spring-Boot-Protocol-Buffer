package com.appleyk.protocol.utils;

import java.io.IOException;

/**
 * protoc.exe -I=proto的输入目录 --java_out=java类输出目录 proto的输入目录包括包括proto文件
 * 
 * @author Administrator
 *
 */

public class GenerateClass {
	public static void main(String[] args) throws IOException {

		String protoFile = "Student.proto";
		String path = "E:/Spring-boot/Spring-Boot-Protocol-Buffer/src/main/java/com/appleyk/protocol/proto";
		String out = "E:/Spring-boot/Spring-Boot-Protocol-Buffer/src/main/java";
		String strCmd = "D:/protobuf/src/protoc.exe -I=" + path + 
				" --java_out=" + out + " " + path + "/" + protoFile;
		System.out.println(strCmd);
		Runtime.getRuntime().exec(strCmd);
		System.out.println("完成");

	}
}
