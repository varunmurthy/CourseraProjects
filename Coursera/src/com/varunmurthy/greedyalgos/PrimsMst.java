package com.varunmurthy.greedyalgos;

import java.io.File;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.varunmurthy.greedyalgos.Scheduler.Job;

public class PrimsMst {
	
	int numberOfNodes;
	int numberOfEdges;
	HashMap<Integer, PriorityQueue<Integer>> primmap = new HashMap<Integer, PriorityQueue<Integer>>();
	
	public void read(String filename) {
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			int vertexNum = fileScanner.nextInt();
			int destVertexNum = fileScanner.nextInt();
			numberOfEdges = fileScanner.nextInt();
			
			
			while (fileScanner.hasNextLine()) {
				int w = fileScanner.nextInt();
				int l = fileScanner.nextInt();
				PriorityQueue p = new PriorityQueue
				primmap.put(vertexNum, )
			}

			fileScanner.close();

		} catch (Exception e) {
			System.out.print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	} 
}
