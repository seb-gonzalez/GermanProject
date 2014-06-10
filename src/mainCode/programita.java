package mainCode;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class programita 
{
	private int n_col, n_fil;
	private FileInputStream file;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private ArrayList<little_email> listado;
	
	programita(String file_name) //constructor
	{
		this.listado = new ArrayList<little_email>();
		try
		{
			this.file = new FileInputStream(new File(file_name));
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			
			
			
			
			
			
			//Here I have catched the numbers of columns and rows available on the sheet :)
			n_col = (sheet.getRow(0).getLastCellNum());
        	n_fil = sheet.getLastRowNum()+1; //tengo que anhadirle uno para que lea todo, todito
        	
        	
        	//--------------------------------------------------
        	file.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error! "+e.getMessage());
		}
	}
	
	
	public ArrayList<little_email> visualizar()
	{
		//System.out.println("Pues aqui voy a poner el numero de filas: "+this.n_fil+", y el numero de columnas: "+this.n_col);
		
		for(int i = 1; i<this.n_fil; i++)//empiezo en uno porque no quiero tomar las cabeceras cojones... //EMAIL SUBJECT BODY
		{
			
			
				
				this.listado.add(new little_email(this.sheet.getRow(i).getCell(0).getStringCellValue(),
						this.sheet.getRow(i).getCell(1).getStringCellValue(),
						this.sheet.getRow(i).getCell(2).getStringCellValue()));
			
		}
		
		return this.listado;
		
	}
	

}
