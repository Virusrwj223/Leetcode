import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class martiandna{
	public static void main(String[] args){
		try{
			File myObj = new File("martiandna.txt");
			Scanner myReader = new Scanner(myObj);
			String firstLine = myReader.nextLine();
			firstLine.trim();
			String[] preamble = firstLine.split(" ");
			int rawdnasize = Integer.parseInt(preamble[0]);
			int alphabetsize = Integer.parseInt(preamble[1]);
			
			String secondLine = myReader.nextLine();
			secondLine.trim();
			String[] strDNA = secondLine.split(" ");
			int[] intDNA = new int[strDNA.length];
			for (int i = 0; i < intDNA.length; i++){
				intDNA[i] = Integer.parseInt(strDNA[i]);
			}
			
			int[] histogram = new int[alphabetsize];
			for (int i = 0; i < alphabetsize; i++){
				histogram[i]=0;
			}
			while (myReader.hasNextLine()){
				String data = myReader.nextLine();
				String[] stats = data.split(" ");
				int nucleobase = Integer.parseInt(stats[0]);
				int frequency = Integer.parseInt(stats[1]);
				histogram[nucleobase]=frequency;
				
			
			}
			int[] results = new int[85];//needs better implementation
			for (int z = rawdnasize; z > 0; z--){
				for (int i = 0; i < rawdnasize; i++){
					int[] histogram_copy = new int[alphabetsize];
					for (int j = 0; j < alphabetsize; j++){
						histogram_copy[j] = histogram[j];
					}
					
					int counter = 0;
					for (int j = i; j < z; j++){
						if (histogram_copy[intDNA[j]]!=0){
							histogram_copy[intDNA[j]] = histogram_copy[intDNA[j]]-1;
							counter = counter + 1;

						}else{
							counter = counter + 1;
						}		
					}

					boolean exhausted = true;
					for (int j = 0; j < alphabetsize; j++){
						if(histogram_copy[j]!=0){
							exhausted = false;
							break;
						}else{
							exhausted = true;
						}
					}
					if (exhausted){
						results[i] = counter;
					}
				}
			}

			int smallest_num = results[0];
			for (int i = 0; i < results.length; i++){
				if (i==0 && results[i]==0){
					smallest_num = 0;
				}else if (results[i]<smallest_num && results[i]!=0){
					smallest_num = results[i];
				}
			}
			
			if (smallest_num!=0){
				System.out.println(smallest_num);
			}else{
				System.out.println("impossible");
			}
	
		}catch(FileNotFoundException e){
			System.out.println("An error");
			e.printStackTrace();
		}
	}

}

