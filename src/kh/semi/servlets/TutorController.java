package kh.semi.servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.dao.TutorDAO;
import kh.semi.dto.ClassInfoDTO;


@WebServlet("/tutor")
public class TutorController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		TutorDAO dao = new TutorDAO();
		ClassInfoDTO dto = new ClassInfoDTO();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�뀈 MM�썡 dd�씪 E�슂�씪");
		String time = sdf.format(date);
		//      PrintWriter pw = response.getWriter();


		String rootPath = request.getServletContext().getRealPath("/");
		String filePath = rootPath + "files" ; 
		String filePath2 = filePath + "/"+time;
		File uploadPath1 = new File(filePath);
		if(!uploadPath1.exists()) {
			uploadPath1.mkdir();
		}
		File uploadPath = new File(filePath2);
		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		System.out.println(filePath2);
		//      
		//      String requestURI = request.getRequestURI();
		//      String contextPath = request.getContextPath();
		//      String command = requestURI.substring(contextPath.length());

		try {
			MultipartRequest multi = new MultipartRequest(request, filePath2, 20 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();

			//          String file = (String)files.nextElement();
			//          String file_name = multi.getFilesystemName(file);
			//          String ori_file_name = multi.getOriginalFileName(file);

			dto.setInfo_tutorid((String)request.getSession().getAttribute("loginId"));
			dto.setInfo_category(multi.getParameter("down"));
			dto.setInfo_title(multi.getParameter("inputtitle"));
			dto.setInfo_explain(multi.getParameter("explain"));
			dto.setInfo_intro(multi.getParameter("intro"));
			dto.setInfo_addr1(multi.getParameter("addr1"));
			dto.setInfo_addr2(multi.getParameter("addr2"));
			dto.setInfo_addr3(multi.getParameter("addr3"));
			dto.setInfo_addr4(multi.getParameter("addr4"));
			dto.setInfo_maxperson(Integer.parseInt(multi.getParameter("max")));
			dto.setInfo_price(Integer.parseInt(multi.getParameter("cash")));
			dto.setInfo_img1(multi.getFilesystemName("img"));
			dto.setInfo_img2(multi.getFilesystemName("img2"));
			dto.setInfo_img3(multi.getFilesystemName("img3"));
			dto.setInfo_start(multi.getParameter("startdate"));
			dto.setInfo_end(multi.getParameter("enddate"));

			int result = dao.test(dto);   
			if(result>0) {
				System.out.println("DB�벑濡� �맖");
				request.getRequestDispatcher("ForTutorAfter.jsp").forward(request, response);
			}  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}


