package com.varunmurthy.greedyalgos;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {

	int numberOfJobs;
	ArrayList<Job> jobs = new ArrayList<Job>();

	class Job implements Comparable<Job> {
		int weight;
		int length;
		double rank;
		double completionTime;

		public Job(int w, int l) {
			weight = w;
			length = l;
			rank = (double) weight / length;
		}

		public int compareTo(Job j) {
			if (this.rank < j.rank) {
				return -1;
			} else if (this.rank == j.rank) {
				if (this.weight < j.weight) {
					return -1;
				} else if (this.weight == j.weight) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}

	//".//jobs.txt"
	public void read(String filename) {
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			numberOfJobs = fileScanner.nextInt();
			while (fileScanner.hasNextLine()) {
				int w = fileScanner.nextInt();
				int l = fileScanner.nextInt();
				jobs.add(new Job(w, l));
			}

			fileScanner.close();

		} catch (Exception e) {
			System.out.print("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public double sumOfCompletionTimes() {
		double sum = 0;
		double completionTime = 0;
		for (int i = 0; i< numberOfJobs; i++) {
			completionTime += jobs.get(i).length;
			
			jobs.get(i).completionTime = completionTime;
//			System.out.println(jobs.get(i).completionTime);
			
			
			sum += jobs.get(i).weight * completionTime;
			
		}
		return sum;
	}

	public void printValues() {
		for (Job i : jobs) {
			System.out.println("Rank: " + i.rank +" Completion Time: " + i.completionTime + " Weight: " + i.weight
					+ " Length: " + i.length);
		}
	}

	public static void main(String[] argv) {
		Scheduler scheduler = new Scheduler();
		scheduler.read(".//jobs.txt");
		Collections.sort(scheduler.jobs, Collections.reverseOrder());
		System.out.println(scheduler.sumOfCompletionTimes());
//		scheduler.printValues();
	}
}
