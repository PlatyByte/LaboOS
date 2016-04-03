package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import data.InstructionList;

public class Main {

	public static void main(String[] args) {
		//OPGELET OS houdt 1 PT bij per proces
		//Deze waarden zijn de machten. Bij de frame grootte = 2^12 dus we houden 12 bij.
		int grootteFrame = 12;
		//in aantal frames
		int grootteRAM = 12;
		//Een proces bestaat uit max 16 pages en er zijn dus ook 16 entries per PT
		int grootteVirtueel = 16;
		int klok = 0;
		
		File file = new File("Instructions_30_3.xml");

		JAXBContext jaxbContext;
		InstructionList lijst = null;
		try {
			jaxbContext = JAXBContext.newInstance(InstructionList.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			lijst = (InstructionList) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lijst);
	}

}
