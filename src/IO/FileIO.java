package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileIO {
	/**
	 * IPath - поле для названия входного файла
	 * OPath - поле для выходного файла
	 */
	private String IPath, OPath;
	
	private FileInputStream fin;
	private FileOutputStream fout;
/**
 * Конструктор класса
 * @param IPath
 * @param OPath
 */
	public FileIO(String IPath, String OPath){
		this.IPath = IPath;
		this.OPath = OPath;
	}
	 /**
	  * Метод открытия файла .bin
	  * @return успешность
	  */
	public Boolean OpenBin(){
		try{
			fin = new FileInputStream(IPath);
			
		}catch (FileNotFoundException e) {
			
			System.out.println("File not found! " + IPath);
			
			return false;
		}
		
		return true;
	}
	/**
	 * Чтение из .bin файла
	 * @return список значений
	 */
	public ArrayList<Integer> Read(){
		ArrayList<Integer> list = new ArrayList<>();
		try{
			int i = 0;
			while((i = fin.read()) != -1) {
				list.add(i);
			}
		}catch (Exception e) { System.out.println("File not found! " + IPath); }
		finally {
			try{
				fin.close();
			}catch(Exception x){}
		}
		return list;
	}
	/**
	 * Сохранение результатов
	 * @param data форматированная строка с результатами
	 * @return успешность
	 */
	public Boolean SaveFile(String data){
		File file = new File(OPath);
		try{
			fout = new FileOutputStream(file);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fout.write(data.getBytes());
			System.out.println("Файл успешно сохранен!");
			try{
				fout.close();
				fin.close();
			}catch(Exception e){}
			
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
