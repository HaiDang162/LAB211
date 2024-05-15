/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;
import java.util.Scanner;

/**
 *
 * @author Phan Văn Dõi
 */
public class MyTool {
    public static  Scanner sc = new Scanner(System.in);
    
    
public static String getString(String inputMsg, String errorMsg) {
        String title;        
        while (true) {
            System.out.print(inputMsg);
            title = sc.nextLine().trim();            
            if ( title.isEmpty())
                System.out.println(errorMsg);
            else 
                return title;
        }
    }


    public static int getAnInteger(String inputMsg, String errorMsg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static String updatString (String inputMsg, String oldData) {
        String result = oldData;
        System.out.printf(inputMsg);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }
    public static double updateADoule(String inputMsg, double min, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                System.out.print(inputMsg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true || number < min );
        return number;
    }
    
    public static int updatAnInteger(String inputMsg, int oldData) {
        boolean check =  true;
        int number = oldData;
        do {
            try {
                System.out.print(inputMsg);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true) ;
        return number;
    }
}
    

  



        
    
    

