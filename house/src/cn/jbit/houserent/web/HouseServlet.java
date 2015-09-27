package cn.jbit.houserent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.houserent.biz.IHouseBiz;
import cn.jbit.houserent.biz.impl.HouseBizImpl;
import cn.jbit.houserent.entity.Info;
import cn.jbit.houserent.entity.Street;

public class HouseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			path = path.substring(1, path.lastIndexOf("."));
			IHouseBiz biz=new HouseBizImpl();
			if ("find1".equals(path)) {
				List<Info> list = biz.find1(new Integer(request.getParameter("price")));
				request.setAttribute("list", list);
			}else if("find2".equals(path)){
				List<Info> list = biz.find2(new Short(request.getParameter("typeid")), new Integer(request.getParameter("price")));
				request.setAttribute("list", list);
			}else if("find3".equals(path)){
				List<Street> list = biz.find3(new Long(request.getParameter("count")));
				request.setAttribute("slist", list);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
