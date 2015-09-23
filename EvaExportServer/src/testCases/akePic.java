package testCases;

import java.io.IOException;

import pictures.MakePictures;

import controlller.EvaDB;

import util.Setup;

public class akePic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Setup.makeSetup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EvaDB.getVehicles();

		
		MakePictures.makePics(EvaDB.getCars());

	}

}
