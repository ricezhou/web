package cn.jbit.houserent.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.houserent.biz.IHouseBiz;
import cn.jbit.houserent.biz.IUserBiz;
import cn.jbit.houserent.biz.impl.HouseBizImpl;
import cn.jbit.houserent.biz.impl.UserBizImpl;
import cn.jbit.houserent.entity.House;
import cn.jbit.houserent.entity.HouseCondition;
import cn.jbit.houserent.entity.Info;
import cn.jbit.houserent.entity.PageInfo;
import cn.jbit.houserent.entity.Street;
import cn.jbit.houserent.entity.Users;
import cn.jbit.houserent.util.Tool;

public class ActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ActionServlet() {
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
		request.setCharacterEncoding("utf-8");

		IHouseBiz biz = new HouseBizImpl();
		try {
			String path = request.getServletPath();
			path = path.substring(1, path.lastIndexOf("."));
			if ("login".equals(path)) {
				IUserBiz userBiz = new UserBizImpl();
				Users user = userBiz.login(request.getParameter("name"),
						request.getParameter("password"));
				if (null != user) {
					request.getSession().setAttribute("user", user);
				}
				response.sendRedirect("enter.jsp");
			} else if ("register".equals(path)) {
				IUserBiz userBiz = new UserBizImpl();
				Users user = new Users();
				user.setName(request.getParameter("name"));
				user.setPassword(request.getParameter("password"));
				user.setTelephone(request.getParameter("telephone"));
				userBiz.register(user);
				response.sendRedirect("login.jsp");
			} else if ("search".equals(path)) {
				PageInfo<House> pageInfo = new PageInfo<House>();
				String pageIndexStr = request.getParameter("pageIndex");
				Integer pageIndex = 1;
				if (null != pageIndexStr)
					pageIndex = new Integer(pageIndexStr);
				pageInfo.setPageIndex(pageIndex);
				HouseCondition condition = new HouseCondition();
				if (null != request.getParameter("endPrice")) {
					if (!"".equals(request.getParameter("endPrice")))
						condition.setEndPrice(new Integer(request
								.getParameter("endPrice")));
					if (!"".equals(request.getParameter("startPrice")))
						condition.setStartPrice(new Integer(request
								.getParameter("startPrice")));
					if (!"".equals(request.getParameter("endPubdate")))
						condition.setEndPubdate(Tool.strToDate(
								request.getParameter("endPubdate"),
								"yyyy-MM-dd"));
					if (!"".equals(request.getParameter("startPubdate")))
						condition.setStartPubdate(Tool.strToDate(
								request.getParameter("startPubdate"),
								"yyyy-MM-dd"));
					if (!"".equals(request.getParameter("title")))
						condition.setTitle("%" + request.getParameter("title")
								+ "%");
				}
				pageInfo = biz.search(pageInfo, condition);
				request.setAttribute("pageInfo", pageInfo);
				request.getRequestDispatcher("list.jsp").forward(request,
						response);
			} else if ("find1".equals(path)) {
				List<Info> list = biz.find1(new Integer(request
						.getParameter("price")));
				request.setAttribute("list", list);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else if ("find2".equals(path)) {
				List<Info> list = biz.find2(
						new Short(request.getParameter("typeid")), new Integer(
								request.getParameter("price")));
				request.setAttribute("list", list);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else if ("find3".equals(path)) {
				List<Street> list = biz.find3(new Long(request
						.getParameter("count")));
				request.setAttribute("slist", list);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
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
