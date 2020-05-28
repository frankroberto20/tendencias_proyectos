import java.io.*;
class HelloWorld{
    public static void main(String[] args) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            while((line = br.readLine()) != null){
                if(line.length() > 10){
                    System.out.println(line);
                }
                else{
                    System.err.println("Error: " + line);
                }
            } 
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}