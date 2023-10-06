import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MazeController {
	public static void main(String[] args) {
		MazeController controller = new MazeController();
		controller.go();

	}
	
	private List <Integer>coordinates = new ArrayList<Integer>();
	
	public void go() {
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			Scanner input = null;
			try {
				Scanner input2 = new Scanner(file);
			}catch(FileNotFoundException e) {
				
				System.out.println("Could not find the file " + file.getName());
				return;
			}
			Maze maze1 = readMazeFromFile();
			for(int i = 0; i < coordinates.size(); i += 4) {
				int startRow = coordinates.get(i);
				int startCol = coordinates.get(i + 1);
				int endRow = coordinates.get(i + 2);
				int endCol = coordinates.get(i + 3);
				String result = maze1.solve(startRow, startCol, endRow, endCol);
				System.out.println(result);
		}
			}
		}
		
		public Maze readMazeFromFile() {
			File file = getMazeFileFromUser();
			Scanner mazeFile = null;
			try {
				mazeFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			int width = mazeFile.nextInt();
			int height = mazeFile.nextInt();
			String b = mazeFile.nextLine();
			Maze maze2 = new Maze(width, height);
			
			for(int row = 0; row < height; row++) {
				String lr = mazeFile.nextLine();
				for(int column = 0; column < width; column++)
					maze2.set(lr.charAt(column), row, column);
			}
			while(mazeFile.hasNext()) {
				int sr = mazeFile.nextInt();
				int sc = mazeFile.nextInt();
				int er = mazeFile.nextInt();
				int ec = mazeFile.nextInt();
				coordinates.add(sr);
				coordinates.add(sc);
				coordinates.add(er);
				coordinates.add(ec);
				
			}
			
			mazeFile.close();
			
			return maze2;
			
		}
		
		public File getMazeFileFromUser() {
			JFileChooser chooser = new JFileChooser();
			
			int returnVal = chooser.showOpenDialog(null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				
				Scanner input = null;
				try {
					Scanner input2 = new Scanner(file);
				}catch(FileNotFoundException e) {
					
					System.out.println("Could not find the file " + file.getName());
					return;
				}
		}
		}

