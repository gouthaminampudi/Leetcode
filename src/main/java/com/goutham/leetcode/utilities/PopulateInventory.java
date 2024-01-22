package com.goutham.leetcode.utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PopulateInventory {
	
	public static List<Inventory> populateInventory() throws IOException{

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		 
		File file = new File(classLoader.getResource("inventory.txt").getFile());
		
		Scanner input = new Scanner(file);
	    input.useDelimiter("-|\n");

	    Inventory[] inventorys = new Inventory[0];
	    input.next();
	    while(input.hasNext()) {
	    	 String[] tokens = input.next().split(",");
	        String name = tokens[0];
	        double price = Double.valueOf(tokens[1]);
	        String department = tokens[2];
	    	int id = Integer.valueOf(tokens[3]);
	        int stock = Integer.valueOf(tokens[4]);

	        Inventory newInventory = new Inventory(name, price, department, id, stock);
	        inventorys = addInventory(inventorys, newInventory);
	    }

	    input.close();
	    return new ArrayList<Inventory>(Arrays.asList(inventorys));
	    
	    
	}
	
	private static Inventory[] addInventory(Inventory[] Inventorys, Inventory InventoryToAdd) {
	    Inventory[] newInventorys = new Inventory[Inventorys.length + 1];
	    System.arraycopy(Inventorys, 0, newInventorys, 0, Inventorys.length);
	    newInventorys[newInventorys.length - 1] = InventoryToAdd;

	    return newInventorys;
	}
	
	
	public static List<Inventory> getByDepartment(String filter)  {
		List<Inventory> inventorys =null;
		try {
			inventorys = populateInventory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Inventory> filteredList = inventorys.stream()
		.filter(i -> i.getDepartment().equalsIgnoreCase(filter))
		.collect(Collectors.toList());
		
		return filteredList;
	}

	
	
	public static void populatePDF() throws IOException{

		 
		ByteArrayInputStream bos = citiesReport(populateInventory());

 

        //below is the different part
        File someFile = new File("jtest.pdf");
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(new byte[bos.available()]);
        fos.flush();
        fos.close();
	    
	    
	}
	
	 public static ByteArrayInputStream citiesReport(List<Inventory> cities) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {

	            PdfPTable table = new PdfPTable(3);
	            table.setWidthPercentage(60);
	            table.setWidths(new int[]{1, 3, 3});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Id", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Name", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Population", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            for (Inventory city : cities) {

	                PdfPCell cell;

	                cell = new PdfPCell(new Phrase(city.getId()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(city.getName()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(String.valueOf(city.getStock())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                cell.setPaddingRight(5);
	                table.addCell(cell);
	            }

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table);

	            document.close();

	        } catch (DocumentException ex) {

	          //  logger.error("Error occurred: {0}", ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
	

}
