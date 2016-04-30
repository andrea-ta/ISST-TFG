package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.t4.dao.TFGDAO;
import es.upm.dit.isst.t4.dao.TFGDAOImpl;
//import es.upm.dit.isst.t4.model.TFG;
import es.upm.dit.isst.t4.model.TFG;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		TFGDAO dao = TFGDAOImpl.getInstance();
		
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = null;
		String profesor = null;
				
		RequestDispatcher view = req.getRequestDispatcher("MostrarTFGView.jsp");
		
		if (req.getUserPrincipal() != null){
			user = "Hola " + req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			
			if (dao.readAlumno(req.getUserPrincipal().getName()).size() != 0){
					req.getSession().setAttribute("tfgs", new ArrayList<TFG>(dao.readAlumno(req.getUserPrincipal().getName())));
					view = req.getRequestDispatcher("MostrarTFGView.jsp"); 
				
			} else if (dao.readTutor(req.getUserPrincipal().getName()).size() != 0){

				profesor = "si";
				req.getSession().setAttribute("profesor", profesor);
				req.getSession().setAttribute("tfgs", new ArrayList<TFG>(dao.readTutor(req.getUserPrincipal().getName())));
				req.getSession().setAttribute("alerta", null);
			} else{
				view = req.getRequestDispatcher("FormularioNuevoTFG.jsp");
			}
		}
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);

		try {
			view.forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		}

		
	}
}
