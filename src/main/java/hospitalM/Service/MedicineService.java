package hospitalM.Service;

import java.util.List;

import hospitalM.Model.MedicineModel;


public interface MedicineService {
	public boolean addMedicine(MedicineModel medi);
	public List<MedicineModel>allMedi();
}
