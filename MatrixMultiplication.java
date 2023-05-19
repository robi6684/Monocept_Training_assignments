package com.monocept.array;

import java.util.Scanner;

public class MatrixMultiplication {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of rows of first matrix");
		int row1 = scanner.nextInt();
		
		System.out.println("Enter number of columns of first matrix");
		int column1 = scanner.nextInt();
		
		System.out.println("Enter first matrix elements");
		
		int first_matrix[][] = new int[row1][column1];
		
		for(int i=0; i<row1; i++)
		{
			for(int j=0; j<column1; j++)
				first_matrix[i][j] = scanner.nextInt();
		}
		
		System.out.println("Enter number of rows of second matrix");
		int row2 = scanner.nextInt();
		
		System.out.println("Enter number of columns of second matrix");
		int column2 = scanner.nextInt();
		
		System.out.println("Enter second matrix elements");
		
		int second_matrix[][] = new int[row2][column2];
		
		for(int i=0; i<row2; i++)
		{
			for(int j=0; j<column2; j++)
				second_matrix[i][j] = scanner.nextInt();
		}
		
		if(column1 != row2)
		{
			System.out.println("Matrix multiplication is not possible");
			System.out.println("Columns in matrix 1 should be equal to rows in matrix 2");
			System.exit(0);
		}
		
		int result_matrix[][] = new int[row1][column2];
		
		System.out.println("Matrix Multiplication :");
		
        	for (int i = 0; i < row1; i++) {
            		for (int j = 0; j < column2; j++) {
               	 		for (int k = 0; k < row2; k++)
                    			result_matrix[i][j] += first_matrix[i][k] * second_matrix[k][j];
                		System.out.print(result_matrix[i][j] + " ");
            		}
            		System.out.println("");
       		}
			
		
		scanner.close();
	}

}
