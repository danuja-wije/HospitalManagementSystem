package hospitalM.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hospitalM.Model.MedicineModel;
import hospitalM.Utill.DBConecctionUtil;




public class MedicineServiceimpl implements MedicineService {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement prearedStatement = null;
	private static List<MedicineModel> list = null;
	private MedicineModel medicineModel = null;
	@Override
	public boolean addMedicine(MedicineModel medi) {
		boolean flag = false;

		try {

			//declare query
			String sql = "INSERT INTO `medicine` (`sNo`, `Name`, `Category`, `Price`, `Quantity`) VALUES (NULL,'"+medi.getName()+"', '"+medi.getCategory()+"', '"+medi.getPrice()+"', '"+medi.getQuantity()+"')";
			
			
			
			connection = DBConecctionUtil.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);

//			System.out.println(s.getAccNum());

			prearedStatement.execute();
			flag = true;

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			//close the connection and preparedstatement
			 
			 
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}
	@Override
	public List<MedicineModel> allMedi() {
		list = new ArrayList<MedicineModel>();
		try {
				//declare query
			String sql = "SELECT * FROM `bus`";

			connection = DBConecctionUtil.createConnection(); //open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql); //excecute query

			while (resultSet.next()) {
				medicineModel = new MedicineModel();

				medicineModel.setName(resultSet.getString("Name"));
				medicineModel.setCategory(resultSet.getString("Category"));
				medicineModel.setPrice(resultSet.getFloat("Price"));
				medicineModel.setQuantity(resultSet.getInt("Quantity"));
				medicineModel.setId(resultSet.getInt("sNo"));
				list.add(medicineModel);
			}
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}

}
