package hospitalM.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospitalM.Model.MedicineModel;
import hospitalM.Service.MedicineService;
import hospitalM.Service.MedicineServiceimpl;



/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MedicineService medicineService = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        medicineService = new MedicineServiceimpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "ADD":
			addMedicine(request, response);
			break;
		case "HOME":
			home(request, response);
			//allBus(request, response);
			break;
		case "UPDATE":
			//update(request, response);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}
	
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}
	public void addMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicineModel medicine = new MedicineModel();
		medicine.setPrice(Float.parseFloat(request.getParameter("price")));
		medicine.setName(request.getParameter("medicalname"));
		medicine.setAvl_stock(Integer.parseInt(request.getParameter("stock")));
		medicine.setCategory(request.getParameter("category"));
		medicine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		if(medicineService.addMedicine(medicine)) {
			List<MedicineModel>list = medicineService.allMedi();
			request.setAttribute("medies", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error_messege", "Medicine Failed To Add");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}

}
