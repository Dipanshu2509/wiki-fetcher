package tech.codingclub.utility.GeneralClasses;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithPath)
    {
        File file = new File(fileNameWithPath);
        boolean filecreated=false;
        try{

          filecreated=file.createNewFile();
    }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return filecreated;
    }
    public static ArrayList<String> readFileAsList(String filename) {
        Scanner scanner=null;
        ArrayList<String> strings = new ArrayList<String>();
        try
        {
            File file = new File(filename);
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line =scanner.nextLine();
                strings.add(line);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(scanner!=null)
            {
                scanner.close();
            }
        }
        return  strings;
    }
    public static boolean writeToFile(String fileNameWithPath,String content) {
//        BufferedWriter bw=null;
//        try{
//            File file = new File(fileNameWithPath);
//            if(!file.exists())
//            {
//                file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            bw=new BufferedWriter(fw);
//            bw.write(content);
//        }
//        catch (IOException e)
//        {
//            return false;
//        }
//        finally {
//            if(bw!=null) {
//                try{
//                    bw.close();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
        try{
            FileWriter fileWriter=new FileWriter(fileNameWithPath);
            fileWriter.append(content);
            fileWriter.close();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static boolean appendToFile(String filename,String content)
    {
        try{
            FileWriter fileWriter=new FileWriter(filename,true);
            fileWriter.append("\n");
            fileWriter.append(content);
            fileWriter.close();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("This is Dhanashri Jadhav");
        System.out.println("running at:"+new Date().toString());
        String nameofFile="C:\\Users\\Dhanashri\\IdeaProjects\\TechCodingMafia\\data\\practice\\file"+"create-file.txt";
        Boolean created=createFile(nameofFile);
        System.out.println("File created:"+created);
        ArrayList<String> stringArrayList=readFileAsList(nameofFile);
        for(String row:stringArrayList)
        {
            System.out.println("Line:"+row);
        }
        System.out.println("No of lines:"+stringArrayList.size());
        String nameofWriteFile="C:\\Users\\Dhanashri\\IdeaProjects\\TechCodingMafia\\data\\practice\\file"+"write-file.txt";
        boolean writeToFile=writeToFile(nameofWriteFile,"This side is dhanu");
        System.out.println(writeToFile);
        for(int i=1;i<=100;i++)
        {
            String data=i+"";
            appendToFile(nameofWriteFile,data);
        }
        System.out.println("Appended file length:"+readFileAsList(nameofWriteFile).size());
    }


}
