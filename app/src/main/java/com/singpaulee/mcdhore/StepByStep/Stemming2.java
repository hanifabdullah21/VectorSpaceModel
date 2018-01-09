//package com.singpaulee.mcdhore.StepByStep;
//
///**
// * Created by ASUS on 08/01/2018.
// */
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author riyan
// */
//public class Stemming2 {
//	private final String user = "root";//default user MySql
//	private final String pass = "";//default password Mysql
//	private final String db = "stemming"; //nama database (harus ada)
//	private final String url = "jdbc:mysql://localhost:3306/" + db;
//	private ResultSet rs;
//	private Statement stmt;
//	private Connection con = null;
//
//	private String kataAwal;
//	private String kata;
//	private String akarKata;
//	private final List<String> L = new ArrayList<>();
//	private boolean isHapusSuffix;
//	public boolean cekPrefiksSuffiks;
//	private String bersikan = "";
//
//	public Stemming2() {
//
//	}
//
//	private void Connectdata() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url, user, pass);
//			//System.out.println("Connect Sucessful");
//		} catch (Exception e) {
//			System.out.println("ERROR = " + e);
//		}
//	}
//
//	public void BacaKataDasar() {
//		Connectdata();
//		try {
//			stmt = con.createStatement();
//			String takeString = "SELECT * FROM stemming.katadasar";
//			rs = stmt.executeQuery(takeString);
//			while (rs.next()) {
//				//System.out.println(rs.getString(2));
//				L.add(rs.getString(2));
//			}
//
//
//		} catch (Exception e) {
//			System.out.println("error");
//		}
//
//	}
//
//
//	public void setKata(String kata) {
//		//System.out.println("setKata()"+"dijalankan");
//		kata = kata.toLowerCase();
//		this.kataAwal = kata;
//		this.kata = kata;
//		this.akarKata = kata;
//		bersikan = "";
//	}
//
//	public boolean cekKamus(String kata) {
//		return L.contains(kata);
//	}
//
//	public String KataDasar(String kata) {
//		setKata(kata);
//		if (cekKamus(kata)) {
//			return akarKata;
//		} else {
//			//fungsi 1
//			hapusInfleksionalSuffiks();
//			if (cekKamus(this.kata)) {
//				return akarKata;
//			} else {
//				//fungsi 2
//				hapusDerivationSuffiks();
//				if (cekKamus(this.kata)) {
//					return akarKata;
//				} else {
//					//fungsi3
//					hapusDerivationPrefix();
//					if (cekKamus(this.kata)) {
//						return akarKata;
//					}
//				}
//			}
//		}
//		return akarKata;
//	}
//
//	public void hapusInfleksionalSuffiks() {
//		if (cekKamus(kata)) {
//			akarKata = kata;
//		} else {
//			//akhiran -lah, -kah, -nya, -tah, -pun
//			if (kata.endsWith("lah") || kata.endsWith("kah") || kata.endsWith("nya") || kata.endsWith("tah") || kata.endsWith("pun")) {
//				kata = kata.substring(0, kata.length() - 3);
//				if (cekKamus(kata)) {
//					akarKata = kata;
//				}
//			} else if (kata.endsWith("ku") || kata.endsWith("mu")) {
//				akarKata = kata.substring(0, kata.length() - 2);
//				if (cekKamus(kata)) {
//					akarKata = kata;
//				}
//			}
//		}
//	}
//
//	public void hapusDerivationSuffiks() {
//		if (cekKamus(kata)) {
//			akarKata = kata;
//		} else {
//			if (kata.endsWith("i")) {
//				kata = kata.substring(0, kata.length() - 1);
//
//			} else if (kata.endsWith("an")) {
//				//System.out.println("masuk an");
//				kata = kata.substring(0, kata.length() - 2);
//				if (cekKamus(kata)) {
//					akarKata = kata;
//				} else if (kata.endsWith("k")) {
//					//System.out.println("masuk kan");
//					kata = kata.substring(0, kata.length() - 1);
//
//				}
//			}
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//	}
//
//	public void hapusDerivationPrefix() {
//		kata = kataAwal;
//
//		//4d1. tipe awalan ke 1 : di-, ke-, se-
//		if ((kata.startsWith("di") || kata.startsWith("ke") || kata.startsWith("se")) && kata.length() > 2) {
//			kata = kata.substring(2);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//
//		// Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//		//awalan diper-, keber-, keter-
//		kata = kataAwal;
//		if ((kata.startsWith("diper") || kata.startsWith("keber") || kata.startsWith("keter")) && kata.length() > 5) {
//			kata = kata.substring(5);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//		// Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//		//4d2. tipe awalan ke 2 : be-, te-,
//		kata = kataAwal;
//		if ((kata.startsWith("be") || kata.startsWith("te")) && kata.length() > 2) {
//			kata = kata.substring(2);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//		//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//
//		// awalan bel-, ber-, tel-, ter-
//		kata = kataAwal;
//		if ((kata.startsWith("bel") || kata.startsWith("ber") || kata.startsWith("tel") || kata.startsWith("ter")) && kata.length() > 3) {
//			kata = kata.substring(3);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//		// Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//		//4d3. tipe awalan ke 3 : me-, pe-
//		kata = kataAwal;
//
//		if ((kata.startsWith("me") || kata.startsWith("pe")) && kata.length() > 2) {
//			kata = kata.substring(2);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			} else {
//				//if(men dan pen)
//
//				kata = kataAwal;
//				if ((kata.startsWith("men") || kata.startsWith("pen")) && kata.length() > 3) {
//					kata = kata.substring(3);
//
//					hapusDerivationSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					}
//
//					hapusInfleksionalSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					} else {
//
//
//						//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//						kata = kataAwal;
//						// tambahkan "t" pada awal kata
//						kata = "t" + kata.substring(3);
//						hapusDerivationSuffiks();
//						if (cekKamus(kata)) {
//							akarKata = kata;
//						}
//						hapusInfleksionalSuffiks();
//						if (cekKamus(kata)) {
//							akarKata = kata;
//						}//if meny dan peny
//						else {
//
//							kata = kataAwal;
//							if ((kata.startsWith("meny") || kata.startsWith("peny")) && kata.length() > 4) {
//
//								//            kata = kata.substring(4);
//								//            hapusDerivationSuffiks();
//								//            if(cekKamus(kata)){
//								//                akarKata= kata;
//								//            }
//								//            hapusInfleksionalSuffiks();
//								//            if(cekKamus(kata)){
//								//                akarKata= kata;
//								//            }
//								// Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//								kata = kataAwal;
//								// tambahkan "s" pada awal kata
//								kata = "s" + kata.substring(4);
//								hapusDerivationSuffiks();
//								if (cekKamus(kata)) {
//									akarKata = kata;
//								}
//								hapusInfleksionalSuffiks();
//								if (cekKamus(kata)) {
//									akarKata = kata;
//								}
//
//							}
//							//else if(meng peng)
//							else if ((kata.startsWith("meng") || kata.startsWith("peng")) && kata.length() > 4) {
//
//								kata = kata.substring(4);
//								hapusDerivationSuffiks();
//								if (cekKamus(kata)) {
//									akarKata = kata;
//								}
//								hapusInfleksionalSuffiks();
//								if (cekKamus(kata)) {
//									akarKata = kata;
//								} else {
//
//									//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//									kata = kataAwal;
//
//									// tambahkan "k" pada awal kata
//									kata = "k" + kata.substring(4);
//									hapusDerivationSuffiks();
//									if (cekKamus(kata)) {
//										akarKata = kata;
//									}
//									hapusInfleksionalSuffiks();
//									if (cekKamus(kata)) {
//										akarKata = kata;
//									}
//								}
//							}
//						}
//					}
//
//				}
//				//else if(mel - per)
//
//				kata = kataAwal;
//				if ((kata.startsWith("mel") || kata.startsWith("mer") || kata.startsWith("per") || kata.startsWith("pel")) && kata.length() > 3) {
//
//					kata = kata.substring(3);
//					hapusDerivationSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					}
//					hapusInfleksionalSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					}
//				}
//				//else if (mem pem)
//
//				kata = kataAwal;
//				//4d3f. awalan men-, pen-
//				if ((kata.startsWith("mem") || kata.startsWith("pem")) && kata.length() > 3) {
//
//					kata = kata.substring(3);
//					hapusDerivationSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					}
//					hapusInfleksionalSuffiks();
//					if (cekKamus(kata)) {
//						akarKata = kata;
//					} else {
//
//						//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//						kata = kataAwal;
//
//						// tambahkan "k" pada awal kata
//						kata = "p" + kata.substring(3);
//						hapusDerivationSuffiks();
//						if (cekKamus(kata)) {
//							akarKata = kata;
//						}
//						hapusInfleksionalSuffiks();
//						if (cekKamus(kata)) {
//							akarKata = kata;
//						}
//					}
//				}
//			}
//		}
//
//		//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//		//4d3a. awalan mempel-
//		kata = kataAwal;
//		if ((kata.startsWith("mempel")) && kata.length() > 6) {
//			kata = kata.substring(6);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//		//Jika kata dasar tidak ditemukan, maka kembalikan menjadi kata asal untuk percobaan berikutnya
//
//		//4d3b. awalan memper-
//		kata = kataAwal;
//		if ((kata.startsWith("memper")) && kata.length() > 6) {
//			kata = kata.substring(6);
//			hapusDerivationSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//			hapusInfleksionalSuffiks();
//			if (cekKamus(kata)) {
//				akarKata = kata;
//			}
//		}
//
//
//	}
//
//	public String getAkarKata() {
//		return this.akarKata;
//	}
//
//	public String getKataAwal() {
//		return this.kataAwal;
//	}
//
//	public List<String> getList() {
//		return L;
//	}
//}
//
//
//
