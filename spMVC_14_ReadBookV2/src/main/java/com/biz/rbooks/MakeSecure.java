package com.biz.rbooks;

import java.awt.print.Printable;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeSecure {

	private static final String saltPass = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// 운영체제 환경볁수 가져오기
		Map<String, String> envList = System.getenv();

		System.out.print("UserID >>");
		String pUserId = scanner.nextLine();
		System.out.print("Password >>");
		String pPassword = scanner.nextLine();

		// 운영체제 환경변수 중 ORACLE_PASS로 등록된 이름 가져오기
		String envString = envList.get("ORACLE_PASS");

		if (envString == null)
			envString = saltPass;

		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envString);

		String encUserId = pbEnc.encrypt(pUserId);
		String encPassword = pbEnc.encrypt(pPassword);

		System.out.printf("userid : %s, %s\n", pUserId, encUserId);
		System.out.printf("userpassword: %s, %s", pPassword, encPassword);

		String strUserId = String.format("oracle.username=ENC(%s)", encUserId);
		String strPassword = String.format("oracle.password=ENC(%s)", encPassword);

		String proFileName = "./src/main/webapp/WEB-INF/spring/oracle.sec.properties";

		try {
			PrintWriter pw = new PrintWriter(proFileName);
			pw.println(strUserId);
			pw.println(strPassword);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.close();

	}
}
