package co.seonae.board.common;

import javax.servlet.http.Part;

public class FileUtil {
//여러사람이 불러쓰는 경우 만들라어쩌고웅앵
	   private static String extractFileName(Part part) {
		      String contentDisp = part.getHeader("content-disposition");
		      String[] items = contentDisp.split(";");
		      for (String s : items) {
		         if (s.trim().startsWith("filename")) {
		            return s.substring(s.indexOf("=") + 2, s.length() - 1);
		         }
		      }
		      return "";
		   }
}
